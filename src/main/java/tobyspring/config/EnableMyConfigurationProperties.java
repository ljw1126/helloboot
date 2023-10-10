package tobyspring.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(MyConfigurationPropertiesImportSelector.class)
public @interface EnableMyConfigurationProperties { // Enable- 의 목적은 @Import 붙여서 읽어오도록 함
    Class value();
}
