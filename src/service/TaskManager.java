package service;

import enums.TaskStatus;
import model.Task;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private final List<Task> tasks = new ArrayList<>();

    private Task findItemBinary(int id) {
        int l = 0, r = tasks.size() - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            Task tempTask = tasks.get(mid);

            if (tempTask.getId() == id) {
                return tempTask; // found
            } else if (tempTask.getId() < id) {
                l = mid + 1; // search right half
            } else {
                r = mid - 1; // search left half
            }
        }

        return null; // not found
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public Task getTask(int id) {
        for (Task t : tasks) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    public boolean deleteTask(int id) {
        Task task = getTask(id);
        if (task == null) {
            return false;
        } else {
            tasks.remove(task);
            return true;
        }
    }

    public void listTasks() {
        for (Task t : tasks) {
            System.out.println(t.toString());
        }
    }

    public List<Task> filterTaskByStatus(TaskStatus status) {
        List<Task> filteredTask = new ArrayList<>();
        for (Task t : tasks) {
            if (t.getStatus() == status) {
                filteredTask.add(t);
            }
        }
        return filteredTask;
    }

    public List<Task> filterByDate(LocalDate dueDate) {
        List<Task> filteredTask = new ArrayList<>();
        for (Task t : tasks) {
            if (t.getDueDate().equals(dueDate)) {
                filteredTask.add(t);
            }
        }
        return filteredTask;
    }

    public List<Task> sortByDate(LocalDate dueDate) {
        // Will work on it later;
        return null;
    }

    public List<Task> searchTasks(String keywords) {
        List<Task> foundTask = new ArrayList<>();
        for (Task t : tasks) {
            if (t.getTitle().contains(keywords) || t.getDescription().contains(keywords)) {
                foundTask.add(t);
            }
        }
        return foundTask;
    }
}
