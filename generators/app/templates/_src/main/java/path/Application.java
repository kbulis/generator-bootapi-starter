package <%= path %>;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;

/**
 * Just another generated api.
 * 
 * @author <%= author %>
 *
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    static class HealthView {

        public String status;
        public String message;
		
    }

	static class ErrorView {

        public String message;
		
    }

}
