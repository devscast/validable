package tech.devscast.validable

import org.junit.Assert
import org.junit.Test

class CardSchemeValidableTest {

    lateinit var validable: CardSchemeValidable

    @Test
    fun `valid card numbers are valid`() {
        getValidCardNumbers().forEach { card ->
            validable = CardSchemeValidable(card["type"] as CardScheme)
            validable.enableShowErrors()
            validable.value = card["number"].toString()
            Assert.assertFalse(validable.errorMessage, validable.hasError())
        }
    }

    // to test the vararg constructor
    @Test
    fun `valid card numbers with multiple scheme validable are valid`() {
        getValidCardMap()
            .filter { it.key == CardScheme.Visa || it.key == CardScheme.MasterCard }
            .forEach { card ->
                validable = CardSchemeValidable(CardScheme.Visa, CardScheme.MasterCard)
                validable.enableShowErrors()
                validable.value = card.value
                Assert.assertFalse(validable.errorMessage, validable.hasError())
            }
    }

    @Test
    fun `invalid card number have error`() {
        getInvalidCardNumbers().forEach { card ->
            validable = CardSchemeValidable(card["type"] as CardScheme)
            validable.enableShowErrors()
            validable.value = card["number"].toString()
            Assert.assertTrue(validable.errorMessage, validable.hasError())
        }
    }

    private fun getValidCardNumbers(): List<Map<String, Any>> {
        return listOf(
            mapOf("type" to CardScheme.Amex, "number" to "378282246310005"),
            mapOf("type" to CardScheme.Amex, "number" to "371449635398431"),
            mapOf("type" to CardScheme.Amex, "number" to "378734493671000"),
            mapOf("type" to CardScheme.Amex, "number" to "347298508610146"),
            mapOf("type" to CardScheme.ChinaUnionPay, "number" to "6228888888888888"),
            mapOf("type" to CardScheme.ChinaUnionPay, "number" to "62288888888888888"),
            mapOf("type" to CardScheme.ChinaUnionPay, "number" to "622888888888888888"),
            mapOf("type" to CardScheme.ChinaUnionPay, "number" to "6228888888888888888"),
            mapOf("type" to CardScheme.Diners, "number" to "30569309025904"),
            mapOf("type" to CardScheme.Diners, "number" to "36088894118515"),
            mapOf("type" to CardScheme.Diners, "number" to "38520000023237"),
            mapOf("type" to CardScheme.Discover, "number" to "6011111111111117"),
            mapOf("type" to CardScheme.Discover, "number" to "6011000990139424"),
            mapOf("type" to CardScheme.InstaPayment, "number" to "6372476031350068"),
            mapOf("type" to CardScheme.InstaPayment, "number" to "6385537775789749"),
            mapOf("type" to CardScheme.InstaPayment, "number" to "6393440808445746"),
            mapOf("type" to CardScheme.Jcb, "number" to "3530111333300000"),
            mapOf("type" to CardScheme.Jcb, "number" to "3566002020360505"),
            mapOf("type" to CardScheme.Jcb, "number" to "213112345678901"),
            mapOf("type" to CardScheme.Jcb, "number" to "180012345678901"),
            mapOf("type" to CardScheme.Laser, "number" to "6304678107004080"),
            mapOf("type" to CardScheme.Laser, "number" to "6706440607428128629"),
            mapOf("type" to CardScheme.Laser, "number" to "6771656738314582216"),
            mapOf("type" to CardScheme.Maestro, "number" to "6759744069209"),
            mapOf("type" to CardScheme.Maestro, "number" to "5020507657408074712"),
            mapOf("type" to CardScheme.Maestro, "number" to "5612559223580173965"),
            mapOf("type" to CardScheme.Maestro, "number" to "6759744069209"),
            mapOf("type" to CardScheme.Maestro, "number" to "6594371785970435599"),
            mapOf("type" to CardScheme.MasterCard, "number" to "5555555555554444"),
            mapOf("type" to CardScheme.MasterCard, "number" to "5105105105105100"),
            mapOf("type" to CardScheme.MasterCard, "number" to "2221005555554444"),
            mapOf("type" to CardScheme.MasterCard, "number" to "2230000000000000"),
            mapOf("type" to CardScheme.MasterCard, "number" to "2300000000000000"),
            mapOf("type" to CardScheme.MasterCard, "number" to "2699999999999999"),
            mapOf("type" to CardScheme.MasterCard, "number" to "2709999999999999"),
            mapOf("type" to CardScheme.MasterCard, "number" to "2720995105105100"),
            mapOf("type" to CardScheme.Mir, "number" to "2200381427330082"),
            mapOf("type" to CardScheme.Mir, "number" to "22003814273300821"),
            mapOf("type" to CardScheme.Mir, "number" to "220038142733008212"),
            mapOf("type" to CardScheme.Mir, "number" to "2200381427330082123"),
            mapOf("type" to CardScheme.Uatp, "number" to "110165309696173"),
            mapOf("type" to CardScheme.Visa, "number" to "4111111111111111"),
            mapOf("type" to CardScheme.Visa, "number" to "4012888888881881"),
            mapOf("type" to CardScheme.Visa, "number" to "4222222222222"),
            mapOf("type" to CardScheme.Visa, "number" to "4917610000000000003"),
            mapOf(
                "type" to CardScheme.merge(CardScheme.Amex, CardScheme.Visa),
                "number" to "4111111111111111"
            ),
            mapOf(
                "type" to CardScheme.merge(CardScheme.Amex, CardScheme.Visa),
                "number" to "378282246310005"
            ),
            mapOf(
                "type" to CardScheme.merge(CardScheme.Jcb, CardScheme.MasterCard),
                "number" to "5105105105105100"
            ),
            mapOf(
                "type" to CardScheme.merge(CardScheme.Visa, CardScheme.MasterCard),
                "number" to "5105105105105100"
            )
        )
    }

