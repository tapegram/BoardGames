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

typealias Board2D = List<List<Space>>
fun Board2D.set(coord: Coord, space: Space) = this.replace(
    coord.rank,
    this[coord.rank].replace(
        coord.file,
        space
    )
)
fun Board2D.get(coord: Coord) = this[coord.rank][coord.file]

data class Board(
    val board: Board2D
) {
    fun makeMove(move: Move): Board =
        this.copy(
            board=board
                .set(move.to, board.get(move.from))
                .set(move.from, Space.Empty)
        )

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

