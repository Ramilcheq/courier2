package courier.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping(value = {"/", "/index"})
    public String index() {
        return "index";
    }

    @GetMapping("403")
    public String accessDenied() {
        return "403";
    }
}
