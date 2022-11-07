package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class GreetingController {

    @Value("${background-color:white}")
    private String backgroundColor;

    private int invocationCount = 0;

    @GetMapping("/")
    public String greeting(Model model) {
        model.addAttribute("name", System.getenv().getOrDefault("GREETING_DEFAULT", "World!"));
        model.addAttribute("hostname", System.getenv().getOrDefault("HOSTNAME", "unknown"));
        model.addAttribute("backgroundColor", backgroundColor);
        model.addAttribute("userDir", System.getProperty("user.dir"));
        model.addAttribute("password", System.getenv().getOrDefault("PASSWORD", "unknown"));
        model.addAttribute("invocationCount", ++invocationCount);
        return "greeting";
    }

}
