package boardgame

data class Player(
    val name: String
)

data class BoardGame(
    val board: Board
) {
    fun makeMove(move: Move): BoardGame {
        return this.copy(
            board=board.makeMove(move)
        )
    }
}

fun <E> Iterable<E>.replace(index: Int, new: E) = mapIndexed { i, e -> if (i == index) new else e }

data class Board(
    val board: List<List<Space>>
) {
    fun makeMove(move: Move): Board =
        set(move.to, get(move.from))
            .set(move.from, Space.Empty)

    private fun get(coord: Coord): Space =
        board[coord.rank][coord.file]

    private fun set(coord: Coord, space: Space): Board {
        return this.copy(
            board=board.replace(
                coord.rank,
                board[coord.rank].replace(
                    coord.file,
                    space
                )
            )
        )
    }

}

sealed class Space {
    data class Occupied(val piece: Piece) : Space()
    object Empty : Space()
}

data class Piece(
    val moves: List<Move>
)

data class Move(
    val from: Coord,
    val to: Coord
)

data class Coord(
    val rank: Int,
    val file: Int
)

