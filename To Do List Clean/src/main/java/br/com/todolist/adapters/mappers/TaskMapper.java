package br.com.todolist.adapters.mappers;

import br.com.todolist.adapters.dtos.TaskDto;
import br.com.todolist.adapters.entities.TaskEntity;
import br.com.todolist.core.domain.Task;

import java.util.Objects;

public class TaskMapper {

  public static Task toDomain(TaskEntity entity) {
    if (Objects.isNull(entity)) {
      return null;
    }

    return Task.builder()
        .id(entity.getId())
        .name(entity.getName())
        .description(entity.getDescription())
        .date(entity.getDate())
        .build();
  }

  public static Task toDomain(TaskDto dto) {
    if (Objects.isNull(dto)) {
      return null;
    }

    return Task.builder()
        .id(dto.getId())
        .name(dto.getName())
        .description(dto.getDescription())
        .date(dto.getDate())
        .build();
  }

  public static TaskEntity toEntity(Task domain) {
    if (Objects.isNull(domain)) {
      return null;
    }

    return TaskEntity.builder()
        .id(domain.getId())
        .name(domain.getName())
        .description(domain.getDescription())
        .date(domain.getDate())
        .build();
  }

  public static TaskDto toDto(Task domain) {
    if (Objects.isNull(domain)) {
      return null;
    }

    return TaskDto.builder()
        .id(domain.getId())
        .name(domain.getName())
        .description(domain.getDescription())
        .date(domain.getDate())
        .build();
  }

  public static TaskDto toDto(TaskEntity entity) {
    if (Objects.isNull(entity)) {
      return null;
    }

    return TaskDto.builder()
        .id(entity.getId())
        .name(entity.getName())
        .description(entity.getDescription())
        .date(entity.getDate())
        .build();
  }

}
