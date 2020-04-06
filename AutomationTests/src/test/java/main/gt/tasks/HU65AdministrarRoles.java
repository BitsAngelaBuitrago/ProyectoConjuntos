package main.gt.tasks;

import core.Helpers.GeneralParams;
import core.actions.ClickButtonAction;
import core.actions.EnterTextAction;
import core.questions.QuestionValidate;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class HU65AdministrarRoles {
    Actor actor;
    @Managed
    WebDriver navegador;

    @Before
    public void abrirNavegador() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador));
    }

    @Then("^El sistema muestra la informacion de los roles existentes$")
    public void elSistemaLaInformacionDeLosRolesExistentes() {
        // Filtro de búsqueda
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
        //Etiqueta ‘Administración de roles’
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
        //Sección Tabla
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
        //Botón Crear Rol
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
        //Paginación
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));

    }

    @When("^Ingresa información en filtro de busqueda (.*)$")
    public void ingresaInformacionEnFiltroDeBusquedaBusqueda(String informacion) {
        actor.attemptsTo(new EnterTextAction(informacion).Execute(new GeneralParams(
                "Usuario ingresa texto en campo búsqueda",
                "Campo búsqueda",
                "//input[@id='password']"
        )));

    }


    @And("^Da clic en buscar$")
    public void daClicEnBuscar() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da clic en buscar",
                "Botón buscar",
                "//input[@id='password']"
        )));
    }

    @Then("^El sistema muestra los resultados (.*)$")
    public void elSistemaMuestraLosResultadosResultado(String resultado) {
        actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                "Verificación del resultado esperado",
                "Resultado esperado",
                "//input[@id='password']"
        )));

    }

    @When("^Selecciona una <opcion>$")
    public void seleccionaUnaOpcion(String opcion) {
        switch (opcion) {
            case "consultar":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da clic en consultar",
                        "Botón consultar",
                        "//input[@id='password']"
                )));
                break;
            case "modificar":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da clic en modificar",
                        "Botón modificar",
                        "//input[@id='password']"
                )));
                break;
            case "eliminar":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da clic en eliminar",
                        "Botón eliminar",
                        "//input[@id='password']"
                )));
                break;
            case "activar":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da clic en activar",
                        "Check activar",
                        "//input[@id='password']"
                )));
                break;
        }


    }

    @Then("^El sistema realiza una accion <accion>$")
    public void elSistemaRealizaUnaAccionAccion(String opcion, String accion) {
        switch (opcion) {
            case "consultar":
                actor.should(new QuestionValidate(accion).Execute(new GeneralParams(
                        "Página consultar",
                        "pagina consultar",
                        "//button[@name='action']"
                )));
                break;
            case "modificar":
                actor.should(new QuestionValidate(accion).Execute(new GeneralParams(
                        "Página modificar",
                        "pagina modificar",
                        "//button[@name='action']"
                )));
                break;
            case "eliminar":
                actor.should(new QuestionValidate(accion).Execute(new GeneralParams(
                        "Página eliminar",
                        "pagina eliminar",
                        "//button[@name='action']"
                )));
                break;
            case "activar":
                actor.should(new QuestionValidate(accion).Execute(new GeneralParams(
                        "presenta mensaje",
                        "rol activado",
                        "//button[@name='action']"
                )));
                break;
        }
    }


    @When("^Da clic en inactivar rol$")
    public void daClicEnActivarOInactivarRol() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "clic en inactivar",
                "rol inactivado",
                "//button[@name='action']"
        )));
    }

    @Then("^El sistema presenta un mensaje de inactivacion$")
    public void elSistemaPresentaUnMensajeInactivacion() {
        actor.should(new QuestionValidate("Esta seguro de inactivar este rol").Execute(new GeneralParams(
                "Validación del mensaje de activación",
                "rol inactivado",
                "//button[@name='action']"
        )));
    }

    @Then("^El sistema presenta un mensaje de activacion$")
    public void elSistemaPresentaUnMensajeDeActivacion() {
        actor.should(new QuestionValidate("Esta seguro de inactivar este rol").Execute(new GeneralParams(
                "Validación del mensaje de activación",
                "rol activado",
                "//button[@name='action']"
        )));

    }

    @When("^Da clic en activar rol$")
    public void daClicEnActivarRol() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "clic en Activar",
                "rol activado",
                "//button[@name='action']"
        )));
    }

    @And("^El usuario da clic en (.*) de inactivacion y se realiza una accion$")
    public void elUsuarioDaClicEnOpcion(String opcion) {
        if (opcion.equals("si")) {
            actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                    "clic en si inactivar",
                    "opción si",
                    "//button[@name='action']"
            )));
            actor.should(new QuestionValidate("El rol ha sido inactivado").Execute(new GeneralParams(
                    "mensaje rol inactivado",
                    "rol inactivado",
                    "//button[@name='action']"
            )));
        } else if (opcion.equals("no")) {
            actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                    "clic en no inactivar",
                    "opción no",
                    "//button[@name='action']"
            )));
            //Se cierra el pop up
            actor.should(seeThat(the("//button[@name='action']"), isNotVisible()));
        }

    }

    @Then("^El usuario da clic en (.*) de activacion y realiza una accion$")
    public void elUsuarioDaClicEnOpcionDeActivacionYRealizaUnaAccion(String opcion) {
        if (opcion.equals("si")) {
            actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                    "clic en si activar",
                    "opción si",
                    "//button[@name='action']"
            )));
            actor.should(new QuestionValidate("El rol ha sido activado").Execute(new GeneralParams(
                    "mensaje rol activado",
                    "rol activado",
                    "//button[@name='action']"
            )));
        } else if (opcion.equals("no")) {
            actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                    "clic en no activar",
                    "opción no",
                    "//button[@name='action']"
            )));
            //Se cierra el pop up
            actor.should(seeThat(the("//button[@name='action']"), isNotVisible()));
        }
    }

    @When("^Da clic sobre el icono de Eliminar rol de Admin$")
    public void daClicSobreElIconoDeEliminarRolDeAdmin() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "clic en Eliminar rol",
                "Eliminar rol",
                "//button[@name='action']"
        )));
    }

    @Then("^El sistema debe presentar el mensaje de confirmacion$")
    public void elSistemaDebePresentarElMensajeDeConfirmacion() {
        actor.should(new QuestionValidate("¿Esta seguro que desea eliminar el rol 'Nombre del rol'?").Execute(new GeneralParams(
                "validación mensaje de confirmación de eliminación",
                "Mensaje de confirmación de eliminación",
                "//p[contains(text(),'+57')] "
        )));
    }

    @And("^Selecciona una (.*) del pop up y genera una accion$")
    public void seleccionaUnaOpcionDelMensajeDeConfirmacion(String opcion) {
        if (opcion.equals("si")) {
            actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                    "clic en si eliminar",
                    "opción si eliminar",
                    "//button[@name='action']"
            )));
            actor.should(new QuestionValidate("El rol ha sido eliminado").Execute(new GeneralParams(
                    "mensaje rol eliminar",
                    "rol eliminar",
                    "//button[@name='action']"
            )));
        } else if (opcion.equals("no")) {
            actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                    "clic en no eliminar",
                    "opción no eliminar",
                    "//button[@name='action']"
            )));
            //Se cierra el pop up
            actor.should(seeThat(the("//button[@name='action']"), isNotVisible()));
        }
    }

    @When("^Da clic sobre el icono de Eliminar rol de Administrador$")
    public void daClicSobreElIconoDeEliminarRolDeAdministrador() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "clic en Eliminar rol",
                "Eliminar rol",
                "//button[@name='action']"
        )));
    }

    @Then("^Selecciona del rol administrador una (.*) del pop up y genera una accion$")
    public void seleccionaDelRolAdministradorUnaOpcionDelPopUpYGeneraUnaAccion(String opcion) {
        if (opcion.equals("si")) {
            actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                    "clic en si eliminar",
                    "opción si eliminar",
                    "//button[@name='action']"
            )));
            actor.should(new QuestionValidate("El rol ya se encuentra asignado a uno o varios usuarios").Execute(new GeneralParams(
                    "mensaje rol eliminar",
                    "rol eliminar",
                    "//button[@name='action']"
            )));
        } else if (opcion.equals("no")) {
            actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                    "clic en no eliminar",
                    "opción no eliminar",
                    "//button[@name='action']"
            )));
            //Se cierra el pop up
            actor.should(seeThat(the("//button[@name='action']"), isNotVisible()));
        }
    }


    @And("^Presenta un pop up de Eliminación$")
    public void presentaUnPopUpDeEliminacion() {
        actor.should(seeThat(the("//button[@name='action']"), isNotVisible()));
    }

    @And("^El sistema presenta mensaje de eliminación$")
    public void elSistemaPresentaMensajeDeEliminacion() {
        actor.should(new QuestionValidate("¿Está seguro de eliminar el rol?").Execute(new GeneralParams(
                "mensaje rol eliminar",
                "rol eliminar",
                "//button[@name='action']"
        )));
    }

    @And("^Las opciones de Si y no$")
    public void lasOpcionesDeSiYNo() {
        actor.should(seeThat(the("//button[@name='action']"), isVisible()));
        actor.should(seeThat(the("//button[@name='action']"), isVisible()));
    }

    @And("^Da clic sobre la (.*)$")
    public void daClicSobreLaOpcion(String opcion) {
        switch (opcion) {
            case "Si":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "clic en si eliminar",
                        "opción si eliminar",
                        "//button[@name='action']"
                )));
                break;
            case "No":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "clic en no eliminar",
                        "opción no eliminar",
                        "//button[@name='action']"
                )));
                break;
        }

    }

    @Then("^El sistema tiene el (.*)$")
    public void elSistemaTieneElResultado(String resultado) {
        switch (resultado) {
            case "Elimina el rol":
                actor.should(seeThat(the("//button[@name='action']"), isNotVisible()));
                break;
            case "Cierra el pop up":
                actor.should(seeThat(the("//b utton[@name='action']"), isNotVisible()));
                break;
        }

    }
}
