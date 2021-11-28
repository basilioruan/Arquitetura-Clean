package br.com.todolist.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.todolist.adapters.repositories.TaskRepository;

@Service
public class DeleteTask {

	@Autowired
	private TaskRepository repository;
	
	public void deleteById(long id) {
		repository.deleteById(id);
	}
	
}
