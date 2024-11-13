package tech.devscast.validable

import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class HostnameValidableTest {

    lateinit var validable: HostnameValidable

    @BeforeTest
    fun setUp() {
        validable = HostnameValidable()
        validable.enableShowErrors()
    }

    @Test
    fun shouldOnlyReturnsValidHostnames() {
        val hostnames = mutableListOf<String>()
        hostnames.addAll(
            getHostnames().filter { hostname ->
                validable.value = hostname
                !validable.hasError()
            }
        )

        assertEquals(getValidHostnames(), hostnames)
    }

    private fun getValidHostnames(): List<String> {
        return listOf(
            "exemple.com",
            "bernard",
            "localhost",
            "bernard.tech",
            "devs-cast.tech",
            "42.com",
            "whel234.com",
            "243.cd",
            "100.com",
            "hs.dd.com",
            "www.demo.com"
        )
    }

    private fun getHostnames(): List<String> {
        return listOf(
            "abcdefghijklmnopqrstuvwxyz ABCDEFGHIJKLMNOPQRSTUVWXYZ",
            "0123456789 _+-.,!@#$%^&*();\\/|<>\"'",
            "12345 -98.7 3.141 .6180 9,000 +42",
            "555.123.4567\t+1-(800)-555-2468",
            "foo@demo.net",
            "bar.ba@test.co.uk",
            "exemple.com",
            "hell.example",
            "he.localhost",
            "bernard",
            "localhost",
            "bernard.tech",
            "devs-cast.tech",
            "42.com",
            "whel234.com",
            "243.cd",
            "192.168.111.111",
            "256.168.111.1",
            "0.0.0.999",
            "1::1",
            "100.com",
            "hs.dd.com",
            "www.demo.com",
            "http://foo.co.uk/>><",
            "http://regexr.com/foo.html?q=bar",
            "https://mediatemple.net",
            "ldap://localhost:389"
        )
    }
}
