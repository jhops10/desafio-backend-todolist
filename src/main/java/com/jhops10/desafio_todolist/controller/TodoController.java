package com.jhops10.desafio_todolist.controller;

import com.jhops10.desafio_todolist.entity.Todo;
import com.jhops10.desafio_todolist.service.TodoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@Tag(name = "To-Do List (CRUD)", description = "Cadastro de To-Do")
public class TodoController {

    TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    @Operation(summary = "Criar uma To-Do", description = "Cria uma nova To-Do na lista")
    @ApiResponse(responseCode = "200", description = "To-Do criada com sucesso")
    public List<Todo> create(@RequestBody @Valid Todo todo) {

        return todoService.create(todo);
    }

    @GetMapping
    @Operation(summary = "Lista To-Do", description = "Busca uma lista de To-Do")
    @ApiResponse(responseCode = "200", description = "Lista de To-Do")
    public List<Todo> list() {

        return todoService.list();
    }


    @PutMapping
    @Operation(summary = "Atualizar To-Do", description = "Atualiza os dados de uma To-Do")
    @ApiResponse(responseCode = "200", description = "To-Do atualizada com sucesso")
    public List<Todo> update(@RequestBody Todo todo) {
        return todoService.update(todo);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Apagar To-Do", description = "Apaga uma To-Do através do ID")
    @ApiResponse(responseCode = "200", description = "To-Do apagada com sucesso")
    public List<Todo> delete(@PathVariable Long id) {
        return todoService.delete(id);
    }

}
