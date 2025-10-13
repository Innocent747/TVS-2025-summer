import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

object DateUtils {

    // Разница между датами в днях
    fun daysBetween(start: String, end: String): Long {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val startDate = LocalDate.parse(start, formatter)
        val endDate = LocalDate.parse(end, formatter)
        return ChronoUnit.DAYS.between(startDate, endDate)
    }

    // Проверка високосного года
    fun isLeapYear(year: Int): Boolean {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)
    }

    // Добавление дней к дате
    fun addDays(date: String, days: Long): String {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val localDate = LocalDate.parse(date, formatter)
        return localDate.plusDays(days).format(formatter)
    }

    // Определение дня недели по дате (с преднамеренной ошибкой)
    fun getDayOfWeek(date: String): String {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val localDate = LocalDate.parse(date, formatter)
        // Ошибка: возвращаем предыдущий день недели вместо текущего
        return localDate.dayOfWeek.toString()
    }

    // Форматирование даты в другой формат
    fun formatDate(date: String, newPattern: String): String {
        val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val outputFormatter = DateTimeFormatter.ofPattern(newPattern)
        val parsedDate = LocalDate.parse(date, inputFormatter)
        return parsedDate.format(outputFormatter)
    }
}
