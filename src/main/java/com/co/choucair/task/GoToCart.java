package com.co.choucair.task;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.co.choucair.userinterfaces.BuyProductUI.SHOPPINGCARTICON;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class GoToCart implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SHOPPINGCARTICON, isVisible())
                        .forNoMoreThan(30).seconds(),
                Click.on(SHOPPINGCARTICON)
        );

    }

    public static GoToCart now() {
        return Instrumented.instanceOf(GoToCart.class)
                .withProperties();
    }
}
