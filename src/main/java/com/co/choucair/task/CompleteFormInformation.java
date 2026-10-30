package com.co.choucair.task;

import com.co.choucair.models.ShippingInformationLombokData;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.co.choucair.userinterfaces.BuyProductUI.*;


public class CompleteFormInformation implements Task {

    protected ShippingInformationLombokData shippingInformationLombokData;

    public CompleteFormInformation(ShippingInformationLombokData shippingInformationLombokData) {
        this.shippingInformationLombokData = shippingInformationLombokData;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(shippingInformationLombokData.getPrimerNombre()).into(TXT_FIRST_NAME),
                Enter.theValue(shippingInformationLombokData.getApellido()).into(TXT_LAST_NAME),
                Enter.theValue(shippingInformationLombokData.getCodigoPostal()).into(TXT_ZIP),
                Click.on(BTN_CONTINUE)
        );
    }

    public static CompleteFormInformation on(ShippingInformationLombokData shippingInformationLombokData) {
        return Instrumented.instanceOf(CompleteFormInformation.class).withProperties(shippingInformationLombokData);
    }

}
