package es.unizar.webeng.lab2.test

import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit4.SpringRunner
import kotlin.test.assertEquals
import kotlin.test.assertNotNull


@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TimeComponentTest {
    @Autowired
    lateinit var testRestTemplate: TestRestTemplate
    @Test
    fun testTime() {
        System.setProperty("javax.net.ssl.trustStore", "src/test/kotlin/es/unizar/webeng/lab2/test/localhost.p12")
        System.setProperty("javax.net.ssl.trustStorePassword", "root")
        val result = testRestTemplate.getForEntity("https://localhost:8444/time", String::class.java)

        assertNotNull(result)
        assertEquals(result.statusCode, HttpStatus.OK)
        //assertEquals(LocalDateTime.now().toString(),result.body)
    }
    @Test
    fun testError() {
        System.setProperty("javax.net.ssl.trustStore", "src/test/kotlin/es/unizar/webeng/lab2/test/localhost.p12")
        System.setProperty("javax.net.ssl.trustStorePassword", "root")
        val result = testRestTemplate.getForEntity("https://localhost:8444", String::class.java)

        assertNotNull(result)
        assertEquals(result.statusCode, HttpStatus.NOT_FOUND)
        //assertEquals(LocalDateTime.now().toString(),result.body)
    }
}