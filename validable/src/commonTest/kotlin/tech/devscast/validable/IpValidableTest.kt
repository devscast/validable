package tech.devscast.validable

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class IpValidableTest {

    lateinit var validable: IpValidable

    @Before
    fun setUp() {
        validable = IpValidable()
        validable.enableShowErrors()
    }

    @Test
    fun `valid ip v4 are valid`() {
        getValidIPv4().forEach {
            validable.value = it
            Assert.assertFalse(validable.hasError())
        }
    }

    @Test
    fun `invalid ip v4 have error`() {
        getInvalidIPv4().forEach {
            validable.value = it
            Assert.assertTrue(validable.hasError())
        }
    }

    private fun getValidIPv4(): List<String> {
        return listOf(
            "192.168.0.1",
            "10.0.0.1",
            "172.16.0.1",
            "255.255.255.255"
        )
    }

    private fun getInvalidIPv4(): List<String> {
        return listOf(
            "256.0.0.1",
            "192.168.0.300",
            "1.2.3",
            "not an IP address"
        )
    }
}
