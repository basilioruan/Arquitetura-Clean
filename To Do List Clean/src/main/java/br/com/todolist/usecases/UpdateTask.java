package br.com.todolist.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.todolist.adapters.repositories.TaskRepository;
import br.com.todolist.entities.Task;

@Service
public class UpdateTask {

	@Autowired
	private TaskRepository repository;
	
	public Task update(Task task) {
		return repository.saveAndFlush(task);
	}
	
	public Task complete(long id, boolean value) {
		Task task = repository.findById(id);
		task.setComplete(value);
		return update(task);
	}
	
}
