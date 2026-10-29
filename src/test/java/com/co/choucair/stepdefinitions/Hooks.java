package com.co.choucair.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.webdriver.SerenityWebdriverManager;

public class Hooks {

    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @After
    public void tearDown(){
        SerenityWebdriverManager.inThisTestThread().closeCurrentDriver();
        SerenityWebdriverManager.inThisTestThread().clearCurrentActiveDriver();
    }

}
