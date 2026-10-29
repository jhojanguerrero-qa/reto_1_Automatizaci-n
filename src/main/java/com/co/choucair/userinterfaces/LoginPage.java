package com.co.choucair.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {

    public static final Target TXT_USERNAME = Target.the("Username field")
            .located(By.id("user-name"));
    public static final Target TXT_PASSWORD = Target.the("Password field")
            .located(By.id("password"));
    public static final Target BTN_LOGIN = Target.the("Login button")
            .located(By.id("login-button"));
    public static final Target TXT_TITLE = Target.the("Title page")
            .locatedBy("//span[@class='title']");

}
