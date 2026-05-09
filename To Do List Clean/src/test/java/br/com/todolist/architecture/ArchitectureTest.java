package br.com.todolist.architecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.core.domain.JavaClass.Predicates.resideInAPackage;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noFields;
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
      .layer("Domain").definedBy("..core.domain..")
      .layer("Entities").definedBy("..adapters.entities..")
      .layer("Mappers").definedBy("..adapters.mappers..")

      .whereLayer("Controllers").mayNotBeAccessedByAnyLayer()
      .whereLayer("Usecases").mayOnlyBeAccessedByLayers("Controllers", "Config")
      .whereLayer("Gateways").mayOnlyBeAccessedByLayers("Usecases", "Repositories", "Config")
      .whereLayer("Domain").mayOnlyBeAccessedByLayers("Usecases", "Gateways", "Mappers", "Repositories", "Controllers")
      .whereLayer("Entities").mayOnlyBeAccessedByLayers("Repositories", "Mappers")
      .whereLayer("Repositories").mayOnlyBeAccessedByLayers("Config");

  @ArchTest
  static final ArchRule coreNaoDeveDependerDeAdapters = noClasses()
      .that().resideInAPackage("..core..")
      .should().dependOnClassesThat().resideInAPackage("..adapters..");

  @ArchTest
  static final ArchRule coreNaoDeveTerAnotacoesDoSpringOuJpa = noClasses()
      .that().resideInAPackage("..core..")
      .should().dependOnClassesThat()
      .resideInAnyPackage("org.springframework..", "jakarta.persistence..", "javax.persistence..");

  @ArchTest
  static final ArchRule controllersDevemChamarApenasUsecases = noClasses()
      .that().resideInAPackage("..adapters.controllers..")
      .should().dependOnClassesThat().resideInAPackage("..adapters.repositories..");

  @ArchTest
  static final ArchRule naoDeveUtilizarFieldInjection = noFields()
      .should().beAnnotatedWith("org.springframework.beans.factory.annotation.Autowired")
      .because("Devemos utilizar injeção via construtor");

  @ArchTest
  static final ArchRule usecasesDevemEstarNoPacoteDeUsecasesTerNomeApropriado = classes()
      .that().resideInAPackage("..core.usecases..")
      .should().haveSimpleNameEndingWith("UseCase")
      .orShould().haveSimpleNameStartingWith("Create")
      .orShould().haveSimpleNameStartingWith("Delete");

  @ArchTest
  static final ArchRule controllersNaoDevemRetornarEntidadesDoCore = methods()
      .that().areDeclaredInClassesThat().resideInAPackage("..adapters.controllers..")
      .and().arePublic()
      .should().notHaveRawReturnType(resideInAPackage("..adapters.entities.."))
      .because("Controllers devem converter entidades de domínio em DTOs");

}
