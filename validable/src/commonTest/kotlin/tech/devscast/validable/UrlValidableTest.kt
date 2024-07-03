package tech.devscast.validable

import tech.devscast.validable.util.ExperimentalValidableApi
import kotlin.test.BeforeTest
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@Ignore
@OptIn(ExperimentalValidableApi::class)
class UrlValidableTest {

//    lateinit var validable: UrlValidable
//
//    @BeforeTest
//    fun setUp() {
//        validable = UrlValidable()
//        validable.enableShowErrors()
//    }
//
//    @Test
//    fun invalidRelativeUrlsHaveErrors() {
//        getInvalidRelativeUrls().forEach {
//            validable.value = it
//            assertTrue(validable.hasError(), validable.errorMessage)
//        }
//    }
//
//    @Test
//    fun invalidUrlsHasErrors() {
//        getInvalidUrls().forEach {
//            validable.value = it
//            assertTrue(validable.hasError(), validable.errorMessage)
//        }
//    }
//
//    @Test
//    fun validUrlsAreValid() {
//        getValidUrls().forEach {
//            validable.value = it
//            assertFalse(validable.hasError(), validable.errorMessage)
//        }
//    }
//
//    @Test
//    fun customValidUrlsAreValid() {
//        getValidCustomUrls().forEach {
//            validable.value = it
//            assertFalse(validable.hasError(), validable.errorMessage)
//        }
//    }

    private fun getValidCustomUrls(): List<String> {
        return listOf(
            "ftp://example.com",
            "file://127.0.0.1"
        )
    }

    private fun getInvalidRelativeUrls(): List<String> {
        return listOf(
            "/example.com",
            "//example.com::aa",
            "//example.com:aa",
            "//127.0.0.1:aa/",
            "//[::1",
            "//hello.☎/",
            "//:password@devscast.com",
            "//:password@@devscast.com",
            "//username:passworddevscast.com",
            "//usern@me:password@devscast.com",
            "//example.com/exploit.html?<script>alert(1);</script>",
            "//example.com/exploit.html?hel lo",
            "//example.com/exploit.html?not_a%hex",
            "//"
        )
    }

    private fun getInvalidUrls(): List<String> {
        return listOf(
            "git://[::1]/",
            "faked://example.fr",
            "000000000000",
            "invalid"
        )
    }

    private fun getValidUrls(): List<String> {
        return listOf(
            "http://a.pl",
            "http://www.example.com",
            "http://tt.example.com",
            "http://m.example.com",
            "http://m.m.m.example.com",
            "http://example.m.example.com",
            "https://long-string_with+symbols.m.example.com",
            "http://www.example.com.",
            "http://www.example.museum",
            "https://example.com/",
            "https://example.com:80/",
            "http://examp_le.com",
            "http://www.sub_domain.examp_le.com",
            "http://www.example.coop/",
            "http://www.test-example.com/",
            "http://www.devscast.com/",
            "http://devscast.fake/blog/",
            "http://devscast.com/?",
            "http://devscast.com/search?type=&q=url+validator",
            "http://devscast.com/#",
            "http://devscast.com/#?",
            "http://www.devscast.com/doc/current/book/validation.html#supported-constraints",
            "http://very.long.domain.name.com/",
            "http://localhost/",
            "http://myhost123/",
            "http://internal-api",
            "http://internal-api.",
            "http://internal-api/",
            "http://internal-api/path",
            "http://127.0.0.1/",
            "http://127.0.0.1:80/",
            "http://[::1]/",
            "http://[::1]:80/",
            "http://[1:2:3::4:5:6:7]/",
            "http://sãopaulo.com/",
            "http://xn--sopaulo-xwa.com/",
            "http://sãopaulo.com.br/",
            "http://xn--sopaulo-xwa.com.br/",
            "http://пример.испытание/",
            "http://xn--e1afmkfd.xn--80akhbyknj4f/",
            "http://مثال.إختبار/",
            "http://xn--mgbh0fb.xn--kgbechtv/",
            "http://例子.测试/",
            "http://xn--fsqu00a.xn--0zwm56d/",
            "http://例子.測試/",
            "http://xn--fsqu00a.xn--g6w251d/",
            "http://例え.テスト/",
            "http://xn--r8jz45g.xn--zckzah/",
            "http://مثال.آزمایشی/",
            "http://xn--mgbh0fb.xn--hgbk6aj7f53bba/",
            "http://실례.테스트/",
            "http://xn--9n2bp8q.xn--9t4b11yi5a/",
            "http://العربية.idn.icann.org/",
            "http://xn--ogb.idn.icann.org/",
            "http://xn--e1afmkfd.xn--80akhbyknj4f.xn--e1afmkfd/",
            "http://xn--espaa-rta.xn--ca-ol-fsay5a/",
            "http://xn--d1abbgf6aiiy.xn--p1ai/",
            "http://☎.com/",
            "http://username:password@devscast.com",
            "http://user.name:password@devscast.com",
            "http://user_name:pass_word@devscast.com",
            "http://username:pass.word@devscast.com",
            "http://user.name:pass.word@devscast.com",
            "http://user-name@devscast.com",
            "http://user_name@devscast.com",
            "http://u%24er:password@devscast.com",
            "http://user:pa%24%24word@devscast.com",
            "http://devscast.com?",
            "http://devscast.com?query=1",
            "http://devscast.com/?query=1",
            "http://devscast.com#",
            "http://devscast.com#fragment",
            "http://devscast.com/#fragment",
            "http://devscast.com/#one_more%20test",
            "http://example.com/exploit.html?hello[0]=test",
            "http://বিডিআইএ.বাংলা"
        )
    }
}
