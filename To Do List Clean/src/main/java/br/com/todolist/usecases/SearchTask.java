package br.com.todolist.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.todolist.adapters.repositories.TaskRepository;
import br.com.todolist.entities.Task;

@Service
public final class SearchTask {
	
	@Autowired
	private TaskRepository repository;
	
	public List<Task> findAll() {
		return repository.findAll();
	}
	
	public Task findById(long id) {
		return repository.findById(id);
	}
	
}
