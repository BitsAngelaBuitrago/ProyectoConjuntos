package main.Conjuntos.tasks;
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
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class CrearUsuarios {
    Actor actor;
    @Managed
    WebDriver navegador;

    @Before
    public void ingresar() {
        actor = Actor.named("actor");
        actor.can(BrowseTheWeb.with(navegador)); //Abrir navegador

    }
//Escenario 1

    @Given("^Un usuario en la pagina de Administracion de Usuarios$")
    public void Administracion() {
        actor.attemptsTo((Performable) new QuestionValidate("Pagina de inico").Execute(new GeneralParams(
                "El usuario ingresa a la pagina de administrar usuarios",
                "pagina de administracion de usuarios",
                "")));
    }

    @When("^Selecciona el (.*)$")
    public void CrearUsua() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa al boton crear usuario",
                "Ingresa la palabra clave",
                "Elemento")));
    }

    @Then("^El sistema presenta un formulario “Creación de Usuario”$")
    public void Formulario() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El sistema presenta formulario",
                "visualiza formulario",
                "Elemento")));
    }

    @And("^El boton de guardar bloqueado$")
    public void resultadoSeleccion() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El usuario da clic en cada filtro  ",
                "Da clic en filtro",
                "Elemento")));
    }


//Escenario 2

@Given("^Un usuario en la pagina de Crear Usuario$")
public void AdministracionDeUsuarios() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa a la pagina de administrar usuarios",
                "pagina de administracion de usuarios",
                "")));
    }

    @When("^Selecciona una de las (.*) para salir de formulario de Crear Usuario$")
    public void Formularios() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa al boton crear usuario",
                "Ingresa la palabra clave",
                "Elemento")));
    }

    @Then("^El sistema presenta un (.*) junto con los botones Si y No$")
    public void PresentaFormulario() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El sistema presenta formulario",
                "visualiza formulario",
                "Elemento")));
    }

    @And("^La opcion cerrar mensaje$")
    public void GuardarBloqueado() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clic en cada filtro  ",
                "Da clic en filtro",
                "Elemento")));
    }

    //Escenario 3

    @Given("^Un usuario en la página de Crear Usuario$")
    public void paginacr() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa a la pagina de crear usuario",
                "pagina de crear usuario",
                "")));
    }

    @When("^Selecciona una de las (.*) para cerrar el mensaje$")
    public void opcio() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa al boton crear usuario",
                "Ingresa la palabra clave",
                "Elemento")));
    }

    @Then("^El sistema debe realizar unas <acciones> dependiendo de la opción seleccionada en las (.*)$")
    public void opcionescrea() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El sistema debe realizar unas acciones dependiendo la opcion seleccionada",
                "visualiza formulario",
                "Elemento")));
    }

    ///Escenario 4

    @Given("^Un esta usuario en la pagina de Crear Usuario$")
    public void uario() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa a la pagina de crear usuario",
                "pagina de crear usuario",
                "")));
    }

    @When("^Da clic en el <campo_requerido>$")
    public void opcioensaje() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa al boton crear usuario",
                "Ingresa la palabra clave",
                "Elemento")));
    }

    @And("^Da clic por fuera del campo$")
    public void GuardarBlo() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clic en cada filtro  ",
                "Da clic en filtro",
                "Elemento")));
    }

    @Then("^El sistema presenta un (.*) indicando que el campo es requerido$")
    public void camporequerido() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El sistema debe realizar unas acciones dependiendo la opcion seleccionada",
                "visualiza formulario",
                "Elemento")));
    }

    @And("^El sistema debe indicar a nivel visual que el campo es obligatorio$")
    public void validar() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clic en cada filtro  ",
                "Da clic en filtro",
                "Elemento")));
    }
    ////Escenario 5

    @Given("^se encuentra en Crear Usuario$")
    public void paginausuario() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa a la pagina de crear usuario",
                "pagina de crear usuario",
                "")));
    }

    @When("^Realiza una <accion> sobre los campos$")
    public void opcionesmensaje() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa al boton crear usuario",
                "Ingresa la palabra clave",
                "Elemento")));
    }

    @Then("^El sistema presenta sí o no <habilitado> el botón de guardar$")
    public void mensajerequerido() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El sistema debe realizar unas acciones dependiendo la opcion seleccionada",
                "visualiza formulario",
                "Elemento")));
    }

