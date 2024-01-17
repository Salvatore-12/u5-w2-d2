package salvatoreassennato.u5.w2.d2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import salvatoreassennato.u5.w2.d2.entities.Author;

import java.util.List;

@SpringBootApplication
public class Application {

	private static Author[] authorList;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}
	}


