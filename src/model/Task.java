package model;

import enums.TaskStatus;
import utils.IdGenerator;

import java.time.LocalDate;

public class Task {
    private final int id;
    private String title;
    private String description;
    private TaskStatus status;
    private LocalDate dueDate;

    //Constructor
    public Task(String title, String description, LocalDate dueDate) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title can not be empty");
        }
        this.id = IdGenerator.generateId();
        this.title = title;
        this.description = description;
        this.status = TaskStatus.TODO;
        this.dueDate = dueDate;
    }

    //getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    //    Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }


    //    ToString lol
    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", status=" + status +
                '}';
    }

    //Functionalities
    public void markInProgress() {
        setStatus(TaskStatus.IN_PROGRESS);
    }

    public void markDone() {
        setStatus(TaskStatus.DONE);
    }

    public void markTodo() {
        setStatus(TaskStatus.TODO);
    }
}
