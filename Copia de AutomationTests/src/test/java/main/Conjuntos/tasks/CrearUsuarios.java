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
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

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
    public void administracion() {
        actor.attemptsTo((Performable) new QuestionValidate("Pagina de inico").Execute(new GeneralParams(
                "El usuario ingresa a la pagina de administrar usuarios",
                "pagina de administracion de usuarios",
                "Elemento")));
    }

    @When("^Selecciona el (.*)$")
    public void crearUsua() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario hace clilc en el boton crear",
                "Clic en el boton",
                "Elemento")));
    }

    @Then("^El sistema presenta un formulario “Creación de Usuario”$")
    public void Formulario() {
        actor.should(new QuestionValidate(
                "El sistema presenta formulario").Execute(new GeneralParams(
                "visualiza formulario",
                "Elemento")));
    }

    @And("^El boton de guardar bloqueado$")
    public void resultadoSeleccion() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El usuario debera visualizar el boton guardar bloqueado ",
                "boton guardar bloqueado",
                "Elemento")));
    }

//Escenario 2

    @Given("^Un usuario en la pagina de Crear Usuario$")
    public void administracionDeUsuarios() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario se encuentra en la pagina crear usuario",
                "pagina de crear usuario",
                "Elemento")));
    }

    @When("^Selecciona una de las (.*) para salir de formulario de Crear Usuario$")
    public void Formularios() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario selecciona una de las opciones del formulario",
                "Selecciona una de las opciones",
                "Elemento")));
    }

    @Then("^El sistema presenta un (.*) junto con los botones Si y No$")
    public void PresentaFormulario() {
        actor.should(new QuestionValidate(
                "El sistema presenta formulario").Execute(new GeneralParams(
                "visualiza formulario",
                "Elemento")));
    }

    @And("^La opcion cerrar mensaje$")
    public void GuardarBloqueado() {
        actor.should(new QuestionValidate(
                "El usuario visualiza la opcion cerrar mensaje").Execute(new GeneralParams(
                "Cerrar mensaje",
                "Elemento")));
    }

    //Escenario 3

    @Given("^Un usuario en la página de Crear Usuario$")
    public void paginaCr() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa a la pagina de crear usuario",
                "pagina de crear usuario",
                "Elemento")));
    }

    @When("^Selecciona una de las (.*) para cerrar el mensaje$")
    public void opcio() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuarioda clicen en el boton crear usuario",
                "Boton crear",
                "Elemento")));
    }

    @Then("^El sistema debe realizar unas (.*) dependiendo de la opción seleccionada en las (.*)$")
    public void opcionesCrea() {
        actor.should(new QuestionValidate(
                "El sistema debe realizar validaciones dependiendo la opcion seleccionada").Execute(new GeneralParams(
                "Realiza validaciones",
                "Elemento")));
    }

    ///Escenario 4

    @Given("^Un esta usuario en la pagina de Crear Usuario$")
    public void uario() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa a la pagina de crear usuario",
                "pagina de crear usuario",
                "Elemento")));
    }

    @When("^Da clic en el (.*)$")
    public void opcioenSaje() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clic en el campo requerido",
                "campo requerido",
                "Elemento")));
    }

    @And("^Da clic por fuera del campo$")
    public void guardarBlo() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clic por fuera del campo",
                "Da clic en fuera del campo",
                "Elemento")));
    }

    @Then("^El sistema presenta un (.*) indicando que el campo es requerido$")
    public void camporeQuerido() {
        actor.should(new QuestionValidate(
                "El sistema presenta un mensaje").Execute(new GeneralParams(
                "Presenta mensaje",
                "Elemento")));
    }

    @And("^El sistema debe indicar a nivel visual que el campo es obligatorio$")
    public void validar() {
        actor.should(new QuestionValidate(
                "El sistema debe validar que el campo es obligatorio").Execute(new GeneralParams(
                "Validar campo obligatorio",
                "Elemento")));
    }
    ////Escenario 5

    @Given("^se encuentra en Crear Usuario$")
    public void paginaUsuario() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa a la pagina de crear usuario",
                "pagina de crear usuario",
                "Elemento")));
    }

    @When("^Realiza una (.*) sobre los campos$")
    public void opcionesMensaje() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario realiza una accion sobre los campos",
                "accion sobre los campos",
                "Elemento")));
    }

    @Then("^El sistema presenta sí o no (.*) el botón de guardar$")
    public void mensajeRequerido() {
        actor.should(new QuestionValidate(
                "El sistema presenta un si o no habilitado").Execute(new GeneralParams(
                "El sistema presenta si o no",
                "Elemento")));
    }

