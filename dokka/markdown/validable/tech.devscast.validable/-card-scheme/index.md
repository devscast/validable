//[validable](../../../index.md)/[tech.devscast.validable](../index.md)/[CardScheme](index.md)

# CardScheme

open class [CardScheme](index.md)(val patterns: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;)

Represents a card scheme for validation purposes.

A `CardScheme` defines a set of regular expressions used to identify card numbers belonging to a specific payment network (e.g., Visa, Mastercard). This class provides a way to validate card numbers against these predefined patterns.

see https://en.wikipedia.org/wiki/Payment_card_number see https://www.regular-expressions.info/creditcard.html

#### Parameters

androidJvm

| | |
|---|---|
| patterns | A list of regular expressions that match valid card numbers for this scheme. |

#### Inheritors

| |
|---|
| [Amex](-amex/index.md) |
| [ChinaUnionPay](-china-union-pay/index.md) |
| [Diners](-diners/index.md) |
| [Discover](-discover/index.md) |
| [InstaPayment](-insta-payment/index.md) |
| [Jcb](-jcb/index.md) |
| [Laser](-laser/index.md) |
| [Maestro](-maestro/index.md) |
| [MasterCard](-master-card/index.md) |
| [Mir](-mir/index.md) |
| [Uatp](-uatp/index.md) |
| [Visa](-visa/index.md) |

## Constructors

| | |
|---|---|
| [CardScheme](-card-scheme.md) | [androidJvm]<br>constructor(patterns: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;) |

## Types

| Name | Summary |
|---|---|
| [Amex](-amex/index.md) | [androidJvm]<br>data object [Amex](-amex/index.md) : [CardScheme](index.md)<br>American Express card numbers start with 34 or 37 and have 15 digits. |
| [ChinaUnionPay](-china-union-pay/index.md) | [androidJvm]<br>data object [ChinaUnionPay](-china-union-pay/index.md) : [CardScheme](index.md)<br>China UnionPay cards start with 62 and have between 16 and 19 digits. Please note that these cards do not follow Luhn Algorithm as a checksum. |
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |
| [Diners](-diners/index.md) | [androidJvm]<br>data object [Diners](-diners/index.md) : [CardScheme](index.md)<br>Diners Club card numbers begin with 300 through 305, 36 or 38. All have 14 digits. There are Diners Club cards that begin with 5 and have 16 digits. These are a joint venture between Diners Club and MasterCard, and should be processed like a MasterCard. |
| [Discover](-discover/index.md) | [androidJvm]<br>data object [Discover](-discover/index.md) : [CardScheme](index.md)<br>Discover card numbers begin with 6011, 622126 through 622925, 644 through 649 or 65. All have 16 digits. |
| [InstaPayment](-insta-payment/index.md) | [androidJvm]<br>data object [InstaPayment](-insta-payment/index.md) : [CardScheme](index.md)<br>InstaPayment cards begin with 637 through 639 and have 16 digits. |
| [Jcb](-jcb/index.md) | [androidJvm]<br>data object [Jcb](-jcb/index.md) : [CardScheme](index.md)<br>JCB cards beginning with 2131 or 1800 have 15 digits. JCB cards beginning with 35 have 16 digits. |
| [Laser](-laser/index.md) | [androidJvm]<br>data object [Laser](-laser/index.md) : [CardScheme](index.md)<br>Laser cards begin with either 6304, 6706, 6709 or 6771 and have between 16 and 19 digits. |
| [Maestro](-maestro/index.md) | [androidJvm]<br>data object [Maestro](-maestro/index.md) : [CardScheme](index.md)<br>Maestro international cards begin with 675900..675999 and have between 12 and 19 digits. Maestro UK cards begin with either 500000..509999 or 560000..699999 and have between 12 and 19 digits. |
| [MasterCard](-master-card/index.md) | [androidJvm]<br>data object [MasterCard](-master-card/index.md) : [CardScheme](index.md)<br>All MasterCard numbers start with the numbers 51 through 55. All have 16 digits. October 2016 MasterCard numbers can also start with 222100 through 272099. |
| [Mir](-mir/index.md) | [androidJvm]<br>data object [Mir](-mir/index.md) : [CardScheme](index.md)<br>Payment system MIR numbers start with 220, then 1 digit from 0 to 4, then between 12 and 15 digits |
| [Uatp](-uatp/index.md) | [androidJvm]<br>data object [Uatp](-uatp/index.md) : [CardScheme](index.md)<br>All UATP card numbers start with a 1 and have a length of 15 digits. |
| [Visa](-visa/index.md) | [androidJvm]<br>data object [Visa](-visa/index.md) : [CardScheme](index.md)<br>All Visa card numbers start with a 4 and have a length of 13, 16, or 19 digits. |

## Properties

| Name | Summary |
|---|---|
| [patterns](patterns.md) | [androidJvm]<br>val [patterns](patterns.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt; |
