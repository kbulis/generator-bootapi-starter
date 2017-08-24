package <%= path %>;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

/**
 * Just another generated api.
 * 
 * @author <%= author %>
 *
 */
@RestController
public class ErrorController {

    @RequestMapping("/**")
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
    public Object handleUnmapped() {
        return new Application.ErrorView() {{
        	this.message = "Request not supported";
    	}};
    }
     
}