////Escenario 6

    @Given("^Un usuario se encuentra en la pagina de Crear Usuario$")
    public void pagina() {
        actor.should(new QuestionValidate(
                "El usuario ingresa a la pagina de crear usuario").Execute(new GeneralParams(
                "pagina de crear usuario",
                "Elemento")));
    }

    @And("^Da clic en el1 (.*)$")
    public void clickEnGuardar() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clic en el campo",
                "clic en el campo",
                "Elemento")));
    }

    @When("^Selecciona del (.*) una (.*)$")
    public void seleccionar() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario selecciona un listado",
                "Selecciona  listado",
                "Elemento")));
    }

    @Then("^El sistema realiza las (.*) y (.*) consecuente$")
    public void men() {
        actor.should(new QuestionValidate(
                "El sistema debe realizar unas validaciones").Execute(new GeneralParams(
                "visualiza formulario",
                "Elemento")));
    }

    ////Escenario 7

    @Given("^Un usuario en la pagina de Crear Usuarios$")
    public void usuariospagina() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa a la pagina de crear usuario",
                "pagina de crear usuario",
                "Elemento")));
    }

    @And("^Da clic en el (.*)$")
    public void EsteUsuarioDaclicEnCampo() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clic en el campo",
                "Clic en el campo",
                "Elemento")));
    }

    @When("^Ingresa un (.*) el sistema valida las (.*) definidas para el Campo (.*)$")
    public void mensaje() {
        actor.should(new QuestionValidate(
                "El sistema valida las especificaciones definidas para el campo").Execute(new GeneralParams(
                "Valida especificaciones",
                "Elemento")));
    }

    @Then("^El sistema realiza sí o no unas (.*)$")
    public void acciones() {
        actor.should(new QuestionValidate(
                "El sistema debe realizar unas acciones dependiendo la opcion seleccionada").Execute(new GeneralParams(
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
        actor.should(new QuestionValidate(
                "El usuario ingresa al boton crear usuario").Execute(new GeneralParams(
                "Ingresa la palabra clave",
                "Elemento")));
    }

    @Then("^El sistema realiza si o no unas (.*)$")
    public void realizaUnasValidaciones() {
        actor.should(new QuestionValidate(
                "El sistema debe realizar unas acciones dependiendo la opcion seleccionada").Execute(new GeneralParams(
                "visualiza formulario",
                "Elemento")));
    }

    ////Escenario 9


    @When("^Da clic en el Enlace Tomar Foto$")
    public void haceClicEnEnlace() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario ingresa al boton crear usuario",
                "Clilc en enlace",
                "Elemento")));
    }

    @Then("^El sistema presenta un pop up el cual permitirá tomar una foto frontal de la persona o cargarla desde el computador.$")
    public void accionesdelsitema() {
        actor.should(new QuestionValidate(
                "El sistema presenta un pop-up el cual permitira tomar una foto frontal").Execute(new GeneralParams(
                "visualiza formulario",
                "Elemento")));
    }

    ////Escenario 10


    @When("^Da clic en el Enlace Agregar Foto$")
    public void agregarFoto() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clic en enlace agregar foto",
                "Clilc en enlace",
                "Elemento")));
    }

    @And("^Da clic en la <opción>$")
    public void opcionClicDa() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clic en la opcion",
                "clic opcion",
                "Elemento")));
    }

    @Then("^El sistema realiza la <acción>$")
    public void accionTomarFoto() {
        actor.should(new QuestionValidate(
                "El sistema realiza la accion").Execute(new GeneralParams(
                "realiza accion",
                "Elemento")));
    }

