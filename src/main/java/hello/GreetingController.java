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

    @GetMapping("/greeting")
    public String greeting(Model model) {
        model.addAttribute("name", Optional.ofNullable(System.getenv("GREETING_DEFAULT")).orElse("World!"));
        model.addAttribute("backgroundColor", backgroundColor);
        model.addAttribute("userDir", System.getProperty("user.dir"));
        model.addAttribute("password", Optional.ofNullable(System.getenv("PASSWORD")).orElse("unknown"));
        return "greeting";
    }

}
