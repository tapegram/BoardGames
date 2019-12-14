package boardgame

import org.amshove.kluent.shouldEqual
import org.junit.jupiter.api.Test


class GameTest {
    @Test
    fun `hello world`() {
        Game(id="123").say_hello() shouldEqual "Hello, World"
    }
}