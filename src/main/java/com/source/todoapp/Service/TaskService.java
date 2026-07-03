package com.source.todoapp.Service;

import com.source.todoapp.Model.Task;
import com.source.todoapp.Repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TaskService {

    private final TaskRepository taskRepository;

    public Task create(Task task) {
        return taskRepository.save(task);
    }

    @Transactional(readOnly = true)
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Task findById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Task not found with id: " +id));
    }
    public Task update(Long id, Task task) {
        taskRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Task not found with id: " +id));
        return taskRepository.save(task);
    }
    public void delete(Long Id) {
        taskRepository.findById(Id)
                        .orElseThrow(()->new RuntimeException("Task not found with id: " +Id));
        taskRepository.deleteById(Id);
    }
    @Transactional(readOnly = true)
    public List<Task> findAllCompleted(){
        return taskRepository.findByCompletedTrue();
    }
    @Transactional(readOnly = true)
    public List<Task> findNotCompleted() {
        return taskRepository.findByCompletedFalse();
    }
}
