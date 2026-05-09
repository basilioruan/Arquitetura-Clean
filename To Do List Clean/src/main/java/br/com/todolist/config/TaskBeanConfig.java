package br.com.todolist.config;

import br.com.todolist.core.gateways.TaskRepositoryGateway;
import br.com.todolist.core.usecases.CreateTaskUseCase;
import br.com.todolist.core.usecases.DeleteTaskUseCase;
import br.com.todolist.core.usecases.SearchTaskUseCase;
import br.com.todolist.core.usecases.UpdateTaskUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskBeanConfig {

  @Bean
  public CreateTaskUseCase createTask(TaskRepositoryGateway taskRepositoryGateway) {
    return new CreateTaskUseCase(taskRepositoryGateway);
  }

  @Bean
  public DeleteTaskUseCase deleteTask(TaskRepositoryGateway taskRepositoryGateway) {
    return new DeleteTaskUseCase(taskRepositoryGateway);
  }

  @Bean
  public SearchTaskUseCase searchTask(TaskRepositoryGateway taskRepositoryGateway) {
    return new SearchTaskUseCase(taskRepositoryGateway);
  }

  @Bean
  public UpdateTaskUseCase updateTask(TaskRepositoryGateway taskRepositoryGateway) {
    return new UpdateTaskUseCase(taskRepositoryGateway);
  }

}