////Escenario 11

    @And("^Agrega una Foto$")
    public void AgregarUnaFoto() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clic para agrea¿gar una foto",
                "Agregar foto",
                "Elemento")));
    }

    @When("^Sube una Foto$")
    public void subirPhoto() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clic para subir foto",
                "Subir foto",
                "Elemento")));
    }

    @Then("^Se muestra un pop up de carga$")
    public void seMuestraUnPopUpCargar() {
        actor.should(new QuestionValidate(
                "El sistema muestra un pop-up").Execute(new GeneralParams(
                "Muestra un pop-up",
                "Elemento")));
    }

    @And("^El botón de Guardar inhabilitado$")
    public void botonGuardaInhabilitado() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isNotVisible()));
    }

    ////Escenario 12

    @And("^Agrega una Foto $")
    public void GirarFoto() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clic para girar una foto",
                "Girar Foto",
                "Elemento")));
    }

    @When("^Se da clic en el <sentido> del giro$")
    public void girarPhoto() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da click para girar la foto",
                "GirarPhoto",
                "Elemento")));
    }

    @Then("^Se muestra la foto rotada 90 grados hacía el sentido seleccionado$")
    public void sistemaMuestraFotoGirada() {
        actor.should(new QuestionValidate(
                "El sistema muestra la foto rotada 90 grados").Execute(new GeneralParams(
                "Mustra la foto rotada",
                "Elemento")));
    }

    ////Escenario 13

    @And("^Esta cargada la foto$")
    public void estacargadalafoto() {
        actor.should(new QuestionValidate(
                "El usuario da clic en cargar foto").Execute(new GeneralParams(
                "Cargar foto",
                "Elemento")));
    }

    @When("^Se da clic en la foto$")
    public void photoCLic() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clic enla foto",
                "Clic foto",
                "Elemento")));
    }

    @And("^Se selecciona una <opción>$")
    public void seleccionauopmcion() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clic en cargar foto",
                "Cargar foto",
                "Elemento")));
    }

    @Then("^Se realiza la <acción>$")
    public void actionrota90grados() {
        actor.should(new QuestionValidate(
                "El sistema muestra la foto rotada 90 grados").Execute(new GeneralParams(
                "Mustra la foto rotada",
                "Elemento")));
    }


    ////Escenario 14


    @And("^Esta cargada la foto$")
    public void cargadaDelafoto() {
        actor.should(new QuestionValidate(
                "El usuario da clic en cargar foto").Execute(new GeneralParams(
                "Cargar foto",
                "Elemento")));
    }

    @And("^Se guardó$")
    public void seguardo() {
        actor.should(new QuestionValidate(
                "El usuario guarda foto").Execute(new GeneralParams(
                "guarda foto",
                "Elemento")));
    }

    @When("^da clic en la foto$")
    public void Clicenlafoto() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clic enla foto",
                "Clic foto",
                "Elemento")));
    }

    @And("^Se selecciona Eliminar Foto$")
    public void seleccionEliminar() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario selecciona eliminar foto",
                "Eliminar foto",
                "Elemento")));
    }

    @And("^Selecciona la <opción>$")
    public void elimiPhoto() {
        actor.should(new QuestionValidate(
                "El usuario selecciona la opcion").Execute(new GeneralParams(
                "Selecciona opcion",
                "Elemento")));
    }

    @Then("^Se realiza la <acción>$")
    public void realizaAcciondeeliminaciondephoto() {
        actor.should(new QuestionValidate(
                "El sistema realiza la accion").Execute(new GeneralParams(
                "Mustra la foto rotada",
                "Elemento")));
    }

    ////Escenario 15


    @When("^Realiza una acción sobre un campo$")
    public void camponumericosistema() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clic para tomar foto",
                "clic para tomar foto",
                "Elemento")));

    }

    @Then("^El sistema presenta sí o no habilitado el botón de guardar$")
    public void tomarfot() {
        actor.should(new QuestionValidate(
                "El sistema debe realizar unas acciones dependiendo la opcion seleccionada").Execute(new GeneralParams(
                "visualiza formulario",
                "Elemento")));
    }


    ////Escenario 16


    @And("^Ingresa la información en cada uno de los <campos> requeridos de forma correcta$")
    public void ingresaInformacion() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El usuario ingresa informacion",
                "Ingresa informacion",
                "Elemento")));
    }

    @When("^Da clic en el botón Guardar$")
    public void usuarioDaclicEnGuaradr() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clic en boton guardar",
                "Ingresa da clic en boton guardar",
                "Elemento")));
    }

    @Then("^El sistema realiza el registro de Ingreso del Usuario exitosamente y muestra el mensaje “los <registros> <ingresados> ha sido creado exitosamente”$")
    public void sistemaRealizaRegistro() {
        actor.should(new QuestionValidate(
                "El sistema debe realizar unas acciones dependiendo la opcion seleccionada").Execute(new GeneralParams(
                "visualiza formulario",
                "Elemento")));
    }

    @And("^El sistema debera realizar unas <acciones>$")
    public void accionesDelSistema() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El sistema debera realizar unas validaciones",
                "Realiza unas validaciones",
                "Elemento")));

    }

