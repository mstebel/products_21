package pl.ms.products;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class HomeController {
    @GetMapping("/")
    public String home() {
        return "home";
    }
}
