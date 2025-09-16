import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val converter = CurrencyConverter()

    println("=== Конвертер валют ===")
    println("Поддерживаемые валюты: RUB, USD, EUR, CNY")

    while (true) {
        print("Введите сумму: ")
        val amountInput = scanner.nextLine()

        // Ошибка №2: программа упадет, если ввести текст вместо числа
        val amount = amountInput.toDouble()

        print("Введите исходную валюту: ")
        val fromCurrency = scanner.nextLine().uppercase()

        print("Введите целевую валюту: ")
        val toCurrency = scanner.nextLine().uppercase()

        val result = converter.convert(amount, fromCurrency, toCurrency)

        // Ошибка №6: слишком много знаков после запятой
        println("$amount $fromCurrency = $result $toCurrency")

        println("\nДля продолжения введите любую клавишу (Ctrl+C для выхода)")
        scanner.nextLine()
        // Ошибка №7: нет команды выхода, программа работает бесконечно
    }
}

class CurrencyConverter {
    private val rates = mapOf(
        "RUB" to 1.0,
        "USD" to 95.0,    // 1 USD = 95 RUB
        "EUR" to 50.0,    // Ошибка №3: неправильный курс (должно быть ~100)
        "CNY" to 13.0
    )

    fun convert(amount: Double, from: String, to: String): Double {
        if (!rates.containsKey(from) || !rates.containsKey(to)) {
            println("Неверная валюта!")
            return 0.0
        }

        val fromRate = rates[from]!!
        val toRate = rates[to]!!

        // Ошибка №4: неправильное направление пересчёта
        // Должно быть: amount * fromRate / toRate
        val result = amount * toRate / fromRate

        // Ошибка №1: округление результата до целого числа
        return result.toInt().toDouble()
    }
}
