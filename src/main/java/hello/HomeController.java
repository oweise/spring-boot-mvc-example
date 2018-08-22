package hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    private final GreetingService service;

    public HomeController(GreetingService service) {
        this.service = service;
    }

    @RequestMapping(path = "/alternateGreeting")
    public @ResponseBody String greeting() {
        return String.format("Hello %s!", service.greet());
    }

}
