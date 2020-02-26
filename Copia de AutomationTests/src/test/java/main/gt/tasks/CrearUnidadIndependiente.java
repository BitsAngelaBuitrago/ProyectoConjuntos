package main.gt.tasks;

import core.Helpers.GeneralParams;
import core.actions.ClickButtonAction;
import core.actions.EnterTextAction;
import core.questions.QuestionValidate;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.EnterValueIntoElement;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class CrearUnidadIndependiente {

    Actor actor;
    @Managed
    WebDriver navegador;

    @Before
    public void ingresar() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador)); //Abrir navegador
    }

    //Escenario 1


    @Given("^Un usuario en la página de Administrar Unidad Independiente$")
    public void NuevaPaginau() {
        actor.should(new QuestionValidate(
                "El usuario se encuentra en la pagina administracion").Execute(new GeneralParams(
                "Pagina administracion",
                "Elemento")));

    }

    @When("^Selecciiona el boton de Crear$")
    public void BotondeCrear() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clilc en el boton crear",
                "clic en boton crear",
                "Eleemento")));
    }

    @Then("^El siistemaa presenta un formulario para Crear Unidad Independiente$")
    public void presentaformulario() {
        actor.should(new QuestionValidate(
                "El sistema presenta formulario").Execute(new GeneralParams(
                "formulario crear",
                "Elemento")));

    }

    @And("^El botón de guardar bloqueado$")
    public void botonbloqueadoo() {
        actor.should(new QuestionValidate(
                "El sistema presenta el boton guardar bloqueado").Execute(new GeneralParams(
                "boton guardar bloqueado",
                "Elemento")));
    }
    //Escenario 2

    @Given("^Un usuario en la página de Crear Unidad Independiente$")
    public void CrearUnidadIndependdiente() {
        actor.should(new QuestionValidate(
                "El usuario se encuentra enla pantalla de unidad independiente").Execute(new GeneralParams(
                "Pagina administracion",
                "Elemento")));
    }

    @When("^Selecciona una de las (.*) para salir de formulario de crear Unidad Independiente$")
    public void CrearUnidadIndeo() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clic en alguna opcion para salir del formulario",
                "clic en otra opcion diferente para salir",
                "Elemento")));
    }

    @Then("^El siiistema presenta un (.*) junto con los botones Sii y No$")
    public void SiiyNoo() {
        actor.should(new QuestionValidate(
                "El sistema presenta un formulario").Execute(new GeneralParams(
                "Presenta formualrio",
                "Elemento")));
    }

    @And("^La (.*) de cerrar mensajee$")
    public void Cccrearmensaje() {
        actor.attemptsTo((new EnterTextAction("").Execute(new GeneralParams(
                "El usuario usuario da clic en el boton cerar mensaje",
                "Elemento"))));

    }

    //Escenario 3


    @And("^Seleccciona una de las (.*) para salir del formulario$")
    public void UsuarioSaleDelFomulario() {
        actor.attemptsTo((new EnterTextAction("").Execute(new GeneralParams(
                "El usuario vsualizara el boton guardar bloqueado",
                "Elemento"))));

    }

    @When("^Selecciiona una de las (.*) para cerrar el mensaje$")
    public void Cerrarmensajee() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clilc en el boton crear",
                "clic en boton crear",
                "Eleemento")));
    }

    @Then("^El sistema debe realizar unas (.*) dependiendo de la opción seleccionada$")
    public void SistemaRealizaVali() {
        actor.should(new QuestionValidate(
                "El sistema hace unas validaciones").Execute(new GeneralParams(
                "Validaciones",
                "Elemento")));
    }


//Escenario 4


    @And("^Da cliic por fuera del campo$")
    public void Cliccfueradelcampo() {
        actor.attemptsTo((new EnterTextAction("").Execute(new GeneralParams(
                "El usuario vsualizara el boton guardar bloqueado",
                "Elemento"))));

    }

    @When("^Da cliic en el (.*)$")
    public void Cliclenel() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clilc en el boton crear",
                "clic en boton crear",
                "Eleemento")));
    }

    @Then("^El sistema presenta un (.*) indicando que el campo es requeriido$")
    public void Presentaunmensaje() {
        actor.should(new QuestionValidate(
                "El sistema hace unas validaciones").Execute(new GeneralParams(
                "Validaciones",
                "Elemento")));
    }

