package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.example.demo.repository.TaskRepository;
import com.example.demo.model.Task;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }
}
