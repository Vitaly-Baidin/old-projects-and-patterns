package main;

import main.model.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import main.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/tasks/")
    public List<Task> all() {
        Iterable<Task> taskIterable = taskRepository.findAll();
        ArrayList<Task> tasks = new ArrayList<>();
        for (Task task : taskIterable) {
            tasks.add(task);
        }
        return tasks;
    }

    @PostMapping("/tasks/")
    public int newTask(Task task) {
        Task newTask = taskRepository.save(task);
        return newTask.getId();
    }

    @PutMapping("/tasks/")
    public List<Task> replaceAllTasks(@RequestParam String name, @RequestParam String description) {
        Iterable<Task> taskIterable = taskRepository.findAll();
        ArrayList<Task> tasks = new ArrayList<>();
        for (Task task : taskIterable) {
            task.setName(name);
            task.setDescription(description);
            tasks.add(task);
        }
        taskRepository.saveAll(tasks);
        return tasks;
    }

    @DeleteMapping("/tasks/")
    public void deleteAllTasks() {
        taskRepository.deleteAll();
    }


    @GetMapping("/tasks/{id}")
    public ResponseEntity one(@PathVariable int id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (!optionalTask.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(optionalTask.get(), HttpStatus.OK);
    }

    @PostMapping("/tasks/{id}")
    public ResponseEntity newTaskError() {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(null);
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity replaceTask(@PathVariable int id, @RequestParam String name, @RequestParam String description) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (!optionalTask.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        Task task = optionalTask.get();

        task.setName(name);
        task.setDescription(description);
        taskRepository.save(task);

        return new ResponseEntity(task, HttpStatus.OK);
    }

    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@PathVariable int id) {
        taskRepository.deleteById(id);
    }
}
