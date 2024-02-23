package co.edu.elpoli.task.services;

import co.edu.elpoli.task.persistence.entity.Task;
import co.edu.elpoli.task.persistence.entity.TaskStatus;
import co.edu.elpoli.task.services.dto.TaskDTO;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskService {
    List<Task> findAllByStatus(TaskStatus status);
    Task markTaskAsFinished(@Param("task_id") Long taskId);
    List<Task> findAll();
    Task create(TaskDTO task);
    Task deleteTaskById(Long taskId);
}
