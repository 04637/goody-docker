package dev.aid.goody;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("dev.aid.goody.dao")
public class GoodyApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoodyApplication.class, args);
	}

}
