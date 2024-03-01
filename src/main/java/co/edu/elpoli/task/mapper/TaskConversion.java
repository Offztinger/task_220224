package co.edu.elpoli.task.mapper;

import co.edu.elpoli.task.persistence.entity.Task;
import co.edu.elpoli.task.persistence.entity.TaskStatus;
import co.edu.elpoli.task.services.dto.TaskDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class TaskConversion implements IMapper<TaskDTO, Task> {
    @Override
    public Task mapper (TaskDTO in) {
        Task task = new Task();
        task.setName(in.getName());
        task.setDescription(in.getDescription());
        task.setDataCreate(LocalDate.now());
        task.setFinished(false);
        task.setStatus(TaskStatus.ON_TIME);
        return task;
    }
}
