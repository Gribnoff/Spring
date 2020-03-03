package l6;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @SuppressWarnings("unused")
    @GetMapping("/")
    public String goHome() {
        return "index";
    }
}
