package starter.fullsttack.labs.steps;

import java.util.List;
import java.util.Map;
import net.serenitybdd.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import starter.fullsttack.labs.pages.ListMonsterCreatedPage;

public class DeleteMonsterStep {

  @Page
  ListMonsterCreatedPage listMonsterCreatedPage;

  @Step
  public void delete(List<Map<String, String>> dataMonster){
    listMonsterCreatedPage.deleteMonster(dataMonster.get(0).get("Name"));
  }

  @Step
  public void validateMonsterDeleted(List<Map<String, String>> dataMonster) {
    listMonsterCreatedPage.validateMonsterInList(dataMonster.get(0).get("Name")).shouldNotBePresent();
  }
}
