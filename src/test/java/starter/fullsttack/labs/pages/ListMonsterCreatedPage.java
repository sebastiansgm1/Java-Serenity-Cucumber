package starter.fullsttack.labs.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementState;

public class ListMonsterCreatedPage extends PageObject {

  public WebElementState validateMonsterInList(String nameMonster){
    return $("//*[@data-testid='card-monster-name'][text()='{0}']", nameMonster);
  }

  public void deleteMonster(String name) {
      $("//*[@data-testid='card-monster-name'][text()='{0}']//..//button[@data-testid='btn-delete']", name).click();
  }
}
