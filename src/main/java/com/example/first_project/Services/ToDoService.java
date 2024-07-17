package com.example.first_project.Services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.example.first_project.Models.ToDo;

@Service
public class ToDoService {
    
    private List<ToDo> list = new ArrayList<>();
    // create
    public ToDo create(ToDo todo){
        list.add(todo);
        return todo;
    }
    // get all
    public List<ToDo> getList(){
        return list;
    }
    // delete by id
    public ToDo delete(int id)  {
        for(ToDo todo : list){
            if(Objects.equals(todo.getId(), id)){
                list.remove(todo);
                return  todo;
            }
        }
        return null;
    }

    // update by it
    public ToDo update(int id, ToDo todo){
        for(ToDo t : list){
            if(Objects.equals(t.getId(), id)){
                t.setId(todo.getId());
                t.setContent(todo.getContent());
                return  todo;
            }
        }
        return  null;
    }

    public  ToDo getTodo(int id){
        for(ToDo todo : list){
            if(Objects.equals(todo.getId(), id)){
                return  todo;
            }
        }
        return null;
    }
}
