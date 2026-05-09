package br.com.todolist.config;

import br.com.todolist.core.gateways.TaskRepositoryGateway;
import br.com.todolist.core.usecases.CreateTask;
import br.com.todolist.core.usecases.DeleteTask;
import br.com.todolist.core.usecases.SearchTask;
import br.com.todolist.core.usecases.UpdateTask;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskBeanConfig {

  @Bean
  public CreateTask createTask(TaskRepositoryGateway taskRepositoryGateway) {
    return new CreateTask(taskRepositoryGateway);
  }

  @Bean
  public DeleteTask deleteTask(TaskRepositoryGateway taskRepositoryGateway) {
    return new DeleteTask(taskRepositoryGateway);
  }

  @Bean
  public SearchTask searchTask(TaskRepositoryGateway taskRepositoryGateway) {
    return new SearchTask(taskRepositoryGateway);
  }

  @Bean
  public UpdateTask updateTask(TaskRepositoryGateway taskRepositoryGateway) {
    return new UpdateTask(taskRepositoryGateway);
  }

}
