package main.gt.tasks;

import core.Helpers.GeneralParams;
import core.actions.ClickButtonAction;
import core.actions.EnterTextAction;
import core.questions.QuestionValidate;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class HU36RecuperarContrasena {
    Actor actor;

    @When("Da clic en el enlace ¿Olvidaste tu contrasena?")
    public void clicOlvitasteContrasena(){
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en Olvidó contraseña",
                "Boton Olvidó contraseña",
                "//button[@name='action']"
        )));
    }
    @When("Da clic en el botón volver")
    public void clicBotonVolver(){
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en Volver",
                "Boton Volver",
                "//button[@name='action']"
        )));
    }
    @Then("El sistema presenta la página de autenticación de la aplicación")
    public void paginaAtenticacion(){
        actor.should(new QuestionValidate("Página principal").Execute(
                new GeneralParams(
                        "Usuario valida que regresa a la pagina principal",
                        "Pagina Principal",
                        "//p[contains(text(),'página principal')] "
                )
        ));
    }
    @And("Ingresa información de (.*) en el campo de usuario")
    public void ingresaUsuario(String usuario) {
        actor.attemptsTo(new EnterTextAction(usuario).Execute(
                new GeneralParams(
                        "Usuario ingresa texto en un campo usuario",
                        "Campo usuario",
                        "//input[@id='usuario']"
                )
        ));
    }
    @Then("El sistema presenta habilitado el botón Enviar")
    public void botonEnviarHabilitado(){

        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isEnabled()));
    }

    @And("Ingresa información de (.*) en el campo de usuario")
    public void ingresaUsuarios(String usuario) {
        actor.attemptsTo(new EnterTextAction(usuario).Execute(new GeneralParams(
                        "Usuario ingresa texto en un campo usuario",
                        "Campo usuario",
                        "//input[@id='usuario']"
                )
        ));
    }
    @When("Da clic en el boton Enviar")
    public void clicBotonEnviar(){
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en Enviar",
                "Boton Enviar",
                "//button[@name='action']"
        )));
    }
    @Then("El sistema presenta el mensaje (.*)")
    public void mensajeEnvio(){
        actor.should(new QuestionValidate("Debes tener un nuevo email en tu correo electronico admi...bits.com para que puedas restablecer la contrasena").Execute(
                new GeneralParams(
                        "Mensaje de éxito de envío de correo",
                        "Mensaje de éxito",
                        "//p[contains(text(),'nuevo email')] "
                )
        ));
    }
    @And("El sistema borra la información del campo usuario")
    public void campoUsuarioVacio(){
        actor.should(new QuestionValidate("").Execute(
                new GeneralParams(
                        "Campo usuario vacío",
                        "Campo vacío",
                        "//p[contains(text(),'')] "
                )
        ));
    }
    @And("El usuario visualiza el mensaje de exito")
    public void mensajeExito(){
        actor.should(new QuestionValidate("Debes tener un nuevo email en tu correo electronico admi...bits.com para que puedas restablecer la contrasena").Execute(
                new GeneralParams(
                        "Mensaje de éxito",
                        "Correo enviado",
                        "//p[contains(text(),'nuevo email')] "
                )
        ));
    }

    @Then("^Se muestra el mensaje de campo obligatorio$")
    public void seMuestraElMensajeDeCampoObligatorio() {
        actor.should(new QuestionValidate("Campo Obligatorio").Execute(
                new GeneralParams(
                        "Mensaje de éxito",
                        "Correo enviado",
                        "//p[contains(text(),'nuevo email')] "
                )
        ));
    }

    @And("^El sistema presenta inhabilitado el botón Enviar$")
    public void elSistemaPresentaInhabilitadoElBotonEnviar() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isNotEnabled()));
    }

    @When("^Da clic en usuario$")
    public void daClicEnUsuario() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en campo usuario",
                "campo usuario",
                "//button[@name='action']"
        )));
    }

    @Then("^Visualiza El sistema presenta la Ruta de navegacion$")
    public void visualizaElSistemaPresentaLaRutaDeNavegacion() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^Visualiza Label Recuperar contraseña$")
    public void visualizaLabelRecuperarContrasena() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^Visualiza Label Ingresa tu documento o correo$")
    public void visualizaLabelIngresaTuDocumentoOCorreo() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^Visualiza Campo tipo texto$")
    public void visualizaCampoTipoTexto() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^Visualiza Icono de ayuda$")
    public void visualizaIconoDeAyuda() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^Visualiza El boton Enviar$")
    public void visualizaElBotonEnviar() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^Visualiza Boton volver$")
    public void visualizaBotonVolver() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @When("^Da clic en icono de ayuda$")
    public void daClicEnIconoDeAyuda() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en icono de ayuda",
                "icono de ayuda",
                "//button[@name='action']"
        )));
    }

    @Then("^Se muestra un pop up con el mensaje de ayuda$")
    public void seMuestraUnPopUpConElMensajeDeAyuda() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
        actor.should(new QuestionValidate("Ingrese en el campo el tipo de documento con el número de documento (ej: CE123456) o el correo electrónico (ej: bitsamericas@bitsamericas.com) del usuario").Execute(new GeneralParams(
                        "Mensaje de ayuda",
                        "Icono de ayuda",
                        "//p[contains(text(),'nuevo email')] "
                )
        ));
    }
}
