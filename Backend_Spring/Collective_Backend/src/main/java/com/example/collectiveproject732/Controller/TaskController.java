package com.example.collectiveproject732.Controller;

import com.example.collectiveproject732.Model.Task;
import com.example.collectiveproject732.Service.Exceptions.ServiceException;
import com.example.collectiveproject732.Service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("localhost:4200")
@RestController
@RequestMapping("api/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/add")
    public ResponseEntity<Task> saveTask(@RequestBody Task task){
        return ResponseEntity.ok(this.taskService.save(task));
    }
}
