package courier.service;

import courier.domain.Task;
import courier.persistence.TaskMapper;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TaskService {

    @Resource
    private TaskMapper taskMapper;

    public List<Task> getAllTasks() {
        return taskMapper.getAllTasks();
    }

    public Task getTask(Long orderId) {
        return taskMapper.getTask(orderId);
    }

    public void addTask(Long orderId) throws DuplicateKeyException {
        taskMapper.addTask(orderId);
    }

    public void deleteTask(Long taskId) {
        taskMapper.deleteTask(taskId);
    }
}
