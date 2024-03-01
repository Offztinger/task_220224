package co.edu.elpoli.task.controller;
import co.edu.elpoli.task.persistence.entity.Task;
import co.edu.elpoli.task.persistence.entity.TaskStatus;
import co.edu.elpoli.task.services.TaskService;
import co.edu.elpoli.task.services.dto.TaskDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping()
    public List<Task> findAll(){
        return taskService.findAll();
    }

    @GetMapping("/status/{status}")
    public List<Task> findAllByTaskStatus(@PathVariable("status") TaskStatus status){
        return taskService.findAllByStatus(status);
    }

    @PostMapping()
    public Task createTask(@RequestBody TaskDTO task){
        return taskService.create(task);
    }

    @PatchMapping("markTaskAsFinished/{taskid}")
    public Task markTaskAsFinished(@PathVariable("taskid") Long taskId){
        return taskService.markTaskAsFinished(taskId);
    }

    @DeleteMapping("delete/{taskid}")
    public Task deleteTask(@PathVariable("taskid") Long taskId){
        return taskService.deleteTaskById(taskId);
    }

}
