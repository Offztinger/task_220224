package co.edu.elpoli.task.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "tasks")
public class Task {
    private long taskId;
    private String name;
    private String description;
    private LocalDate dataCreate;
    private boolean finished;
    private TaskStatus status;
}
