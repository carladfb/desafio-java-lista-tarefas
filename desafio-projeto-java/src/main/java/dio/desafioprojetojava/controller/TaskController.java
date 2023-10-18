package dio.desafioprojetojava.controller;

import java.util.List;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dio.desafioprojetojava.model.Task;
import dio.desafioprojetojava.repository.TaskRepository;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @GetMapping
    public String listTask(Model model) {
        List<Task> task = taskRepository.findAll();
        model.addAttribute("newTask", new Task());;
        return "taskList";
    }

    @PostMapping
    public String addTask(@ModelAttribute Task task) {
        taskRepository.save(task);
        return "redirect:/tasks";
    }

    @GetMapping("/remove/{id}")
    public String removeTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
        return "redirect:/tasks";
    }

    @GetMapping("/completed")
    public String listCompletedTasks(Model model) {
        List<Task> completedTasks = taskRepository.findByCompleted(true);
        model.addAttribute("tasks", completedTasks);
        return "taskList";
    }

    @GetMapping("/not-completed")
    public String listNotCompletedTasks(Model model) {
        List<Task> tasksNotCompleted = taskRepository.findByCompletedFalse();
        model.addAttribute("tasks", tasksNotCompleted);
        return "taskList";
    }   
}
