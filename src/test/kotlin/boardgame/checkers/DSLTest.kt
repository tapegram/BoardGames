package boardgame.checkers

import boardgame.Board
import boardgame.BoardGame
import boardgame.Space
import boardgame.checkers
import org.amshove.kluent.shouldEqual
import org.junit.jupiter.api.Test


class DSLTest {
    @Test
    fun `instantiate an 8x8 empty board`() {
        val checkers = checkers {
            board {
                dimensions = Pair(8, 8)
            }
        }

        checkers shouldEqual BoardGame(
            Board(
                List(8) {
                    List(8) {
                        Space.Empty
                    }
                }
            )
        )
    }

    @Test
    fun `instantiate a 5x10 empty board`() {
        val checkers = checkers {
            board {
                dimensions = Pair(5, 10)
            }
        }

        checkers shouldEqual BoardGame(
            Board(
                List(5) {
                    List(10) {
                        Space.Empty
                    }
                }
            )
        )
    }
}