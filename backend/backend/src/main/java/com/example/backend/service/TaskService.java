package com.example.backend.service;
import com.example.backend.model.Task;
import com.example.backend.model.Tasknames;
import com.example.backend.repository.TaskRepository;
import com.example.backend.repository.TasknamesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private TasknamesRepository tasknamesRepository;


    public List<Task> getUserTasks(String email) {
        return taskRepository.findByEmail(email);
    }

    public void addTask(Task task) {
        Task existingTask = taskRepository.findById(task.getEmail()).orElse(null);
        
        if(existingTask != null) {
            existingTask.getTasknames().addAll(task.getTasknames());
            taskRepository.save(existingTask); 
        } else {
            taskRepository.save(task);
        }
    }
    public void deleteTaskById(Long tid){
        tasknamesRepository.deleteById(tid);
    }
    public List<Tasknames> getTabledetails(String email){
        return tasknamesRepository.findByAssignedby(email);
    }
    public void updateTaskStatus(long taskId, String status) {
        Tasknames t =  tasknamesRepository.findById(taskId).orElse(null);
        if(t!=null){
            t.setStatus(status);
            tasknamesRepository.save(t);
        }

    }
}
