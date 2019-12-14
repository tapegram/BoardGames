package boardgame

data class Player(
    val name: String
)

data class BoardGame(
    val board: Board,
    val players: Pair<Player, Player>,
    val currentTurn: Player,
    val winConditions: List<WinCondition>
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
    fun makeMove(move: Move): Board {
        if (!can_make_move(move)) {
            return this
        }
        val space = board[move.x][move.y]
        return when (space) {
            is Space.Occupied -> this
            is Space.Empty -> this
        }
    }

    private fun can_make_move(move: Move): Boolean = true

}

data class Piece(
    val moves: List<Move>
)

data class Move(
    val x: Int,
    val y: Int
)

