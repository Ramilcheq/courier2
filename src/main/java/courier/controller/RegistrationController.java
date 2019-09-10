package courier.controller;

import courier.domain.Role;
import courier.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
public class RegistrationController {
    @Resource
    private UserService userService;

    @GetMapping("registration")
    public String registration(Map<String, Object> model) {
        List<Role> roles = userService.getRoles();
        model.put("roles", roles);
        return "registration";
    }

    @PostMapping("registration")
    public String registerUser(@RequestParam String username, @RequestParam String password,
                               @RequestParam Integer role, Map<String, Object> model) {
        UserDetails dbUser = userService.loadUserByUsername(username);

        if (dbUser != null) {
            model.put("message", "Такой пользователь уже существует!");
            model.put("roles", userService.getRoles());
            return "registration";
        }

        userService.save(username, password, role);
        model.put("message", "Пользователь зарегистрирован");
        model.put("address", "login");
        model.put("label", "Войти");
        return "success";
    }


}