//Escenario 5

    @When("^Realiiiza una (.*) sobre los campos$")
    public void Clicsobreloscampos() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clilc en el boton crear",
                "clic en boton crear",
                "Eleemento")));
    }

    @Then("^El siistema presenta si o no (.*) el botón de guardar$")
    public void botondeguaradr() {
        actor.should(new QuestionValidate(
                "El sistema presenta un mensaje de si y no").Execute(new GeneralParams(
                "Validaciones",
                "Elemento")));
    }

    //Escenario 6


    @And("^Da cliiic en el (.*)$")
    public void CliceenelCampo() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario vsualizara el boton guardar bloqueado",
                "Elemento")));

    }

    @When("^Ingresa un (.*) de (.*) con unas (.*) definiidas para el (.*)$")
    public void ValidacionesDefinidas() {
        actor.attemptsTo((new EnterTextAction("").Execute(new GeneralParams(
                "El usuario ingresa un tipo de valor",
                "ingresa valor",
                "Eleemento"))));
    }

    @Then("^El sistema realiza síi o no unas (.*)$")
    public void Elsistemavalida() {
        actor.should(new QuestionValidate(
                "El sistema realiza validaciones").Execute(new GeneralParams(
                "Validaciones",
                "Elemento")));
    }

//Escenario 7

    @And("^Da clic en el campo Nombre Unidad Independienteee$")
    public void CampoCrear() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clilc en el campo unidad independiente",
                "Elemento")));

    }

    @When("^Ingreeesa un (.*) de (.*) con unas (.*) definidas para el (.*)$")
    public void IngresaUnValor() {
        actor.attemptsTo((new EnterTextAction("").Execute(new GeneralParams(
                "El usuario ingresa un valor en el campo",
                "ingresa valor",
                "Eleemento"))));
    }

    @Then("^El sistema realizaa unas (.*)$")
    public void Validate() {
        actor.should(new QuestionValidate(
                "El sistema realiza acciones").Execute(new GeneralParams(
                "Validaciones",
                "Elemento")));
    }


//Escenario 8


    @When("^Realiza una (.*) sobre uno de los (.*)$")
    public void RealizaAccionSobreCampos() {
        actor.attemptsTo((new EnterTextAction("").Execute(new GeneralParams(
                "El usuario ingresa un valor en el campo",
                "ingresa valor",
                "Eleemento"))));
    }

    @Then("^El sistema presenta sii o no (.*) el botón de guardar$")
    public void PresentaCampoHabilitado() {
        actor.should(new QuestionValidate(
                "El sistema realiza acciones").Execute(new GeneralParams(
                "Validaciones",
                "Elemento")));
    }

//Escenario 9


    @And("^Ingresa la informaciion en cada uno de los campos requeridos de forma correcta$")
    public void CamposRequeridos() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clilc en el campo unidad independiente",
                "Elemento")));
    }

    @When("^Da cliic en el boton Guardarr$")
    public void BotonGuardar() {
        actor.attemptsTo((new EnterTextAction("").Execute(new GeneralParams(
                "El usuario ingresa un valor en el campo",
                "ingresa valor",
                "Eleemento"))));
    }

    @Then("^El sistema realiiza unas (.*) en los (.*) enviados$")
    public void SistemaValidaCampo() {
        actor.should(new QuestionValidate(
                "El sistema realiza acciones").Execute(new GeneralParams(
                "Validaciones",
                "Elemento")));
    }

//Escenario 10


    @Given("^Se envía (.*) para un (.*) de (.*)$")
    public void TipoDeCampo() {
        actor.should(new QuestionValidate(
                "El sistema envia el valor del campo").Execute(new GeneralParams(
                "valida valor",
                "Elemento")));

    }

    @When("^Se envía la peticion al servicio web$")
    public void ServicioWeb() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El sistema envia peticion servicio web",
                "Envia servicio",
                "Eleemento")));
    }

    @Then("^El sistema realiiza unas (.*) en los campos enviiados$")
    public void CamposEnviados() {
        actor.should(new QuestionValidate(
                "El sistema presenta validaciones de campos enviados").Execute(new GeneralParams(
                "presenta validaciones",
                "Elemento")));

    }

    @And("^El siiistema presenta un (.*)$")
    public void PresentaResultado() {
        actor.should(new QuestionValidate(
                "El sistema presenta un resultado").Execute(new GeneralParams(
                "Presenta resultado",
                "Elemento")));

    }

