package com.co.choucair.stepdefinitions;

import com.co.choucair.models.BuyProductLombokData;
import com.co.choucair.models.ShippingInformationLombokData;
import com.co.choucair.models.LoginLombokData;
import com.co.choucair.models.TitleLomboData;
import com.co.choucair.questions.ValidateProductCart;
import com.co.choucair.questions.ValidateShoppingCartIcon;
import com.co.choucair.questions.ValidateTitlePage;
import com.co.choucair.task.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.PendingException;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;

import static com.co.choucair.userinterfaces.BuyProductUI.SHOPPINGCARTICON;
import static com.co.choucair.userinterfaces.BuyProductUI.TXT_NAME_PRODUCT;
import static com.co.choucair.userinterfaces.LoginPage.TXT_TITLE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class BuyProductsStepDefinitions {


    @Y("ha iniciado sesión exitosamente")
    public void haIniciadoSesiónExitosamente(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                UserLogin.on(LoginLombokData.convertToLoginData(dataTable).get(0))
        );
    }

    @Cuando("el cliente agrega el producto al carrito")
    public void elClienteAgregaElProductoAlCarrito(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                BuyProduct.on(BuyProductLombokData.convertToBuyProduct(dataTable).get(0))
        );
    }

    @Entonces("vera una unidad en el icono del carrito")
    public void veraUnaUnidadEnElIconoDelCarrito() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ValidateShoppingCartIcon.on(SHOPPINGCARTICON), equalTo("1"))
        );
    }

    @Cuando("el cliente agrega productos al carrito")
    public void elClienteAgregaProductosAlCarrito(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                BuyProduct.on(BuyProductLombokData.convertToBuyProduct(dataTable).get(0))
        );
    }

    @Y("accede al carrito de compras")
    public void accedeAlCarritoDeCompras() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                GoToCart.now()
        );
    }

    @Entonces("vera el\\(los) producto\\(s) agregado\\(s) al carrito")
    public void veraElLosProductoSAgregadoSAlCarrito(DataTable dataTable) {
        BuyProductLombokData data = BuyProductLombokData.convertToBuyProduct(dataTable).get(0);

        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(
                        ValidateProductCart.on(TXT_NAME_PRODUCT),
                        equalTo(data.getProducto())
                )
        );
    }

    @Dado("que el cliente ha agregado el\\(los) producto\\(s) al carrito")
    public void queElClienteHaAgregadoElLosProductoSAlCarrito(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                BuyProduct.on(BuyProductLombokData.convertToBuyProduct(dataTable).get(0))
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
              CompleteFormInformation.on(ShippingInformationLombokData.convertToBuyProduct(dataTable).get(0))
        );
    }

    @Entonces("podra continuar a la pagina titulada  de detalle del pedido")
    public void podraContinuarALaPaginaTituladaDeDetalleDelPedido() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Entonces("podra continuar con la pagina titulada de detalle del pedido")
    public void podraContinuarConLaPaginaTituladaDeDetalleDelPedido(DataTable dataTable) {
        TitleLomboData data = TitleLomboData.convertToTitleData(dataTable).get(0);

        OnStage.theActorInTheSpotlight().should(
                seeThat(
                        ValidateTitlePage.on(TXT_TITLE),
                        equalTo(data.getTitulo())
                )
        );
    }
}
