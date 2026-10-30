package com.co.choucair.task;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.co.choucair.userinterfaces.BuyProduct.SHOPPINGCARTICON;

public class GoToCart implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SHOPPINGCARTICON)
        );

    }

    public static GoToCart now() {
        return new GoToCart();
    }

}
