package com.co.choucair.task;

import com.co.choucair.models.BuyProductLombokData;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.co.choucair.userinterfaces.BuyProductUI.BTN_ADD_PROD;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class BuyProduct implements Task {

    private final BuyProductLombokData buyProductLombokData;

    public BuyProduct(BuyProductLombokData buyProductLombokData) {
        this.buyProductLombokData = buyProductLombokData;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(
                        BTN_ADD_PROD.of(
                                buyProductLombokData.getProducto()
                        ),
                        isVisible()
                ).forNoMoreThan(30).seconds(),

                Click.on(
                        BTN_ADD_PROD.of(
                                buyProductLombokData.getProducto()
                        )
                )
        );
    }

    public static BuyProduct on(BuyProductLombokData buyProductLombokData) {
        return Instrumented.instanceOf(BuyProduct.class)
                .withProperties(buyProductLombokData);
    }
}

