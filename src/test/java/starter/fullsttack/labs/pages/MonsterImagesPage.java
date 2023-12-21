package starter.fullsttack.labs.pages;

import net.serenitybdd.core.pages.PageObject;

public class MonsterImagesPage extends PageObject {

  public void selectMonster(String numberOfMonster) {
    $("//div[@data-testid='monster-{0}']", numberOfMonster).click();
  }
}
