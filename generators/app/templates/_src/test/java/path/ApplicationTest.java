package <%= path %>;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.context.*;
import org.springframework.test.context.junit4.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;
import org.springframework.test.web.servlet.result.*;

/**
 * A simple test harness for locally invoking your api.
 *
 * @author <%= author %>
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTest {

    @Autowired
    private MockMvc mvc;    
    
    @Test
    public void testApi() throws AssertionError {

        System.out.println("Testing...");

        try
        {
            mvc.perform(MockMvcRequestBuilders.get("/healthcheck").accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.header().string("content-type", "application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().json("{ \"status\": \"ok\" }"));
        }
        catch (AssertionError eX)
        {
            throw eX;
        }
        catch (Exception eX)
        {
            Assert.fail
                ( "Oops because " + eX.getMessage().toLowerCase()
                );
        }
        finally
        {
            System.out.println
                ( "Done."
                );
        }
    }
    
}
