package br.com.todolist.core.usecases;

import br.com.todolist.core.gateways.TaskRepositoryGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteTaskUseCase {

  private final TaskRepositoryGateway repository;

  public void deleteById(long id) {
    repository.deleteById(id);
  }

}
