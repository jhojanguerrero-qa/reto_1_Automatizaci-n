package com.co.choucair.stepdefinitions;

import com.co.choucair.models.BuyProductLombokData;
import com.co.choucair.models.LoginLombokData;
import com.co.choucair.questions.ValidateProductCart;
import com.co.choucair.questions.ValidateShoppingCartIcon;
import com.co.choucair.task.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;

import static com.co.choucair.userinterfaces.BuyProductUI.SHOPPINGCARTICON;
import static com.co.choucair.userinterfaces.BuyProductUI.TXT_NAME_PRODUCT;
import static org.hamcrest.CoreMatchers.equalTo;

public class BuyProductsStepDefinitions {


    @Y("ha iniciado sesión exitosamente")
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


    @Cuando("^agrega el producto (.*) al carrito$")
    public void agregaElProductoAlCarrito(String producto) {
       OnStage.theActorInTheSpotlight().attemptsTo(
                BuyProduct.on(producto)
        );
    }


    @Y("el cliente accede al carrito de compras")
    public void elClienteAccedeAlCarritoDeCompras() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                GoToCart.now()
        );
    }

    @Entonces("^vera el producto (.*) agregado al carrito$")
    public void veraElProductoProductoAgregadoAlCarrito(String producto) {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(ValidateProductCart.on(TXT_NAME_PRODUCT), equalTo(producto))
        );
    }


    @Dado("^que el cliente ha agregado el producto (.*) al carrito$")
    public void queElClienteHaAgregadoUnProductoAlCarrito(String producto) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                BuyProduct.on(producto)
        );
    }

    @Cuando("accede al carrito de compras")
    public void accedeAlCarritoDeCompras() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                GoToCart.now()
        );
    }

    @Y("continua con el checkout")
    public void continuaConElCheckout() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                GoToFormInformation.now()
        );
    }

    @Y("ingresa la informacion solicitada para el pedido")
    public void ingresaLaInformacionSolicitadaParaElPedido(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
              CompleteFormInformation.on(BuyProductLombokData.convertToBuyProduct(dataTable).get(0))
        );
    }

    @Entonces("podra continuar con el resumen de la compra")
    public void podraContinuarConElResumenDeLaCompra() {

    }
}
