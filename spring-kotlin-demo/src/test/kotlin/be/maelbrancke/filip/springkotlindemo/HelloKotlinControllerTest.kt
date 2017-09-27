package be.maelbrancke.filip.springkotlindemo

import org.amshove.kluent.shouldEqual
import org.amshove.kluent.shouldEqualTo
import org.amshove.kluent.shouldNotBeNull
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(classes = arrayOf(Application::class), webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloKotlinControllerTest {

    @Autowired
    lateinit var testRestTemplate: TestRestTemplate

    @Test
    fun `hello endpoint should return hello world`() {
        val result = testRestTemplate.getForEntity("/hello", String::class.java)

        result.shouldNotBeNull()
        result.statusCode shouldEqual HttpStatus.OK
        result.body shouldEqualTo "Hello world"
    }
}