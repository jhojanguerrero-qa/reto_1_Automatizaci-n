package com.co.choucair.stepdefinitions;

import com.co.choucair.models.LoginLombokData;
import com.co.choucair.models.TitleLomboData;
import com.co.choucair.questions.ValidateTitlePage;
import com.co.choucair.task.UserLogin;
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
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class UserLoginStepDefinitions {

    @Dado("que el cliente se ubica en la página de inicio de sesión")
    public void queElClienteSeUbicaEnLaPáginaDeInicioDeSesión() {
        OnStage.theActorCalled(CLIENT).wasAbleTo(
                Open.url(URL)
        );
    }

    @Cuando("el cliente ingresa sus credenciales válidas")
    public void elClienteIngresaSusCredencialesVálidas(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                UserLogin.on(LoginLombokData.convertToLoginData(dataTable).get(0))
        );
    }

    @Entonces("vera el titulo en pantalla.")
    public void veraElTituloEnPantalla(DataTable dataTable) {
        TitleLomboData data = TitleLomboData.convertToTitleData(dataTable).get(0);

        OnStage.theActorInTheSpotlight().should(
                seeThat(
                        ValidateTitlePage.on(TXT_TITLE),
                        equalTo(data.getTitulo())
                )
        );
    }
}
