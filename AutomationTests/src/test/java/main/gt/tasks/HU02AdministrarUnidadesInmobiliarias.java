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

public class HU02AdministrarUnidadesInmobiliarias {
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

    @Then("^El sistema muestra la informacion de las Unidades Inmobiliarias$")
    public void elSistemaMuestraLaInformacionDeLasUnidadesInmobiliarias() {
        // Filtro de búsqueda
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
        //Etiqueta ‘Administración de Unidades Inmobiliarias’
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
        //Sección Tabla
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
        //Botón Crear Unidad
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
        //Paginación
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));

    }

    @When("^Selecciona una (.*)$")
    public void seleccionaUnaOpcion(String opcion) {
        if (opcion.equals("consultar")) {
            actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                    "Usuario da clic en consultar",
                    "Botón consultar",
                    "//input[@id='password']"
            )));
        } else if (opcion.equals("modificar")) {
            actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                    "Usuario da clic en modificar",
                    "Botón modificar",
                    "//input[@id='password']"
            )));
        } else if (opcion.equals("activar")) {
            actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                    "Usuario da clic en activar",
                    "Check Activar",
                    "//input[@id='password']"
            )));
        }
    }

    @Then("^El sistema realiza una accion (.*)$")
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
            case "activar":
                actor.should(new QuestionValidate(accion).Execute(new GeneralParams(
                        "Mensaje de activación",
                        "Activación",
                        "//button[@name='action']"
                )));
                break;
        }
    }

    @When("^Da clic en  Crear Unidad Inmobiliaria$")
    public void daClicEnCrearUnidadInmobiliaria() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da clic en crear",
                "Botón Crear",
                "//input[@id='password']"
        )));
    }

    @And("^El sistema redirecciona a la pagina de Crear Unidad Inmobiliaria$")
    public void elSistemaRedireccionaALaPaginaDeCrearUnidadInmobiliaria() {
        actor.should(new QuestionValidate("Crear Unidad").Execute(new GeneralParams(
                "Página Crear Unidad",
                "pagina crear Unidad",
                "//button[@name='action']"
        )));
    }
}
