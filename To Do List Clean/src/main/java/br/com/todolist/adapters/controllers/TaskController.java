package br.com.todolist.adapters.controllers;

import br.com.todolist.adapters.dtos.TaskDto;
import br.com.todolist.adapters.mappers.TaskMapper;
import br.com.todolist.core.domain.Task;
import br.com.todolist.core.usecases.CreateTaskUseCase;
import br.com.todolist.core.usecases.DeleteTaskUseCase;
import br.com.todolist.core.usecases.SearchTaskUseCase;
import br.com.todolist.core.usecases.UpdateTaskUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("todolist")
@RequiredArgsConstructor
public class TaskController {

  private final CreateTaskUseCase createTaskUseCase;

  private final SearchTaskUseCase searchTaskUseCase;

  private final UpdateTaskUseCase updateTaskUseCase;

  private final DeleteTaskUseCase deleteTaskUseCase;

  @GetMapping("/index")
  public ResponseEntity<List<TaskDto>> index() {
    try {
      List<Task> response = searchTaskUseCase.findAll();
      return ResponseEntity.ok(response.stream().map(TaskMapper::toDto).toList());
    } catch (Exception ex) {
      throw ex;
    }
  }

  @GetMapping("/indexof/{id}")
  public ResponseEntity<TaskDto> indexOf(@PathVariable(value = "id") long id) {
    try {
      Task response = searchTaskUseCase.findById(id);
      return ResponseEntity.ok(TaskMapper.toDto(response));
    } catch (Exception ex) {
      throw ex;
    }
  }

  @PostMapping("/insert")
  public ResponseEntity<String> insert(@RequestBody TaskDto taskDto) {
    try {
      createTaskUseCase.create(TaskMapper.toDomain(taskDto));
      return new ResponseEntity<>("Sucessfully saved", HttpStatus.CREATED);
    } catch (Exception ex) {
      throw ex;
    }
  }

  @PutMapping("/update")
  public ResponseEntity<String> update(@RequestBody TaskDto taskDto) {
    try {
      updateTaskUseCase.update(TaskMapper.toDomain(taskDto));
      return new ResponseEntity<>("Sucessfully updated", HttpStatus.ACCEPTED);
    } catch (Exception ex) {
      throw ex;
    }
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<String> delete(@PathVariable(value = "id") long id) {
    try {
      deleteTaskUseCase.deleteById(id);
      return ResponseEntity.ok("Sucessfully deleted");
    } catch (Exception ex) {
      throw ex;
    }
  }

  @GetMapping("/complete/{id}/{value}")
  public ResponseEntity<String> complete(@PathVariable(value = "id") long id, @PathVariable(value = "value") boolean value) {
    try {
      updateTaskUseCase.complete(id, value);
      return ResponseEntity.ok("Sucessfully change of complete");
    } catch (Exception ex) {
      throw ex;
    }
  }

}
