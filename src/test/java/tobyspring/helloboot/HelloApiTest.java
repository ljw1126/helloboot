package tobyspring.helloboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class HelloApiTest {

    @Test
    void helloApi() {
        // http localhost:9090/hello?name=Spring
        TestRestTemplate rest = new TestRestTemplate();
        ResponseEntity<String> response
                = rest.getForEntity("http://localhost:9090/app/hello?name={name}", String.class, "Spring");

        // status 200
        // header(content-type) text/plain
        // body hello Spring
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE)).startsWith(MediaType.TEXT_PLAIN_VALUE);
        assertThat(response.getBody()).isEqualTo("*Hello Spring*");
    }

    @Test
    void failshelloApi() {
        // http localhost:9090/hello?name=
        TestRestTemplate rest = new TestRestTemplate();
        ResponseEntity<String> response
                = rest.getForEntity("http://localhost:9090/app/hello?name={name}", String.class, "");

        // status 500
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
