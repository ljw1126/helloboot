package tobyspring.study;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import tobyspring.helloboot.HellobootApplication;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@ExtendWith(SpringExtension.class) // spring context 이용하는 spring container 테스트 가능
@ContextConfiguration(classes = HellobootApplication.class) // 빈을 로딩할 정보 가져옴, 시작점
@TestPropertySource("classpath:/application.properties")
@Transactional
public @interface HellobootTest {
}
