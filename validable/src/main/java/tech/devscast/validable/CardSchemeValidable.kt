package tech.devscast.validable

import java.util.regex.Pattern

/**
 * Validates that a card number belongs to a specified scheme.
 */
class CardSchemeValidable(vararg schemes: CardScheme, message: String? = null) : BaseValidable(
    validator = { value ->
        schemes.any { scheme ->
            val compiledPatterns = scheme.patterns.map { Pattern.compile(it) }
            compiledPatterns.any { pattern -> pattern.matcher(value).matches() }
        }
    },
    errorFor = { _ -> message ?: "Unsupported card type or invalid card number." }
)

/**
 * see https://en.wikipedia.org/wiki/Payment_card_number
 * see https://www.regular-expressions.info/creditcard.html
 */
open class CardScheme protected constructor(val patterns: List<String>) {

    companion object {
        fun merge(vararg schemes: CardScheme): CardScheme {
            return CardScheme(schemes.flatMap { scheme -> scheme.patterns })
        }
    }

    /**
     * American Express card numbers start with 34 or 37 and have 15 digits.
     */
    data object Amex : CardScheme(
        listOf("^3[47][0-9]{13}\$")
    )

    /**
     * China UnionPay cards start with 62 and have between 16 and 19 digits.
     * Please note that these cards do not follow Luhn Algorithm as a checksum.
     */
    data object ChinaUnionPay : CardScheme(
        listOf("^62[0-9]{14,17}\$")
    )

    /**
     * Diners Club card numbers begin with 300 through 305, 36 or 38. All have 14 digits.
     * There are Diners Club cards that begin with 5 and have 16 digits.
     * These are a joint venture between Diners Club and MasterCard, and should be processed like a MasterCard.
     */
    data object Diners : CardScheme(
        listOf("^3(?:0[0-5]|[68][0-9])[0-9]{11}\$")
    )

    /**
     * Discover card numbers begin with 6011, 622126 through 622925, 644 through 649 or 65.
     * All have 16 digits.
     */
    data object Discover : CardScheme(
        listOf(
            "^6011[0-9]{12}$",
            "^64[4-9][0-9]{13}$",
            "^65[0-9]{14}$",
            "^622(12[6-9]|1[3-9][0-9]|[2-8][0-9][0-9]|91[0-9]|92[0-5])[0-9]{10}$"
        )
    )

    /**
     * InstaPayment cards begin with 637 through 639 and have 16 digits.
     */
    data object InstaPayment : CardScheme(
        listOf("^63[7-9][0-9]{13}\$")
    )

    /**
     * JCB cards beginning with 2131 or 1800 have 15 digits.
     * JCB cards beginning with 35 have 16 digits.
     */
    data object Jcb : CardScheme(
        listOf("^(?:2131|1800|35[0-9]{3})[0-9]{11}\$")
    )

    /**
     * Laser cards begin with either 6304, 6706, 6709 or 6771 and have between 16 and 19 digits.
     */
    data object Laser : CardScheme(
        listOf("^(6304|670[69]|6771)[0-9]{12,15}\$")
    )

    /**
     * Maestro international cards begin with 675900..675999 and have between 12 and 19 digits.
     * Maestro UK cards begin with either 500000..509999 or 560000..699999 and have between 12 and 19 digits.
     */
    data object Maestro : CardScheme(
        listOf(
            "^(6759[0-9]{2})[0-9]{6,13}$",
            "^(50[0-9]{4})[0-9]{6,13}$",
            "^5[6-9][0-9]{10,17}$",
            "^6[0-9]{11,18}$"
        )
    )

    /**
     * All MasterCard numbers start with the numbers 51 through 55. All have 16 digits.
     * October 2016 MasterCard numbers can also start with 222100 through 272099.
     */
    data object MasterCard : CardScheme(
        listOf(
            "^5[1-5][0-9]{14}$",
            "^2(22[1-9][0-9]{12}|2[3-9][0-9]{13}|[3-6][0-9]{14}|7[0-1][0-9]{13}|720[0-9]{12})$"
        )
    )

    /**
     * Payment system MIR numbers start with 220, then 1 digit from 0 to 4, then between 12 and 15 digits
     */
    data object Mir : CardScheme(
        listOf("^220[0-4][0-9]{12,15}\$")
    )

    /**
     * All UATP card numbers start with a 1 and have a length of 15 digits.
     */
    data object Uatp : CardScheme(
        listOf("^1[0-9]{14}\$")
    )

    /**
     * All Visa card numbers start with a 4 and have a length of 13, 16, or 19 digits.
     */
    data object Visa : CardScheme(
        listOf("^4([0-9]{12}|[0-9]{15}|[0-9]{18})\$")
    )
}
