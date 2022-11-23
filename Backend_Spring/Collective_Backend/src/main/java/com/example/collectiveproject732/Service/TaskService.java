package com.example.collectiveproject732.Service;

import com.example.collectiveproject732.Model.Task;
import com.example.collectiveproject732.Model.viewmodel.TaskViewModel;
import com.example.collectiveproject732.Repository.ITaskRepository;
import com.example.collectiveproject732.Service.Exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Service
public class TaskService {
    public TaskRepository taskRepository;

    public TaskService(TaskRepository repository){
        this.taskRepository = repository;
    }    
    
    public Task save(Task task){
        this.taskRepository.save(task);
        return task;
    }
}
