package com.co.choucair.stepdefinitions;

import com.co.choucair.models.LoginLombokData;
import com.co.choucair.questions.CurrentPageUrl;
import com.co.choucair.task.LoginOnSite;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.PendingException;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;

import static com.co.choucair.userinterfaces.LoginPage.TXT_TITLE;
import static com.co.choucair.utils.Constants.CLIENT;
import static com.co.choucair.utils.Constants.URL;
import static org.hamcrest.CoreMatchers.equalTo;

public class LoginOnSiteStepDefinitions {

    @Dado("que el cliente se ubica en la página de inicio de sesión")
    public void queElClienteSeUbicaEnLaPáginaDeInicioDeSesión() {
        OnStage.theActorCalled(CLIENT).wasAbleTo(
                Open.url(URL)
        );
    }

    @Cuando("el cliente ingresa sus credenciales válidas")
    public void elClienteIngresaSusCredencialesVálidas(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                LoginOnSite.on(LoginLombokData.convertToLoginData(dataTable).get(0))
        );
    }

    @Entonces("^vera el titulo (.*) en pantalla.$")
    public void veraElTituloTituloEnPantalla(String title) {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(CurrentPageUrl.on(TXT_TITLE), equalTo(title))
        );
    }

}
