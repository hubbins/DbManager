import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull


class CommandLineUtilTest {

    @Test
    fun stringParamFound() {
        val args = arrayOf("/a:b", "/c:d")
        assertEquals("b", com.hubbins.paramutil.param("a", null, args))
        assertEquals("d", com.hubbins.paramutil.param("c", null, args))
    }

    @Test
    fun stringParamDefault() {
        val args = arrayOf("/a:b", "/c:d")
        assertEquals("test", com.hubbins.paramutil.param("something", "test", args))
        assertNull(com.hubbins.paramutil.param("something", null, args))
    }

    @Test
    fun intParamFound() {
        val args = arrayOf("/a:123", "/c:d")
        assertEquals(123, com.hubbins.paramutil.param("a", 0, args))
    }

    @Test
    fun intParamDefault() {
        val args = arrayOf("/a:123", "/c:d")
        assertEquals(456, com.hubbins.paramutil.param("c", 456, args))
    }

    @Test
    fun argFound() {
        val args = arrayOf("/a", "/c:d")
        assertTrue(com.hubbins.paramutil.param("a", args))
    }

    @Test
    fun argNotFound() {
        val args = arrayOf("/a", "/c:d")
        assertFalse(com.hubbins.paramutil.param("test", args))
    }
}
