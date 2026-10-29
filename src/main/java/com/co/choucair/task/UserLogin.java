package com.co.choucair.task;

import com.co.choucair.models.LoginLombokData;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static com.co.choucair.userinterfaces.LoginPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LoginOnSite  implements Task {

    protected LoginLombokData loginLombokData;
    public LoginOnSite(LoginLombokData loginLombokData) {
        this.loginLombokData = loginLombokData;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(TXT_USERNAME, isVisible()).forNoMoreThan(20).seconds(),
                Enter.theValue(loginLombokData.getUsuario()).into(TXT_USERNAME),
                Enter.theValue(loginLombokData.getContraseña()).into(TXT_PASSWORD),
                Click.on(BTN_LOGIN)
        );
    }

    public static LoginOnSite on(LoginLombokData loginLombokData) {
        return Instrumented.instanceOf(LoginOnSite.class).withProperties(loginLombokData);
    }
}
