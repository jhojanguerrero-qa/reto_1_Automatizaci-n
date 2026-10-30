package com.co.choucair.task;

import com.co.choucair.models.ShippingInformationLombokData;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.co.choucair.userinterfaces.BuyProductUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class CompleteFormInformation implements Task {

    private final ShippingInformationLombokData shippingInformationLombokData;

    public CompleteFormInformation(ShippingInformationLombokData shippingInformationLombokData) {
        this.shippingInformationLombokData = shippingInformationLombokData;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(TXT_FIRST_NAME, isVisible()).forNoMoreThan(30).seconds(),
                Enter.theValue(shippingInformationLombokData.getPrimerNombre()).into(TXT_FIRST_NAME),
                Enter.theValue(shippingInformationLombokData.getApellido()).into(TXT_LAST_NAME),
                Enter.theValue(shippingInformationLombokData.getCodigoPostal()).into(TXT_ZIP),
                Click.on(BTN_CONTINUE)
        );
    }

    public static CompleteFormInformation withInformation(ShippingInformationLombokData shippingInformationLombokData) {
        return Instrumented.instanceOf(CompleteFormInformation.class).withProperties(shippingInformationLombokData);
    }

}
