package com.co.choucair.stepdefinitions;

import com.co.choucair.models.LoginLombokData;
import com.co.choucair.questions.ValidateShoppingCartIcon;
import com.co.choucair.task.BuyProduct;
import com.co.choucair.task.UserLogin;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;

import static com.co.choucair.userinterfaces.BuyProduct.SHOPPINGCARTICON;
import static org.hamcrest.CoreMatchers.equalTo;

public class BuyProductsStepDefinitions {


    @Y("ha iniciado sesión exitosamente.")
    public void haIniciadoSesiónExitosamente() {
        LoginLombokData loginData = new LoginLombokData();
        loginData.setUsuario("standard_user");
        loginData.setContraseña("secret_sauce");

        OnStage.theActorInTheSpotlight().attemptsTo(
                UserLogin.on(loginData)
        );
    }

    @Cuando("^el cliente agrega el producto (.*) al carrito$")
    public void elClienteAgregaElProductoAlCarrito(String producto) {

        OnStage.theActorInTheSpotlight().attemptsTo(
                BuyProduct.on(producto)
        );
    }

    @Entonces("vera una unidad en el icono del carrito")
    public void veraUnaUnidadEnElIconoDelCarrito() {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(ValidateShoppingCartIcon.on(SHOPPINGCARTICON), equalTo("1"))
        );
    }

    @Cuando("el cliente accede al carrito de compras")
    public void elClienteAccedeAlCarritoDeCompras() {

    }

    @Entonces("vera el producto agregado al carrito")
    public void veraElProductoAgregadoAlCarrito() {

    }

    @Cuando("el cliente ingrese los datos solicitados para el proceso de compras")
    public void elClienteIngreseLosDatosSolicitadosParaElProcesoDeCompras() {

    }

    @Entonces("podrá completar el flujo de compras")
    public void podráCompletarElFlujoDeCompras() {

    }


}
