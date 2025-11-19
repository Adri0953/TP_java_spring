package java_spring.TP2;

import org.springframework.boot.SpringApplication;

import com.example.accessingdatamysql.Tp2Application;

public class TestTp2Application {

	public static void main(String[] args) {
		SpringApplication.from(Tp2Application::main).with(TestcontainersConfiguration.class).run(args);
	}

}
