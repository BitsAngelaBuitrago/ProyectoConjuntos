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

public class HU48HeaderCambiarDatos {
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

        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en continuar",
                "Boton continuar",
                "//button[@name='action']"
        )));
    }

    @Given("^Un usuario da clic sobre la foto de perfil $")
    public void unUsuarioDaClicSobreLaFotoDePerfil() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en foto de perfil",
                "Foto de perfil",
                "//button[@name='action']"
        )));
    }

    @When("^Da clic en la opción Cambiar datos$")
    public void daClicEnLaOpcionCambiarDatos() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en cambiar datos",
                "Boton cambiar datos",
                "//button[@name='action']"
        )));
    }

    @And("^Presenta el campo nombre habilitado y nombre de usuario$")
    public void presentaElCampoNombreHabilitadoYNombreDeUsuario() {
        actor.should(seeThat(the("//button[@name='action']"), isEnabled()));
    }

    @And("^Presenta el campo apellido habilitado y apellido de usuario$")
    public void presentaElCampoApellidoHabilitadoYApellidoDeUsuario() {
        actor.should(seeThat(the("//button[@name='action']"), isEnabled()));
    }

    @And("^Presenta el campo correo electrónico habilitado$")
    public void presentaElCampoCorreoElectronicoHabilitado() {
        actor.should(seeThat(the("//button[@name='action']"), isEnabled()));
    }

    @And("^Presenta el campo teléfono habilitado$")
    public void presentaElCampoTelefonoHabilitado() {
        actor.should(seeThat(the("//button[@name='action']"), isEnabled()));
    }

    @And("^Presenta el botón Guardar habilitado$")
    public void presentaElBotonGuardarHabilitado() {
        actor.should(seeThat(the("//button[@name='action']"), isEnabled()));
    }

    @And("^Opción de cerrar ventana emergente$")
    public void opcionDeCerrarVentanaEmergente() {
        actor.should(seeThat(the("//button[@name='action']"), isVisible()));
    }

    @And("^Presenta el botón Cambiar habilitado$")
    public void presentaElBotonCambiarHabilitado() {
        actor.should(seeThat(the("//button[@name='action']"), isEnabled()));
    }

    @When("^Da clic sobre la opción de cerrar la ventana emergente$")
    public void daClicSobreLaOpcionDeCerrarLaVentanaEmergente() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en cerrar",
                "Cerrar ventana",
                "//button[@name='action']"
        )));
    }

    @And("^Deja al usuario en la página que se encuentra actualmente$")
    public void dejaAlUsuarioEnLaPaginaQueSeEncuentraActualmente() {
        actor.should(seeThat(the("//button[@name='action']"), isVisible()));
    }

    @When("^Ingresa en el campo de (.*) y borra la informacion$")
    public void ingresaEnElCampoDeCampoYBorraLaInformacion(String campo) {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "click en el campo",
                "contrasenaActual",
                "//button[@name='action']"
        )));
        switch (campo){
            case "nombre":
                actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                        "Borrar nombre",
                        "Borrar nombre",
                        "//button[@name='action']"
                )));
                break;
            case "apellido":
                actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                        "Borrar apellido",
                        "Borrar apellido",
                        "//button[@name='action']"
                )));
                break;
            case "correo":
                actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                        "Borrar correo",
                        "Borrar correo",
                        "//button[@name='action']"
                )));
                break;
            case "telefono":
                actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                        "Borrar telefono",
                        "Borrar telefono",
                        "//button[@name='action']"
                )));
                break;
        }

    }

    @Then("^El boton de guardar se visualiza inhabilitado$")
    public void elBotonDeGuardarSeVisualizaInhabilitado() {
        actor.should(seeThat(the("//button[@name='action']"), isNotEnabled()));
    }

    @And("^Se presenta el mensaje de obligatoriedad$")
    public void sePresentaElMensaje() {
        actor.should(new QuestionValidate("Campo Obligatorio").Execute(new GeneralParams(
                "Mensaje de Obligatoriedad",
                "Campo Obligatorio",
                "//p[contains(text(),'correo')] "
        )));
    }

    @When("^Ingresa correctamente toda la informacion de los campos$")
    public void ingresaCorrectamenteTodaLaInformacionDeLosCampos() {
        //Ingresa nombre
        actor.attemptsTo(new EnterTextAction("Pepito").Execute(new GeneralParams(
                "Ingresar nombre",
                "nombre",
                "//button[@name='action']"
        )));
        //Ingresa apellido
        actor.attemptsTo(new EnterTextAction("Perez").Execute(new GeneralParams(
                "Ingresar apellido",
                "apellido",
                "//button[@name='action']"
        )));
        //Ingresa correo
        actor.attemptsTo(new EnterTextAction("pepitoperez@hotmail.com").Execute(new GeneralParams(
                "Ingresar correo",
                "correo",
                "//button[@name='action']"
        )));
        //Ingresa telefono
        actor.attemptsTo(new EnterTextAction("7777777").Execute(new GeneralParams(
                "Ingresar telefono",
                "telefono",
                "//button[@name='action']"
        )));
    }

    @Then("^El boton de guardar se visualiza habilitado$")
    public void elBotonDeGuardarSeVisualizaHabilitado() {
        actor.should(seeThat(the("//button[@name='action']"), isEnabled()));
    }

    @And("^Da clic en el boton Guardar$")
    public void daClicEnElBotonGuardar() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "click en guardad",
                "Botón guardar",
                "//button[@name='action']"
        )));
    }

    @Then("^Se verifica que el cambio se aplico$")
    public void seVerificaQueElCambioSeAplico() {
        actor.should(new QuestionValidate("Pepito").Execute(new GeneralParams(
                "Cambio exitoso de nombre",
                "Cambio de nombre",
                "//p[contains(text(),'correo')] "
        )));
        actor.should(new QuestionValidate("Perez").Execute(new GeneralParams(
                "Cambio exitoso de apellido",
                "Cambio de apellido",
                "//p[contains(text(),'correo')] "
        )));
        actor.should(new QuestionValidate("pepitoperez@hotmail.com").Execute(new GeneralParams(
                "Cambio exitoso de correo",
                "Cambio de correo",
                "//p[contains(text(),'correo')] "
        )));
        actor.should(new QuestionValidate("7777777").Execute(new GeneralParams(
                "Cambio exitoso de telefono",
                "Cambio de telefono",
                "//p[contains(text(),'correo')] "
        )));
    }

    @When("^Ingresa en el cada campo informacion incorrecta$")
    public void IngresaEnElCampoLaInformacion() {
        actor.attemptsTo(new EnterTextAction("Pepito123").Execute(new GeneralParams(
                "Ingresar nombre",
                "nombre",
                "//button[@name='action']"
        )));
        //Ingresa apellido
        actor.attemptsTo(new EnterTextAction("Perez123").Execute(new GeneralParams(
                "Ingresar apellido",
                "apellido",
                "//button[@name='action']"
        )));
        //Ingresa correo
        actor.attemptsTo(new EnterTextAction("$%&/pepitoperez@hotmail.com").Execute(new GeneralParams(
                "Ingresar correo",
                "correo",
                "//button[@name='action']"
        )));
        //Ingresa telefono
        actor.attemptsTo(new EnterTextAction("7777777skdjfdlskjdskl").Execute(new GeneralParams(
                "Ingresar telefono",
                "telefono",
                "//button[@name='action']"
        )));
    }

    @And("^muestra el resultado$")
    public void muestraElResultado() {
        actor.should(new QuestionValidate("Pepito").Execute(new GeneralParams(
                "Cambio exitoso de nombre",
                "Cambio de nombre",
                "//p[contains(text(),'correo')] "
        )));
        actor.should(new QuestionValidate("Perez").Execute(new GeneralParams(
                "Cambio exitoso de apellido",
                "Cambio de apellido",
                "//p[contains(text(),'correo')] "
        )));
        actor.should(new QuestionValidate("pepitoperez@hotmail.com").Execute(new GeneralParams(
                "Cambio exitoso de correo",
                "Cambio de correo",
                "//p[contains(text(),'correo')] "
        )));
        actor.should(new QuestionValidate("7777777").Execute(new GeneralParams(
                "Cambio exitoso de telefono",
                "Cambio de telefono",
                "//p[contains(text(),'correo')] "
        )));
    }

    @And("^Da clic sobre el campo teléfono$")
    public void daClicSobreElCampoTelefono() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Clic en campo teléfono",
                "campo teléfono",
                "//button[@name='action']"
        )));
    }

    @And("^Da clic sobre el campo pais$")
    public void daClicSobreElCampoPais() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Clic en campo país",
                "campo país",
                "//button[@name='action']"
        )));
    }

    @When("^Selecciona el pais Colombia$")
    public void seleccionaElPaisColombia() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "selecciona país",
                "selección país",
                "//button[@name='action']"
        )));
    }

    @Then("^Se presenta el prefijo de Colombia$")
    public void sePresentaElPrefijo() {
        actor.should(new QuestionValidate("+57").Execute(new GeneralParams(
                "Prefijo",
                "prefijo",
                "//p[contains(text(),'+57')] "
        )));
    }

    @When("^Ingresa un (.*) de telefono$")
    public void ingresaUnNumeroDeTelefono(String numeroTelefono) {
        actor.attemptsTo(new EnterTextAction(numeroTelefono).Execute(new GeneralParams(
                "Ingresar telefono",
                "telefono",
                "//button[@name='action']"
        )));
    }

    @Then("^El sistema muestra la (.*) y Presenta el (.*) al poner el cursor encima$")
    public void elSistemaMuestraLaValidacion(String validacion, String mensaje) {
        if (validacion.equals("correcto")){
            actor.should(seeThat(the("//button[@name='action']"), isVisible()));
            actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                    "clic en icono correcto",
                    "//button[@name='action']"
            )));
            actor.should(new QuestionValidate(mensaje).Execute(new GeneralParams(
                    "mensaje icono correcto",
                    "//button[@name='action']"
            )));
        } else if (validacion.equals("incorrecto")){
            actor.should(seeThat(the("//button[@name='action']"), isVisible()));
            actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                    "clic en icono incorrecto",
                    "//button[@name='action']"
            )));
            actor.should(new QuestionValidate(mensaje).Execute(new GeneralParams(
                    "mensaje icono incorrecto",
                    "//button[@name='action']"
            )));
        }
    }

    @And("^Ingresa un (.*)$")
    public void ingresaUnCorreo(String correo) {
        actor.attemptsTo(new EnterTextAction(correo).Execute(new GeneralParams(
                "Ingresar correo",
                "correo",
                "//button[@name='action']"
        )));
    }

    @When("^Coloca el cursor sobre el icono$")
    public void colocaElCursorSobreElIcono() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "clic en icono",
                "//button[@name='action']"
        )));
    }

    @Then("^El sistema presenta un (.*)$")
    public void elSistemaPresentaUnMensaje(String mensaje) {
        actor.should(new QuestionValidate(mensaje).Execute(new GeneralParams(
                "mensaje icono validado",
                "mensaje presentado",
                "//button[@name='action']"
        )));
    }
}
