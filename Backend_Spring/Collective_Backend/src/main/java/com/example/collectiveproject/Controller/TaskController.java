package com.example.collectiveproject.Controller;

import com.example.collectiveproject.Model.DTO.TaskDTO;
import com.example.collectiveproject.Model.Task;
import com.example.collectiveproject.Service.AssignationService;
import com.example.collectiveproject.Service.TaskService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @Autowired
    private AssignationService assignationService;

    @GetMapping("/allTasks")
    public List<TaskDTO> getAllTasks(){return taskService.getTasks(); }

    @RequestMapping(value="/addTask", method = RequestMethod.POST)
    public TaskDTO addTask(@RequestBody TaskDTO taskDTO) throws Exception {
        Task task = this.taskService.convertDtoToEntity(taskDTO);
        Task taskCreated = this.taskService.addTask(task);
        return taskService.convertEntityToDto(taskCreated);
    }
    
    @GetMapping("/find-by-username/{username}")
    public List<TaskDTO> findAllTasksByUsername(@PathVariable(value="username") String username){
        return this.taskService.findAllByUsername(username);
    }

    @PostMapping("/assign-task/{taskName}/{username}")
    public boolean assignTask(@PathVariable(value="taskName") String taskName,
                              @PathVariable(value="username") String username){
        return assignationService.assignTaskToUser(taskName, username);
    }

    @PostMapping("/unassign-task/{taskName}/{username}")
    public boolean unassignTask(@PathVariable(value="taskName") String taskName,
                              @PathVariable(value="username") String username){
        return assignationService.unAssignTaskFromUser(taskName, username);
    }

    @PostMapping("/mark-done/{taskName}/{userName}")
    public boolean markDone(@PathVariable(value="taskName") String taskName,
                            @PathVariable(value="userName") String userName){
        return taskService.markDone(taskName, userName);
    }

    @PostMapping("/mark-undone/{taskName}/{userName}")
    public boolean markUnDone(@PathVariable(value="taskName") String taskName,
                              @PathVariable(value="userName") String userName){
        return taskService.markUnDone(taskName, userName);
    }


    /**
     * Endpoint for deleting a task
     * Method: DELETE
     * @param id the id of the expense to delete
     * @return a ResponseEntity with the TaskViewModel corresponding to the added task
     *         or with an error message if the task could not be added
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok().build();
    }

    /**
     * Endpoint for updating a task
     * Method: PUT
     * Requires Authorization header
     * @param objectDTO the new data for the task
     * @param id the id of the task to be updated
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Task> updateTask(@RequestBody TaskDTO objectDTO, @PathVariable Long id) {
        Task task = taskService.convertDtoToEntity(objectDTO);
        if (!task.getId().equals(id)) {
            return ResponseEntity.badRequest().build();
        }
        Task updatedTask  = taskService.updateTask(task);
        return ResponseEntity.ok(updatedTask);
    }

}
