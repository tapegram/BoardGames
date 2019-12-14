package boardgame

fun checkers(block: CheckersBuilder.() -> Unit): BoardGame = CheckersBuilder().apply(block).build()


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
    lateinit var dimensions: Pair<Int, Int>

    fun build(): Board = Board(
        board=List(dimensions.first) { List(dimensions.second) { Space.Empty } }
    )
}
