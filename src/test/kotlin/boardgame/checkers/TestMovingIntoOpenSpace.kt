package boardgame.checkers

import boardgame.Board
import boardgame.BoardGame
import boardgame.BoardState
import boardgame.Coord
import boardgame.IllegalMove
import boardgame.Move
import boardgame.Space
import boardgame.checker
import boardgame.checkers
import org.amshove.kluent.invoking
import org.amshove.kluent.shouldEqual
import org.amshove.kluent.shouldHaveTheSameClassAs
import org.amshove.kluent.shouldThrow
import org.junit.jupiter.api.Test

class MoveIntoOpenSpaceTest {
    @Test
    fun `can move forward-left into an open spot`() {
        val checkers = checkers {
            board {
                boardState = BoardState.Donut
            }
        }

        checkers.makeMove(
            Move(
                Coord(1, 1),
                Coord(0, 0)
            )
        ) shouldEqual BoardGame(
            board = Board(
                listOf(
                    listOf(
                        Space.Occupied(checker()),
                        Space.Empty,
                        Space.Empty
                    ),
                    List(3) { Space.Empty },
                    List(3) { Space.Empty }
                )
            )
        )
    }

    @Test
    fun `can move forward-right into an open spot`() {
        val checkers = checkers {
            board {
                boardState = BoardState.Donut
            }
        }

        checkers.makeMove(
            Move(
                Coord(1, 1),
                Coord(0, 2)
            )
        ) shouldEqual BoardGame(
            board = Board(
                listOf(
                    listOf(
                        Space.Empty,
                        Space.Empty,
                        Space.Occupied(checker())
                    ),
                    List(3) { Space.Empty },
                    List(3) { Space.Empty }
                )
            )
        )
    }

    @Test
    fun `can not move forward into an open spot`() {
        val checkers = checkers {
            board {
                boardState = BoardState.Donut
            }
        }

        invoking {
            checkers.makeMove(
                Move(
                    Coord(1, 1),
                    Coord(0, 1)
                )
            )
        } shouldThrow IllegalMove::class
    }
}
