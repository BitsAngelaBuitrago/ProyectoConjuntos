package main.gt.tasks;

import core.actions.OpenUrlAction;
import core.Helpers.GeneralParams;
import core.actions.ClickButtonAction;
import core.actions.EnterTextAction;
import core.questions.QuestionValidate;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class HU38CrearRolYPermisos {
    Actor actor;

    @Managed
    WebDriver navegador;

    @Given("^Que usuario ingresa a la pagina de inicio$")
    public void ingresarAUrl() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador)); //Abrir navegador
        actor.has(new OpenUrlAction().Execute(new GeneralParams(
                "http://selfcarecvgt-stg-gt.tigocloud.net/")));

    }

    @And("^Inicia sesión$")
    public void iniciarSesion() {
        actor.attemptsTo(new EnterTextAction("jbarbosam").Execute(new GeneralParams(
                "Usuario ingresa texto en el campo usuario",
                "Campo usuario",
                "//input[@id='idEmail']"
        )));

        actor.attemptsTo(new EnterTextAction("TigoTest123#").Execute(
                new GeneralParams(
                        "Usuario ingresa texto en un campo clave",
                        "Campo clave",
                        "//input[@id='password']"
                )
        ));

    }

    @And("^Da clic en Configuracion$")
    public void daClicEnConfiguracion() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Da clic en el menú de configuración",
                "menú configuración",
                "/button[@name='action']"
        )));
    }

    @And("^Da clic en Roles$")
    public void daClicEnRoles() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Da clic en Roles",
                "clic en Roles",
                "/button[@name='action']"
        )));
    }

    @And("^Da clic en el boton Crear Rol$")
    public void daClicEnElBotonCrearRol() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Da clic en Crear Rol",
                "clic en Crear Rol",
                "/button[@name='action']"
        )));
    }

    @Then("^El sistema presenta una ventana con la informacion de crear rol$")
    public void elSistemaPresentaUnaVentanaConLaInformacionDeCrearRol() {
        // Etiqueta Crear Rol
        actor.should(seeThat(the("/button[@name='action']"),isVisible()));
        //Campo Nombre Rol
        actor.should(seeThat(the("/button[@name='action']"),isVisible()));
        //Sección Permisos
        actor.should(seeThat(the("/button[@name='action']"),isVisible()));
        //Botón Guardar
        actor.should(seeThat(the("/button[@name='action']"),isVisible()));
        //Botón Cancelar
        actor.should(seeThat(the("/button[@name='action']"),isVisible()));
    }

    @When("^Ingresa información en el campo nombre de rol$")
    public void ingresaInformacionEnElCampoNombreDeRol() {
        actor.attemptsTo(new EnterTextAction("Admin2").Execute(new GeneralParams(
                "Ingresa información en campo nombre de rol",
                "Campo nombre de rol",
                "/button[@name='action']"
        )));
    }

    @Then("^El sistema presenta habilitado el boton de guardar$")
    public void elSistemaPresentaHabilitadoElBotonDeGuardar() {
        actor.should(seeThat(the("/button[@name='action']"),isEnabled()));
    }

    @When("^Ingresa un (.*) en el campo nombre de rol$")
    public void ingresaUnNombreEnElCampoNombreDeRol(String nombre) {
        actor.attemptsTo(new EnterTextAction(nombre).Execute(new GeneralParams(
                "Ingresa información en campo nombre de rol",
                "Campo nombre de rol",
                "/button[@name='action']"
        )));
    }

    @Then("^Se muestra el resultado esperado (.*)$")
    public void seMuestraElResultadoEsperadoResultado(String resultado) {
        actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                "Resultado Nombre rol",
                "Campo Nombre rol",
                "//input[@id='idEmail']"
        )));
    }

    @Then("^El sistema presente el mensaje <mensaje>$")
    public void elSistemaPresenteElMensajeMensaje(String mensaje) {
        actor.should(new QuestionValidate(mensaje).Execute(new GeneralParams(
                "Mensaje de resultado de creación",
                "Mensaje",
                "//input[@id='idEmail']"
        )));
    }

    @When("^Se da clic en Configuracion$")
    public void seDaClicEnConfiguracion() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Da clic en Configuración",
                "Clic configuración",
                "//input[@id='idEmail']"
        )));
    }

    @And("^Se da clic en Unidades Inmobiliarias$")
    public void seDaClicEnUnidadesInmobiliarias() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Da clic en Unidades Inmobiliarias",
                "Clic Unidades Inmobiliarias",
                "//input[@id='idEmail']"
        )));
    }

    @And("^Se da clic en Crear$")
    public void seDaClicEnCrear() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Da clic en Crear",
                "Clic crear",
                "//input[@id='idEmail']"
        )));
    }

    @Then("^Se visualizan seleccionados cada check$")
    public void seVisualizanSeleccionadosCadaCheck() {
        //Check en Configuración
        actor.should(seeThat(the("/button[@name='action']"),isSelected()));
        //Check en Unidades Inmobiliarias
        actor.should(seeThat(the("/button[@name='action']"),isSelected()));
        //Check en Crear
        actor.should(seeThat(the("/button[@name='action']"),isSelected()));
    }
}
