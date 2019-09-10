package courier.controller;

import courier.domain.Task;
import courier.service.TaskService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("operator")
@PreAuthorize("hasAuthority('Operator')")
public class OperatorController {
    @Resource
    private TaskService taskService;

    @GetMapping(value = {"", "getAllTasks"})
    public String getAllTasks(Map<String, Object> model) {
        List<Task> tasks = taskService.getAllTasks();
        model.put("tasks", tasks);
        return "operator";
    }

    @GetMapping(value = "getTask")
    public String getTask(@RequestParam(required = false) Long orderId, Map<String, Object> model) {
        Task task = taskService.getTask(orderId);
        model.put("tasks", task);
        return "operator";
    }

    @PostMapping(value = "delete")
    public String deleteTask(@RequestParam Long taskId) {
        taskService.deleteTask(taskId);
        return "redirect:/operator";
    }
}
