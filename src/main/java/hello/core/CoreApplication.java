package hello.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.module.Configuration;

// 스프링 부트 어노테이션 안에 컴포넌트 스캔이 있으므로 @SpringBootApplication 어노테이션이 있는 곳의 패키지로부터  모든 빈들을 읽음. 따라서 AutoAppConfig에서 configuration을 exclude한 설정은 적용되지 않음 why? 이미 컴포넌트 스캔을 다 해주므로
@SpringBootApplication( exclude = Configuration.class)
public class CoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
	}

}