////Escenario 6

    @Given("^Un usuario se encuentra en la pagina de Crear Usuario$")
    public void pagina() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa a la pagina de crear usuario",
                "pagina de crear usuario",
                "")));
    }

    @And("^Da clic en elññ (.*)$")
    public void clickEnGuardar() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clic en cada filtro  ",
                "Da clic en filtro",
                "Elemento")));
    }

    @When("^Selecciona del (.*) una (.*)$")
    public void seleccionar() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa al boton crear usuario",
                "Ingresa la palabra clave",
                "Elemento")));
    }

    @Then("^El sistema realiza las (.*) y (.*) consecuente$")
        public void men() {
            actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                    "El sistema debe realizar unas acciones dependiendo la opcion seleccionada",
                    "visualiza formulario",
                    "Elemento")));
    }

    ////Escenario 7

    @Given("^Un usuario en la pagina de Crear Usuarios$")
    public void usuariospagina() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa a la pagina de crear usuario",
                "pagina de crear usuario",
                "")));
    }

    @And("^Da clic en el (.*)$")
    public void Gu() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clic en cada filtro",
                "Da clic en filtro",
                "Elemento")));
    }
    @When("^Ingresa un (.*) el sistema valida las <reglas> definidas para el Campo (.*)$")
    public void mensaje() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa al boton crear usuario",
                "Ingresa la palabra clave",
                "Elemento")));
    }
    @Then("^El sistema realiza sí o no unas (.*)$")
    public void acciones() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El sistema debe realizar unas acciones dependiendo la opcion seleccionada",
                "visualiza formulario",
                "Elemento")));
    }

    ////Escenario 8

    @Given("^Un usuario en la pagina de Crear Usuari$")
    public void usua() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa a la pagina de crear usuario",
                "pagina de crear usuario",
                "")));
    }

    @And("^Da clic en el campo numerico$")
    public void camponumerico() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clic en cada filtro",
                "Da clic en filtro",
                "Elemento")));
    }

    @When("^Ingresa un (.*) el sistema valida las (.*) definidas para el Campo # Documento$")
    public void camponumericodelsa() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa al boton crear usuario",
                "Ingresa la palabra clave",
                "Elemento")));
    }
    @Then("^El sistema realiza si o no unas (.*)$")
    public void accionesdelsitema () {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El sistema debe realizar unas acciones dependiendo la opcion seleccionada",
                "visualiza formulario",
                "Elemento")));
    }

    ////Escenario 9

    @Given("^ingresa a la de pagina de Crear Usuario$")
    public void paginusuao() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa a la pagina de crear usuario",
                "pagina de crear usuario",
                "")));
    }

    @When("^Da clic en tomar foto$")
    public void camponumericosistema() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa al boton crear usuario",
                "Ingresa la palabra clave",
                "Elemento")));
    }
    @Then("^El sistema presenta un pop up el cual permitira tomar una foto frontal de la persona o cargarla desde el computador$")
    public void tomarfot () {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El sistema debe realizar unas acciones dependiendo la opcion seleccionada",
                "visualiza formulario",
                "Elemento")));

    }

    @And("^El sistema carga la foto en la base de datos al dar clic en aceptar$")
        public void cargarfotos () {
            actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                    "El usuario da clic en cada filtro",
                    "Da clic en filtro",
                    "Elemento")));
    }

    ////Escenario 10

    @Given("^Un usuario en la página de Administrar Usuarios$")
    public void paginusuario() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa a la pagina de crear usuario",
                "pagina de crear usuario",
                "")));
    }

    @When("^Existen (.*) usuarios de De Usuarios$")
    public void camponumericodelsistema() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa al boton crear usuario",
                "Ingresa la palabra clave",
                "Elemento")));
    }

     @And("^Se visualiza el paginador en la parte inferior de la pagina$")
        public void cargarfoto() {
         actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                 "El usuario da clic en cada filtro",
                 "Da clic en filtro",
                 "Elemento")));
     }

    @And("^Se da clic en (.*)$")
    public void darclic() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clic en cada filtro",
                "Da clic en filtro",
                "Elemento")));

    }
    @Then("^Se mostraran los usuarios asignados por pagina$")
    public void motrarusuarios () {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El sistema debe realizar unas acciones dependiendo la opcion seleccionada",
                "visualiza formulario",
                "Elemento")));

    }
}