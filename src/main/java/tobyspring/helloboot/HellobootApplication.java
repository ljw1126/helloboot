package tobyspring.helloboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class HellobootApplication {
	public static void main(String[] args) {
		// Spring Container
		GenericWebApplicationContext applicationContext = new GenericWebApplicationContext() {
			@Override
			protected void onRefresh() {
				super.onRefresh();

				// Servlet Container
				ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
				WebServer webServer = serverFactory.getWebServer(servletContext -> {
					servletContext.addServlet("dispatcherServlet", new DispatcherServlet(this))
							.addMapping("/*");
				});
				webServer.start(); // 톰캣 서블릿 컨테이너 동작
			}
		};
		applicationContext.registerBean(HelloController.class); // Bean 등록
		applicationContext.registerBean(SimpleHelloService.class);
		applicationContext.refresh(); // Bean 초기화
	}
}
