import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DateUtilsTest {

    @Test
    fun testDaysBetween() {
        val result = DateUtils.daysBetween("2025-01-01", "2025-01-11")
        assertEquals(10, result)
    }

    @Test
    fun testIsLeapYear() {
        assertTrue(DateUtils.isLeapYear(2024))
        assertFalse(DateUtils.isLeapYear(2023))
    }

    @Test
    fun testAddDays() {
        val newDate = DateUtils.addDays("2025-01-01", 5)
        assertEquals("2025-01-06", newDate)
    }

    @Test
    fun testGetDayOfWeek() {
        val actual = DateUtils.getDayOfWeek("2025-01-01")
        assertEquals("WEDNESDAY", actual)
    }

    @Test
    fun testFormatDate() {
        val formatted = DateUtils.formatDate("2025-10-13", "dd.MM.yyyy")
        assertEquals("13.10.2025", formatted)
    }
}
