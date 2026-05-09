package br.com.todolist.adapters.repositories;

import br.com.todolist.adapters.entities.TaskEntity;
import br.com.todolist.adapters.mappers.TaskMapper;
import br.com.todolist.core.domain.Task;
import br.com.todolist.core.gateways.TaskRepositoryGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
@RequiredArgsConstructor
public class TaskRepositoryAdapter implements TaskRepositoryGateway {

  private final TaskRepository repository;

  @Override
  public Task save(Task task) {
    if (Objects.isNull(task)) {
      return null;
    }

    TaskEntity entity = repository.save(TaskMapper.toEntity(task));

    return TaskMapper.toDomain(entity);
  }

  @Override
  public Task saveAndFlush(Task task) {
    if (Objects.isNull(task)) {
      return null;
    }

    TaskEntity entity = repository.saveAndFlush(TaskMapper.toEntity(task));

    return TaskMapper.toDomain(entity);
  }

  @Override
  public void deleteById(Long id) {
    if (Objects.nonNull(id)) {
      repository.deleteById(id);
    }
  }

  @Override
  public List<Task> findAll() {
    return repository.findAll().stream().map(TaskMapper::toDomain).toList();
  }

  @Override
  public Task findById(Long id) {
    if (Objects.isNull(id)) {
      return null;
    }

    TaskEntity entity = repository.findById(id).orElse(null);

    return TaskMapper.toDomain(entity);
  }
}
