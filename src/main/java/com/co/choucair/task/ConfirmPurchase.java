package com.co.choucair.task;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.co.choucair.userinterfaces.BuyProductUI.BTN_FINISH;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class FinishBuyProduct implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_FINISH, isVisible())
                        .forNoMoreThan(30).seconds(),
                Click.on(BTN_FINISH)
        );
    }

    public static FinishBuyProduct now() {
        return Instrumented.instanceOf(FinishBuyProduct.class).withProperties();
    }
}