    private fun getValidCardMap(): Map<CardScheme, String> {
        return mapOf(
            CardScheme.Amex to "371449635398431",
            CardScheme.Amex to "378282246310005",
            CardScheme.Amex to "378734493671000",
            CardScheme.Amex to "347298508610146",
            CardScheme.ChinaUnionPay to "6228888888888888",
            CardScheme.ChinaUnionPay to "62288888888888888",
            CardScheme.ChinaUnionPay to "622888888888888888",
            CardScheme.ChinaUnionPay to "6228888888888888888",
            CardScheme.Diners to "30569309025904",
            CardScheme.Diners to "36088894118515",
            CardScheme.Diners to "38520000023237",
            CardScheme.Discover to "6011111111111117",
            CardScheme.Discover to "6011000990139424",
            CardScheme.InstaPayment to "6372476031350068",
            CardScheme.InstaPayment to "6385537775789749",
            CardScheme.InstaPayment to "6393440808445746",
            CardScheme.Jcb to "3530111333300000",
            CardScheme.Jcb to "3566002020360505",
            CardScheme.Jcb to "213112345678901",
            CardScheme.Jcb to "180012345678901",
            CardScheme.Laser to "6304678107004080",
            CardScheme.Laser to "6706440607428128629",
            CardScheme.Laser to "6771656738314582216",
            CardScheme.Maestro to "6759744069209",
            CardScheme.Maestro to "5020507657408074712",
            CardScheme.Maestro to "5612559223580173965",
            CardScheme.Maestro to "6759744069209",
            CardScheme.Maestro to "6594371785970435599",
            CardScheme.MasterCard to "5555555555554444",
            CardScheme.MasterCard to "5105105105105100",
            CardScheme.MasterCard to "2221005555554444",
            CardScheme.MasterCard to "2230000000000000",
            CardScheme.MasterCard to "2300000000000000",
            CardScheme.MasterCard to "2699999999999999",
            CardScheme.MasterCard to "2709999999999999",
            CardScheme.MasterCard to "2720995105105100",
            CardScheme.Mir to "2200381427330082",
            CardScheme.Mir to "22003814273300821",
            CardScheme.Mir to "220038142733008212",
            CardScheme.Mir to "2200381427330082123",
            CardScheme.Uatp to "110165309696173",
            CardScheme.Visa to "4111111111111111",
            CardScheme.Visa to "4012888888881881",
            CardScheme.Visa to "4222222222222",
            CardScheme.Visa to "4917610000000000003",
        )
    }

    private fun getInvalidCardNumbers(): List<Map<String, Any>> {
        return listOf(
            mapOf("type" to CardScheme.Visa, "number" to "42424242424242424242"),
            mapOf("type" to CardScheme.Amex, "number" to "357298508610146"),
            mapOf("type" to CardScheme.Diners, "number" to "31569309025904"),
            mapOf("type" to CardScheme.Diners, "number" to "37088894118515"),
            mapOf("type" to CardScheme.InstaPayment, "number" to "6313440808445746"),
            mapOf("type" to CardScheme.ChinaUnionPay, "number" to "622888888888888"),
            mapOf("type" to CardScheme.ChinaUnionPay, "number" to "62288888888888888888"),
            mapOf("type" to CardScheme.Amex, "number" to "30569309025904"), // DINERS number
            mapOf("type" to CardScheme.Amex, "number" to "invalid"), // A string
            mapOf("type" to CardScheme.Amex, "number" to "0"), // a lone number
            mapOf("type" to CardScheme.Amex, "number" to "000000000000"), // a lone number
            mapOf(
                "type" to CardScheme.Diners,
                "number" to "3056930"
            ), // only first part of the number
            mapOf("type" to CardScheme.Discover, "number" to "1117"), // only last 4 digits
            mapOf(
                "type" to CardScheme.MasterCard,
                "number" to "2721001234567890"
            ), // Not assigned yet
            mapOf(
                "type" to CardScheme.MasterCard,
                "number" to "2220991234567890"
            ), // Not assigned yet
            mapOf("type" to CardScheme.Uatp, "number" to "11016530969617"), // invalid length
            mapOf("type" to CardScheme.Mir, "number" to "220038142733008"), // invalid length
            mapOf("type" to CardScheme.Mir, "number" to "22003814273300821234") // invalid length
        )
    }
}
