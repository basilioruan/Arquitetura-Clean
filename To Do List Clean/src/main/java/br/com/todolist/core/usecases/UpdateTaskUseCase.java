package br.com.todolist.core.usecases;

import br.com.todolist.core.domain.Task;
import br.com.todolist.core.gateways.TaskRepositoryGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateTaskUseCase {

  private final TaskRepositoryGateway repository;

  public Task update(Task task) {
    return repository.saveAndFlush(task);
  }

  public Task complete(long id, boolean value) {
    Task task = repository.findById(id);
    task.setComplete(value);
    return update(task);
  }

}
