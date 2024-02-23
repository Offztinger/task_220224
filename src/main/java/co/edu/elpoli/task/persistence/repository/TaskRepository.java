package co.edu.elpoli.task.persistence.repository;

import co.edu.elpoli.task.persistence.entity.Task;
import co.edu.elpoli.task.persistence.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task> findAllByStatus(TaskStatus status);
    @Modifying
    @Query(value="UPDATE tasks SET finished=TRUE WHERE task_id=:task_id", nativeQuery = true) void markTaskAsFinished(@Param("task_id") Long taskId);
}
