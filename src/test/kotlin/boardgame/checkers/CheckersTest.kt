package boardgame.checkers

import boardgame.Board
import boardgame.BoardGame
import boardgame.Player
import boardgame.Space
import org.amshove.kluent.shouldEqual
import org.junit.jupiter.api.Test


class CheckersTest {
    @Test
    fun `create a 2x2 board`() {
        val checkers = BoardGame(
            board = Board(
                listOf(
                    listOf(Space.Empty, Space.Empty),
                    listOf(Space.Empty, Space.Empty)
                )
            ),
            players = Pair(Player("One"), Player("Two")),
            currentTurn = Player("One"),
            winConditions = listOf()
        )
    }
}