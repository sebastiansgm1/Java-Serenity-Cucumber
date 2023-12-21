package starter.fullsttack.labs.definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import java.util.Map;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import starter.fullsttack.labs.steps.DeleteMonsterStep;

public class DeleteMonsterDefinition {

  @Steps
  DeleteMonsterStep deleteMonsterStep;

  List<Map<String, String>> dataMonster = Serenity.sessionVariableCalled("monster information");

  @When("I eliminate the monster")
  public void deleteMonster(){
    deleteMonsterStep.delete(dataMonster);
  }

  @Then("It should not appear on the list")
  public void validateMonsterDeleted(){
    deleteMonsterStep.validateMonsterDeleted(dataMonster);
  }

}
