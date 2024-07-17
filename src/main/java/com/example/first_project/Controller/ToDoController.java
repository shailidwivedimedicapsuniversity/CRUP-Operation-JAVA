package com.example.first_project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.first_project.Models.ToDo;
import com.example.first_project.Services.ToDoService;

import java.util.List;

@RestController
@RequestMapping("/todos")
// creating is a simple todo application where I am creating crud operation using rest apis
public class ToDoController {

    @Autowired
    private ToDoService toDoService;
    // localhost:8080 is base url and @requestmapping is giving endpoint for req mapping

    // C
    @PostMapping
    public ToDo createTask(@RequestBody ToDo todo){
        return toDoService.create(todo);
    }

    // R
    @GetMapping
    public List<ToDo> getAllTask(){
        return toDoService.getList();
    }

    @GetMapping("/{id}")
    public ToDo getTodo(@PathVariable int id) {
        return  toDoService.getTodo(id);
    }

    // U

    @PutMapping("/{id}")
    public ToDo updateTodo(@PathVariable int id, @RequestBody ToDo updatedTodo) {
        ToDo todo = toDoService.update(id, updatedTodo);
        if (todo != null) {
            return todo; // Returns the updated Todo
        } else {
            throw new RuntimeException("Todo not found"); // Throws an error if not found
        }
    }

    // D
    @DeleteMapping("/{id}")
    public ResponseEntity<ToDo> deleteTodo(@PathVariable int id) {
        // ResponseEntity inclueds - http status code, header , body
        try {
            ToDo deletedTodo = toDoService.delete(id);
            return ResponseEntity.ok(deletedTodo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }





}
