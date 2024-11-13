package tech.devscast.validable

import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class IpValidableTest {

    lateinit var validable: IpValidable

    @BeforeTest
    fun setUp() {
        validable = IpValidable()
        validable.enableShowErrors()
    }

    @Test
    fun validIpV4AreValid() {
        getValidIPv4().forEach {
            validable.value = it
            assertFalse(validable.hasError())
        }
    }

    @Test
    fun invalidIpV4HaveError() {
        getInvalidIPv4().forEach {
            validable.value = it
            assertTrue(validable.hasError())
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
