package br.com.todolist.architecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(packages = "br.com.todolist")
public class ArchitectureTest {

  @ArchTest
  static final ArchRule camadasDevemRespeitarEstruturaCleanArchitecture = layeredArchitecture()
      .consideringAllDependencies()
      .layer("Controllers").definedBy("..adapters.controllers..")
      .layer("Usecases").definedBy("..core.usecases..")
      .layer("Gateways").definedBy("..core.gateways..")
      .layer("Repositories").definedBy("..adapters.repositories..")
      .layer("Config").definedBy("..config..")

      .whereLayer("Controllers").mayNotBeAccessedByAnyLayer()
      .whereLayer("Usecases").mayOnlyBeAccessedByLayers("Controllers", "Config")
      .whereLayer("Gateways").mayOnlyBeAccessedByLayers("Usecases", "Repositories", "Config")
      .whereLayer("Repositories").mayOnlyBeAccessedByLayers("Config");

}
