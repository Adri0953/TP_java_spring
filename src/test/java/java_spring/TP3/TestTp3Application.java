package java_spring.TP3;

import org.springframework.boot.SpringApplication;

import com.example.accessingdatamysql.Tp3Application;

public class TestTp3Application {

	public static void main(String[] args) {
		SpringApplication.from(Tp3Application::main).with(TestcontainersConfiguration.class).run(args);
	}

}
