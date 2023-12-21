package starter.fullsttack.labs.definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import starter.fullsttack.labs.steps.CreateMonsterStep;

public class CreateMonsterDefinition {

  @Steps
  CreateMonsterStep createMonsterStep;

  private List<Map<String, String>> dataTableClass = new ArrayList<>();

  @Given("I entered the page create your monster")
  public void openMonsterPage() {
    createMonsterStep.openPage();
  }

  @When("I add a monster with the following data")
  @When("I add the monsters with the data")
  public void addMonster(List<Map<String, String>> dataTable) {
    dataTableClass = dataTable;
    Serenity.setSessionVariable("monster information").to(dataTable);
    createMonsterStep.addNewMonster(dataTable);
  }

  @Then("It is valid for the monster to appear of the list")
  @Then("I must see the created monsters in the list")
  public void validateMonsterList() {
    createMonsterStep.validateMonster(dataTableClass);
  }

  @When ("I try to create a monster with empty fields")
  public void createEmptyMonster(){
    createMonsterStep.createMonsterWithoutInformation();
  }

  @Then ("an error will appear indicating that I must complete all of the fields")
  public void validateCreationError(){
    createMonsterStep.validateMonsterCreationError();
  }

}
