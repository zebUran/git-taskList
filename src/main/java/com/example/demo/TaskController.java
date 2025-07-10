package com.example.demo;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import java.util.List;
import java.util.Date;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TaskController {

    private final TaskItemRepository repository;

    public TaskController(TaskItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<TaskItem> taskList = repository.findAll();
        List<TaskItem> filtered = taskList.stream().filter(task -> task.getIsDeleted() == 0).toList();
        model.addAttribute("taskList", filtered);
        return "index"; // templates/index.html を表示
    }

    @PostMapping("/add")
    public String addTask(@RequestParam("todo_item") String taskItem, @RequestParam("expiration_date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date expirationDate) {
        
        TaskItem task = new TaskItem();
        task.setTaskItem(taskItem);
        task.setExpirationDate(expirationDate);
        task.setIsCompleted((short) 0);
        task.setIsDeleted((short) 0);

        Date now = new Date();
        task.setCreateDateTime(now);
        task.setUpdateDateTime(now);

        repository.save(task);
        
        return "redirect:/";
    }
    
}
