package br.com.todolist.adapters.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.todolist.adapters.entities.TaskEntity;

public interface TaskRepository extends JpaRepository<TaskEntity, Long>{
	
	public TaskEntity findById(long id);
	
}
