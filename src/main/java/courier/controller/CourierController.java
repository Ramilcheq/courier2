package courier.controller;

import courier.service.TaskService;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping("courier")
@PreAuthorize("hasAuthority('Courier')")
public class CourierController {
    @Resource
    private TaskService taskService;

    @GetMapping
    public String courier() {
        return "courier";
    }

    @PostMapping(value = "addtask")
    public String addTask(@RequestParam Long orderId, Map<String, Object> model) {
        if (orderId == null) {
            model.put("message", "Введите номер заказа");
            return "courier";
        }
        try {
            taskService.addTask(orderId);
        } catch (DuplicateKeyException e) {
            model.put("message", "Задание с таким заказом уже существует");
            return "courier";
        }
        model.put("message", "Задание успешно добавлено");
        return "courier";
    }
}
