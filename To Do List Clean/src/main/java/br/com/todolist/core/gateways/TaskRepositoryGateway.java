package br.com.todolist.core.gateways;

import br.com.todolist.core.domain.Task;

import java.util.List;

public interface TaskRepositoryGateway {

  Task save(Task task);

  Task saveAndFlush(Task task);

  void deleteById(Long id);

  List<Task> findAll();

  Task findById(Long id);

}
