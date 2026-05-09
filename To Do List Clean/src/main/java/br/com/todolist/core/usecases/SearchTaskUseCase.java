package br.com.todolist.core.usecases;

import br.com.todolist.core.domain.Task;
import br.com.todolist.core.gateways.TaskRepositoryGateway;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class SearchTaskUseCase {

  private final TaskRepositoryGateway repository;

  public List<Task> findAll() {
    return repository.findAll();
  }

  public Task findById(long id) {
    return repository.findById(id);
  }

}
