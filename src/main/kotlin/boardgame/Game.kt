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

interface WinCondition

sealed class Space {
    data class Occupied(val piece: Piece) : Space()
    object Empty : Space()
}

data class Board(
    val board: List<List<Space>>
) {
    fun makeMove(move: Move): Board = TODO()
}

data class Piece(
    val moves: List<Move>
)

data class Move(
    val x: Int,
    val y: Int
)

