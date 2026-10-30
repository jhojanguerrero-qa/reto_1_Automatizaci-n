package com.co.choucair.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class BuyProduct {
    public static final Target BTN_ADD_PROD = Target.the("Add Product button")
            .locatedBy("//div[text()='{0}']/ancestor::div[@class='inventory_item_description']//button");
    public static final Target SHOPPINGCARTICON = Target.the("Shopping cart Icon")
            .locatedBy("//span[@data-test='shopping-cart-badge']");
    public static final Target TXT_NAME_PRODUCT = Target.the("Name Product In Cart")
            .locatedBy("//div[@data-test='inventory-item-name']");
}
