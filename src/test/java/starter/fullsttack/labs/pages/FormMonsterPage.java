package starter.fullsttack.labs.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.pages.WebElementState;
import org.openqa.selenium.support.FindBy;

public class FormMonsterPage extends PageObject {

  @FindBy(name = "name")
  private WebElementFacade nameElement;

  @FindBy(name = "hp")
  private WebElementFacade hpElement;

  @FindBy(name = "attack")
  private WebElementFacade attackElement;

  @FindBy(name = "defense")
  private WebElementFacade defenseElement;

  @FindBy(name = "speed")
  private WebElementFacade speedElement;

  @FindBy(xpath = "//button[@data-testid='btn-create-monster']")
  private WebElementFacade btnSendMonsterInformation;


  public void putTheName(String name) {
    typeInto(nameElement, name);
  }

  public void putHP(String hp) {
    typeInto(hpElement, hp);
  }

  public void putAttack(String attack) {
    typeInto(attackElement, attack);
  }

  public void putDefense(String defense) {
    typeInto(defenseElement, defense);
  }

  public void putSpeed(String speed) {
    typeInto(speedElement, speed);
  }

  public void sendMonsterInformation(){
    btnSendMonsterInformation.click();
  }

  public WebElementState fieldErrorState(){
    return $("//*[@class='MuiAlert-message css-1pxa9xg-MuiAlert-message'][text()='All fields are required']");
  }
}
