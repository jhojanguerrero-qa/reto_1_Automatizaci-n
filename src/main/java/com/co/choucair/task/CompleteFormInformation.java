package com.co.choucair.task;

import com.co.choucair.models.BuyProductLombokData;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.co.choucair.userinterfaces.BuyProductUI.*;


public class CompleteFormInformation implements Task {

    protected BuyProductLombokData buyProducLombokData;

    public CompleteFormInformation(BuyProductLombokData buyProducLombokData) {
        this.buyProducLombokData = buyProducLombokData;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(buyProducLombokData.getPrimerNombre()).into(TXT_FIRST_NAME),
                Enter.theValue(buyProducLombokData.getApellido()).into(TXT_LAST_NAME),
                Enter.theValue(buyProducLombokData.getCodigoPostal()).into(TXT_ZIP),
                Click.on(BTN_CONTINUE)
        );
    }

    public static CompleteFormInformation on(BuyProductLombokData buyProducLombokData) {
        return Instrumented.instanceOf(CompleteFormInformation.class).withProperties(buyProducLombokData);
    }

}
