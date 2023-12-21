package starter.fullsttack.labs.steps;

import java.util.List;
import java.util.Map;
import net.serenitybdd.annotations.Step;
import org.assertj.core.api.SoftAssertions;
import org.fluentlenium.core.annotation.Page;
import starter.fullsttack.labs.pages.CreateMonsterMainPage;
import starter.fullsttack.labs.pages.FormMonsterPage;
import starter.fullsttack.labs.pages.ListMonsterCreatedPage;
import starter.fullsttack.labs.pages.MonsterImagesPage;

public class CreateMonsterStep {

  @Page
  CreateMonsterMainPage createMonsterMainPage;

  @Page
  MonsterImagesPage monsterImagesPage;

  @Page
  FormMonsterPage formMonsterPage;

  @Page
  ListMonsterCreatedPage listMonsterCreatedPage;

  @Step("Open create your monster page")
  public void openPage() {
    createMonsterMainPage.open();
  }

  @Step("Add new monsters")
  public void addNewMonster(List<Map<String, String>> dataTable) {
    for (Map<String, String> dataMonster : dataTable) {
      monsterImagesPage.selectMonster(dataMonster.get("Number of monster"));
      formMonsterPage.putTheName(dataMonster.get("Name"));
      formMonsterPage.putHP(dataMonster.get("HP"));
      formMonsterPage.putAttack(dataMonster.get("Attack"));
      formMonsterPage.putDefense(dataMonster.get("Defense"));
      formMonsterPage.putSpeed(dataMonster.get("Speed"));
      formMonsterPage.sendMonsterInformation();
    }
  }

  @Step("Validate the monster creation")
  public void validateMonster(List<Map<String, String>> dataTable) {
    SoftAssertions softly = new SoftAssertions();
    for (Map<String, String> dataMonster : dataTable) {
      softly.assertThat(
              listMonsterCreatedPage.validateMonsterInList(dataMonster.get("Name")).isPresent())
          .isTrue();
    }
    softly.assertAll();
  }

  @Step
  public void createMonsterWithoutInformation() {
    formMonsterPage.sendMonsterInformation();
  }

  @Step
  public void validateMonsterCreationError() {
    formMonsterPage.fieldErrorState().shouldBePresent();
  }
}
