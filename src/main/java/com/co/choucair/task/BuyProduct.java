package com.co.choucair.task;

import com.co.choucair.models.BuyProductLombokData;
import com.co.choucair.models.LoginLombokData;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static com.co.choucair.userinterfaces.BuyProduct.BTN_ADD_PROD;
import static com.co.choucair.userinterfaces.LoginPage.TXT_TITLE;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class BuyProduct implements Task {

    private String producto;

    public BuyProduct(String producto) {
        this.producto = producto;
    }



    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(TXT_TITLE, isVisible()).forNoMoreThan(20).seconds(),
                Click.on(BTN_ADD_PROD.of(producto))
        );
    }

    public static BuyProduct on(String producto) {
        return Instrumented.instanceOf(BuyProduct.class)
                .withProperties(producto);
    }
}
