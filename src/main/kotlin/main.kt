fun main() {
    println(trans(card = "MasterCard",pastTrasfers= 7000,transfer = 2000))
}

fun trans(card: String = "VK Pay", pastTrasfers: Int = 0, transfer: Int): Int {
    return if (card == "MasterCard" || card == "Maestro") {
        if (pastTrasfers + transfer < 75000) transfer
        else (transfer * 0.94 + 20).toInt()
    } else transfer
}