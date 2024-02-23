package co.edu.elpoli.task.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="task_id")
    private long taskId;
    private String name;
    private String description;
    @Column(name="create_date")
    private LocalDate dataCreate;
    private boolean finished;
    private TaskStatus status;
}
