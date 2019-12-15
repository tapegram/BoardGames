package boardgame.checkers

import boardgame.Board
import boardgame.BoardGame
import boardgame.BoardState
import boardgame.Piece
import boardgame.Space
import boardgame.checkers
import org.amshove.kluent.shouldEqual
import org.junit.jupiter.api.Test


class DSLTest {
    @Test
    fun `instantiate a default 8x8 board`() {
        val checkers = checkers {
            board {
                boardState = BoardState.Initial
            }
        }

        val checker = Piece(listOf())
        checkers shouldEqual BoardGame(
            Board(
                listOf(
                    listOf(
                        Space.Occupied(checker),
                        Space.Empty,
                        Space.Occupied(checker),
                        Space.Empty,
                        Space.Occupied(checker),
                        Space.Empty,
                        Space.Occupied(checker),
                        Space.Empty
                    ),
                    listOf(
                        Space.Empty,
                        Space.Occupied(checker),
                        Space.Empty,
                        Space.Occupied(checker),
                        Space.Empty,
                        Space.Occupied(checker),
                        Space.Empty,
                        Space.Occupied(checker)
                    ),
                    listOf(
                        Space.Empty,
                        Space.Empty,
                        Space.Empty,
                        Space.Empty,
                        Space.Empty,
                        Space.Empty,
                        Space.Empty,
                        Space.Empty
                    ),
                    listOf(
                        Space.Empty,
                        Space.Empty,
                        Space.Empty,
                        Space.Empty,
                        Space.Empty,
                        Space.Empty,
                        Space.Empty,
                        Space.Empty
                    ),
                    listOf(
                        Space.Empty,
                        Space.Empty,
                        Space.Empty,
                        Space.Empty,
                        Space.Empty,
                        Space.Empty,
                        Space.Empty,
                        Space.Empty
                    ),
                    listOf(
                        Space.Empty,
                        Space.Empty,
                        Space.Empty,
                        Space.Empty,
                        Space.Empty,
                        Space.Empty,
                        Space.Empty,
                        Space.Empty
                    ),
                    listOf(
                        Space.Occupied(checker),
                        Space.Empty,
                        Space.Occupied(checker),
                        Space.Empty,
                        Space.Occupied(checker),
                        Space.Empty,
                        Space.Occupied(checker),
                        Space.Empty
                    ),
                    listOf(
                        Space.Empty,
                        Space.Occupied(checker),
                        Space.Empty,
                        Space.Occupied(checker),
                        Space.Empty,
                        Space.Occupied(checker),
                        Space.Empty,
                        Space.Occupied(checker)
                    )
                )
            )
        )
    }
}
