package br.com.todolist.core.usecases;

import br.com.todolist.core.domain.Task;
import br.com.todolist.core.gateways.TaskRepositoryGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateTaskUseCase {

	private final TaskRepositoryGateway repository;
	
	public Task create(Task task) {
		return repository.save(task);
	}
	
}
