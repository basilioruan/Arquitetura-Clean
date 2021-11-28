package br.com.todolist.adapters.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.todolist.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{
	
	public Task findById(long id);
	
}
