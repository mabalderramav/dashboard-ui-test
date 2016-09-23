package org.fundacionjala.dashboard.ui.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by AlvaroDaza on 9/21/2016.
 */
public class FavoritePage extends AbstractBasePage {

    @FindBy(css = "div.ui.needsclick.user.dropdown.item")
    private WebElement profileDropDownList;
    @FindBy(css = "div.menu.transition.visible>a[class=item][href=\"/profile\"]")
    private WebElement profileDropDownListOption;

    public void clickOnTheUsernameDropDownListButton() {
        profileDropDownList.click();
    }

   public void clickOnOptionProfile() {
       profileDropDownListOption.click();
   }
}
