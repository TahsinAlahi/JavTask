package model;

import enums.TaskStatus;
import utils.IdGenerator;

public class Task {
    private final int id;
    private String title;
    private String description;
    private TaskStatus status;

    //Constructor
    public Task(String title, String description) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title can not be empty");
        }
        this.id = IdGenerator.generateId();
        this.title = title;
        this.description = description;
        this.status = TaskStatus.TODO;
    }

    //    getters and setters
    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public TaskStatus getStatus() {
        return status;
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
