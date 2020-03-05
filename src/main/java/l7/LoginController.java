package l7;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @SuppressWarnings("unused")
    @GetMapping("/login")
    public String showLoginPage() {
        return "login-page";
    }
}
