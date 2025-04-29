package com.example.backend.controller;
import com.example.backend.dto.UpdateStatusDTO;
import com.example.backend.model.Task;
import com.example.backend.model.Tasknames;
import com.example.backend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "http://localhost:8081/")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/gettask/{email}")
    public ResponseEntity<List<Task>> getUserTasks(@PathVariable String email) {
        List<Task> tasks = taskService.getUserTasks(email);
        return ResponseEntity.ok(tasks);
    }

    @PostMapping("/savetask")
    public ResponseEntity<Task> addTask(@RequestBody Task task) {
        System.out.print(task);
        taskService.addTask(task);
        return ResponseEntity.ok(task);
    }
    @DeleteMapping("/delete/{tid}")
    public ResponseEntity<?> deleteTask(@PathVariable("tid") Long tid) {
        try {
            taskService.deleteTaskById(tid);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting task");
        }
    }
    @GetMapping("/getTabledetails")
    public ResponseEntity<List<Tasknames>> getTabledet(@RequestParam String email){
        List<Tasknames> tasks = taskService.getTabledetails(email);
        return ResponseEntity.status(200).body(tasks);
    }
    @PutMapping("/updatestatus/{taskId}")
    public void updateTaskStatus(@PathVariable long taskId, @RequestBody UpdateStatusDTO updateStatusDTO) {
        taskService.updateTaskStatus(taskId, updateStatusDTO.getStatus());
    }

}
