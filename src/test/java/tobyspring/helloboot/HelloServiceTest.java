package tobyspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class HelloServiceTest {

    @Mock
    HelloRepository helloRepository;

    @Test
    void simpleHelloService() {
        HelloService helloService = new SimpleHelloService(helloRepository);

        String ret = helloService.sayHello("Test");

        Assertions.assertThat(ret).isEqualTo("Hello Test");
    }

    @Test
    void helloDecorator() {
        HelloService helloService = new HelloDecorator(name -> name);

        String ret = helloService.sayHello("Test");

        Assertions.assertThat(ret).isEqualTo("*Test*");
    }
}