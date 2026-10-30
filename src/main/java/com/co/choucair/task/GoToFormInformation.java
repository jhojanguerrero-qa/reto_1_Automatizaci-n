package com.co.choucair.task;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.co.choucair.userinterfaces.BuyProductUI.BTN_CHECKOUT;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class GoToFormInformation implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_CHECKOUT, isVisible())
                        .forNoMoreThan(30).seconds(),
                Click.on(BTN_CHECKOUT)
        );
    }

    public static GoToFormInformation now() {
        return Instrumented.instanceOf(GoToFormInformation.class)
                .withProperties();
    }
}
