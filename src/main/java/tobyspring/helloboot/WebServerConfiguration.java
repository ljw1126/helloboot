package tobyspring.helloboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class WebServerConfiguration {

    @Bean
    ServletWebServerFactory customWebServerFactory() {
        TomcatServletWebServerFactory tomcat =  new TomcatServletWebServerFactory();
        tomcat.setPort(9090);
        return tomcat;
    }
}
