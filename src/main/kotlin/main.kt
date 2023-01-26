import kotlin.math.max

fun main() {
    println(trans(card = "MasterCard", pastTrasfers = 7000, transfer = 2000))
}

fun trans(card: String = "VK Pay", pastTrasfers: Int = 0, transfer: Int): Int =
    when (card) {
        "MasterCard", "Maestro" -> {
            if (transfer < 150_000 && pastTrasfers + transfer <= 600_000) {
                if (pastTrasfers + transfer < 75000) transfer
                else (transfer * 0.94 + 20).toInt()
            } else -2
        }
        "Visa", "Мир" -> {
            if (transfer < 150_000 && pastTrasfers + transfer <= 600_000) {
                max(35, (transfer * 0.0075).toInt())
            } else -2
        }
        "VK Pay" -> {
            if (transfer < 150_000 && pastTrasfers + transfer <= 600_000) {
                transfer
            } else -2
        }
        else -> {
            -1
        }
    }
