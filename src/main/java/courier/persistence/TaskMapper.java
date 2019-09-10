package courier.persistence;

import courier.domain.Task;
import org.springframework.dao.DuplicateKeyException;

import java.util.List;

public interface TaskMapper {

    Task getTask(Long taskId);

    List<Task> getAllTasks();

    void addTask(Long orderId) throws DuplicateKeyException;

    void deleteTask(Long taskId);
}