//Escenario 11


    @Given("^Se envía un (.*) para un (.*) dee (.*)$")
    public void EnviaTipoDeCampo() {
        actor.should(new QuestionValidate(
                "El sistema envia el valor del campo").Execute(new GeneralParams(
                "valida valor",
                "Elemento")));

    }

    @When("^Se envía la petiición al servicio web$")
    public void PeticionSer() {
        actor.should(new QuestionValidate(
                "El sistema envia peticion").Execute(new GeneralParams(
                "valida valor",
                "Elemento")));
    }

    @Then("^El siistema realiza unas (.*) en los campos enviiadoss$")
    public void CamposValidaosAcciones() {
        actor.should(new QuestionValidate(
                "El sistema presenta validaciones de campos enviados").Execute(new GeneralParams(
                "presenta validaciones",
                "Elemento")));

    }

    @And("^El sisstema presenta un (.*)$")
    public void SSistemaPresenta() {
        actor.should(new QuestionValidate(
                "El sistema presenta un resultado").Execute(new GeneralParams(
                "Presenta resultado",
                "Elemento")));

    }

//Escenario 12


    @And("^Ingressa la información en cada uno de los campos requeridos de forma correcta$")
    public void Ingresarinformacion() {
                   actor.attemptsTo((new EnterTextAction("").Execute(new GeneralParams(
                    "El usuario ingresa la informacion",
                    "ingresa valor",
                    "Eleemento"))));

    }
    @When("^Da cliic en el bootón Guardarr$")
    public void clicpatrainformacion() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El sistema envia peticion servicio web",
                "Envia servicio",
                "Eleemento")));
    }

    @Then("^El sistema intentaa guardar la información$")
    public void sistemaguardainformacion() {
        actor.should(new QuestionValidate(
                "El sistema presenta informacion").Execute(new GeneralParams(
                "presenta validaciones",
                "Elemento")));

    }

    @And("^Se preseenta un error de (.*)$")
    public void errordetipo() {
        actor.should(new QuestionValidate(
                "El sistema presenta un error").Execute(new GeneralParams(
                "Presenta resultado",
                "Elemento")));
    }

    @And("^El sisteema presenta un (.*)$")
    public void SsitemaPresentaMen() {
        actor.should(new QuestionValidate(
                "El sistema presenta mensaje").Execute(new GeneralParams(
                "Presenta resultado",
                "Elemento")));
    }

    @And("^El sistema no debee borrar a información de los campos del formulario$")
    public void InformaciondelosCamo() {
        actor.should(new QuestionValidate(
                "El sistema no debe borrar la información").Execute(new GeneralParams(
                "Presenta resultado",
                "Elemento")));

    }

//Escenario 13

    @And("^Selecciona el botón de Ccrear$")
    public void Infocrear() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clilc en el boton crear",
                "Elemento")));

    }

    @And("^Ingresa la información en cada uno de los campos requeridos de forma correctaa$")
        public void informacionformacorrecta() {
        actor.attemptsTo((new EnterTextAction("").Execute(new GeneralParams(
                "El usuario ingresa la informacion en cada uno de los campos requeridos",
                "Elemento"))));
    }

    @When("^Da cliiic en el botón Guardar$")
    public void clicpatr() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario hace clic en el boton guardar",
                "Envia servicio",
                "Eleemento")));
    }

    @Then("^El siistema intenta guardar la información$")
    public void sisintentainformacion() {
        actor.should(new QuestionValidate(
                "El sistema valida la informacion").Execute(new GeneralParams(
                "validaciones",
                "Elemento")));
    }
    @And("^Se presentaa un error de tipo 400$")
    public void tipo400() {
        actor.should(new QuestionValidate(
                "El sistema presenta un error 400").Execute(new GeneralParams(
                "Presenta resultado",
                "Elemento")));

    }
    @And("^El sistema redirecciona a una págiina en la cual se debe información el error$")
    public void paginaerror() {
        actor.should(new QuestionValidate(
                "El sistema redirecciona a pagina de error").Execute(new GeneralParams(
                "redirecciona",
                "Elemento")));
    }
}