package boardgame

fun checkers(block: CheckersBuilder.() -> Unit): BoardGame = CheckersBuilder().apply(block).build()
fun checker() = Piece(listOf())


enum class BoardState() {
    Initial,
    Donut
}


class CheckersBuilder {
    private lateinit var board: Board

    fun board(block: BoardBuilder.() -> Unit) {
        board = BoardBuilder().apply(block).build()
    }

    fun build(): BoardGame = BoardGame(
        board = board
    )
}

class BoardBuilder {
    lateinit var boardState: BoardState

    fun build(): Board = Board(
        board = when(boardState) {
            BoardState.Initial -> listOf(
                listOf(
                    Space.Occupied(checker()),
                    Space.Empty,
                    Space.Occupied(checker()),
                    Space.Empty,
                    Space.Occupied(checker()),
                    Space.Empty,
                    Space.Occupied(checker()),
                    Space.Empty
                ),
                listOf(
                    Space.Empty,
                    Space.Occupied(checker()),
                    Space.Empty,
                    Space.Occupied(checker()),
                    Space.Empty,
                    Space.Occupied(checker()),
                    Space.Empty,
                    Space.Occupied(checker())
                ),
                List(8) { Space.Empty },
                List(8) { Space.Empty },
                List(8) { Space.Empty },
                List(8) { Space.Empty },
                listOf(
                    Space.Occupied(checker()),
                    Space.Empty,
                    Space.Occupied(checker()),
                    Space.Empty,
                    Space.Occupied(checker()),
                    Space.Empty,
                    Space.Occupied(checker()),
                    Space.Empty
                ),
                listOf(
                    Space.Empty,
                    Space.Occupied(checker()),
                    Space.Empty,
                    Space.Occupied(checker()),
                    Space.Empty,
                    Space.Occupied(checker()),
                    Space.Empty,
                    Space.Occupied(checker())
                )
            )

            BoardState.Donut -> listOf(
                List(3) { Space.Empty },
                listOf(
                    Space.Empty,
                    Space.Occupied(checker()),
                    Space.Empty
                ),
                List(3) { Space.Empty }
            )
        }
    )
}
