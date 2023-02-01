import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun transVkPayNoCommision() {
        val card = "VK Pay"
        val pastTrasfers =  0
        val transfer = 3000

        val result = trans(card, pastTrasfers, transfer)

        assertEquals(0, result)
    }

    @Test
    fun transVkPayLimit() {
        val card = "VK Pay"
        val pastTrasfers =  40_000
        val transfer = 3000

        val result = trans(card, pastTrasfers, transfer)

        assertEquals(-2, result)
    }

    @Test
    fun transVkPayDailyLimit() {
        val card = "VK Pay"
        val pastTrasfers =  0
        val transfer = 15_000

        val result = trans(card, pastTrasfers, transfer)

        assertEquals(-2, result)
    }

    @Test
    fun transVisaNoCommision() {
        val card = "Visa"
        val pastTrasfers =  0
        val transfer = 3000

        val result = trans(card, pastTrasfers, transfer)

        assertEquals(35, result)
    }

    @Test
    fun transVisaWithCommision() {
        val card = "Visa"
        val pastTrasfers =  0
        val transfer = 30_000

        val result = trans(card, pastTrasfers, transfer)

        assertEquals(225, result)
    }

    @Test
    fun transVisaLimit() {
        val card = "Visa"
        val pastTrasfers =  600_000_000
        val transfer = 3000

        val result = trans(card, pastTrasfers, transfer)

        assertEquals(-2, result)
    }

    @Test
    fun transVisaDailyLimit() {
        val card = "Visa"
        val pastTrasfers =  0
        val transfer = 150_000

        val result = trans(card, pastTrasfers, transfer)

        assertEquals(-2, result)
    }

    @Test
    fun transMasterCardNoCommision() {
        val card = "MasterCard"
        val pastTrasfers =  0
        val transfer = 3000

        val result = trans(card, pastTrasfers, transfer)

        assertEquals(0, result)
    }

    @Test
    fun transMasterCardWithCommision() {
        val card = "MasterCard"
        val pastTrasfers =  0
        val transfer = 80_000

        val result = trans(card, pastTrasfers, transfer)

        assertEquals(500, result)
    }

    @Test
    fun transMasterCardLimit() {
        val card = "MasterCard"
        val pastTrasfers =  600_000_000
        val transfer = 3000

        val result = trans(card, pastTrasfers, transfer)

        assertEquals(-2, result)
    }

    @Test
    fun transMasterCardDailyLimit() {
        val card = "MasterCard"
        val pastTrasfers =  0
        val transfer = 150_000

        val result = trans(card, pastTrasfers, transfer)

        assertEquals(-2, result)
    }

    @Test
    fun transNoType() {
        val card = "111"
        val pastTrasfers =  0
        val transfer = 3000

        val result = trans(card, pastTrasfers, transfer)

        assertEquals(-1, result)
    }
}