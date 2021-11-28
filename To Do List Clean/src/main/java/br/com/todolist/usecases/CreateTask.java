package br.com.todolist.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.todolist.adapters.repositories.TaskRepository;
import br.com.todolist.entities.Task;

@Service
public final class CreateTask {
	
	@Autowired
	private TaskRepository repository;
	
	public Task create(Task task) {
		return repository.save(task);
	}
	
}
