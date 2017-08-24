package <%= path %>;

import org.springframework.web.bind.annotation.*;

/**
 * Just another generated api.
 * 
 * @author <%= author %>
 *
 */
@RestController
public class StatusController {

    @RequestMapping("/healthcheck")
    public Object checkHealth() {
        return new Application.HealthView() {{
        	this.status = "ok";
        	this.message = "Everything with spring-api is a-ok!";
    	}};
    }
     
}