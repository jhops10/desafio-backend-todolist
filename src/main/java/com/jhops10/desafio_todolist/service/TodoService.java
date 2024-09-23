package com.jhops10.desafio_todolist.service;

import com.jhops10.desafio_todolist.entity.Todo;
import com.jhops10.desafio_todolist.repository.TodoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }



    public List<Todo> create(Todo todo) {
        todoRepository.save(todo);
        return list();
    }


    public List<Todo> list() {
        Sort.by("prioridade").descending().and(
                Sort.by("nome").ascending());
        return todoRepository.findAll();
    }


    public List<Todo> update(Todo todo) {
        todoRepository.save(todo);
        return list();
    }


    public List<Todo> delete(Long id) {
        todoRepository.deleteById(id);
        return list();
    }


}
