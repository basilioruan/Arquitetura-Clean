package br.com.todolist.architecture;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

public class ArchitectureTest {

    JavaClasses classes = new ClassFileImporter()
            .importPackages("br.com.todolist");

    @Test
    void entitiesNaoDevemDependenDeAdapters() {
        ArchRule rule = noClasses()
                .that().resideInAPackage("..entities..")
                .should().dependOnClassesThat()
                .resideInAPackage("..adapters..");

        rule.check(classes);
    }

}
