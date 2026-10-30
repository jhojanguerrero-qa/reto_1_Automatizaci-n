package com.co.choucair.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BuyProductUI {
    public static final Target BTN_ADD_PROD = Target.the("Add Product button")
            .locatedBy("//div[text()='{0}']/ancestor::div[@class='inventory_item_description']//button");
    public static final Target SHOPPINGCARTICON = Target.the("Shopping cart Icon")
            .locatedBy("//span[@data-test='shopping-cart-badge']");
    public static final Target TXT_NAME_PRODUCT = Target.the("Name Product In Cart")
            .locatedBy("//div[@data-test='inventory-item-name']");
    public static final Target BTN_CHECKOUT = Target.the("Checkout continue button")
            //.located(By.id("continue"));
            .located(By.id("checkout"));

    public static final Target TXT_FIRST_NAME = Target.the("Username field")
            .located(By.id("first-name"));
    public static final Target TXT_LAST_NAME = Target.the("Password field")
            .located(By.id("last-name"));
    public static final Target TXT_ZIP = Target.the("Password field")
            .located(By.id("postal-code"));
    public static final Target BTN_CONTINUE = Target.the("Checkout continue button")
            //.located(By.id("continue"));
            .located(By.id("continue"));

}