////Escenario 17

    @And("^Ingresa la información en cada uno de los campos requeridos de forma correcta$")
    public void camposRequeridosPorfomulario() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El usuario ingresa informacion obligatoria",
                "Ingresa informacion",
                "Elemento")));
    }

    @When("^Da clic en el botón Guardar$")
    public void usuarioGuarda() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clic en boton guardar",
                "Ingresa da clic en boton guardar",
                "Elemento")));
    }

    @Then("^El sistema intenta guardar la información$")
    public void sistemaIntentaGuardar() {
        actor.should(new QuestionValidate(
                "El sistema debe intentar guardar la informacion").Execute(new GeneralParams(
                "guardar informacion",
                "Elemento")));
    }

    @And("^Se presenta un error de <tipo>$")
    public void sePresentaError() {
        actor.should(new QuestionValidate(
                "El sistema presenta un error").Execute(new GeneralParams(
                "Presenta error",
                "Elemento")));
    }

    @And("^El sistema presenta un <mensaje>$")
    public void SePodraVisualizarMensaje() {
        actor.should(new QuestionValidate(
                "El sistema presenta un mensaje").Execute(new GeneralParams(
                "Ingresa informacion",
                "Elemento")));
    }

    @And("^El sistema no debe borrar a información de los campos del formulario $")
    public void BorrarInformacionDecampos() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El sistema no debe borrar los campos de los formularios",
                "Campos de formularios",
                "Elemento")));
    }

    ////Escenario 18

    @And("^Selecciona el botón de Crear$")
    public void usuarioDaClilcEnCrear() {
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "El usuario da clic en el boton crear",
                "da clilc en craer",
                "Elemento")));
    }

    @And("^Ingresa la información en cada uno de los campos requeridos de forma correcta$")
    public void Valideinformacioningresada() {
        actor.should(new QuestionValidate(
                "El sistema presenta un mensaje").Execute(new GeneralParams(
                "Ingresa informacion",
                "Elemento")));
    }

    @When("^Da clic en el botón Guardar$")
    public void haceclicenesteboton() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "El usuario da clic en boton guardar",
                "Ingresa da clic en boton guardar",
                "Elemento")));
    }

    @Then("^El sistema guardar la información$")
    public void GuardarLaInfo() {
        actor.should(new QuestionValidate(
                "El sistema debe intentar guardar la informacion").Execute(new GeneralParams(
                "guardar informacion",
                "Elemento")));
    }

    @And("^El sistema intenta guardar la información$")
    public void sistemaInformacion() {
        actor.should(new QuestionValidate(
                "El sistema presenta un error").Execute(new GeneralParams(
                "Presenta error",
                "Elemento")));
    }

    @And("^Se presenta un error de tipo 400$")
    public void tipoDeError400() {
        actor.should(new QuestionValidate(
                "El sistema presenta un mensaje").Execute(new GeneralParams(
                "Ingresa informacion",
                "Elemento")));
    }
}
