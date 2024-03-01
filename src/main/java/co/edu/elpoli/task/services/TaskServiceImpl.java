package co.edu.elpoli.task.services;

import co.edu.elpoli.task.mapper.TaskConversion;
import co.edu.elpoli.task.persistence.entity.Task;
import co.edu.elpoli.task.persistence.entity.TaskStatus;
import co.edu.elpoli.task.persistence.repository.TaskRepository;
import co.edu.elpoli.task.services.dto.TaskDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskConversion taskConversion;
    @Override
    public List<Task> findAllByStatus(TaskStatus status) {
        return taskRepository.findAllByStatus(status);
    }

    @Override
    public List<Task> findAll() {
        return null;
    }
    @Override
    public Task create(TaskDTO task) {
        return taskRepository.save(taskConversion.mapper(task));
    }
    @Override
    public Task markTaskAsFinished(Long taskId) {
        Optional<Task> task = taskRepository.findById(taskId);
        if(task.isEmpty()) return null;
        taskRepository.markTaskAsFinished(taskId);
        return task.orElse(null);
    }
    @Override
    public Task deleteTaskById(Long taskId) {
        Optional<Task> task = taskRepository.findById(taskId);
        if(task.isEmpty()) return null;
        taskRepository.deleteById(taskId);
        return task.orElse(null);
    }
}
