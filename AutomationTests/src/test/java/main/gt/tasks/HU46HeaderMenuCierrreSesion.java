package main.gt.tasks;

import core.Helpers.GeneralParams;
import core.actions.ClickButtonAction;
import core.questions.QuestionValidate;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class HU46HeaderMenuCierrreSesion {
    Actor actor;

    @When("^Da clic en el logo de la unidad inmobiliaria en el header$")
    public void daClicEnElLogoDeLaUnidadInmobiliariaEnElHeader() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da clic sobre logo",
                "logo",
                "/input[@id='password']"
        )));
    }

    @Then("^El sistema presenta una ventana emergente para realizar la configuración de logo$")
    public void elSistemaPresentaUnaVentanaEmergenteParaRealizarLaConfiguracionDeLogo() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Con un botón de Seleccionar imagen$")
    public void conUnBotonDeSeleccionarImagen() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Texto descriptivo del formato y tamaño máximo de la imagen$")
    public void textoDescriptivoDelFormatoYTamanoMaximoDeLaImagen() {
        actor.should(new QuestionValidate("Texto descriptivo").Execute(new GeneralParams(
                "Texto descriptivo formato y tamaño",
                "formato y tamaño",
                "//button[@name='action']"
        )));

    }

    @And("^Texto descriptivo del tamaño máximo de la imagen$")
    public void textoDescriptivoDelTamanoMaximoDeLaImagen() {
        actor.should(new QuestionValidate("‘con un tamaño máximo de 5MB’").Execute(new GeneralParams(
                "‘con un tamaño máximo de 5MB’",
                "‘con un tamaño máximo de 5MB’",
                "//button[@name='action']"
        )));
    }

    @And("^Con un botón de guardar$")
    public void conUnBotonDeGuardar() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Un botón de Cancelar$")
    public void unBotonDeCancelar() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Con opción de cerrar ventana$")
    public void conOpcionDeCerrarVentana() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Da clic sobre el botón de seleccionar imagen$")
    public void daClicSobreElBotonDeSeleccionarImagen() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da clic sobre seleccionar imagen",
                "Seleccionar imagen",
                "/input[@id='password']"
        )));
    }

    @When("^Un usuario administrador selecciona el botón guardar$")
    public void unUsuarioAdministradorSeleccionaElBotonGuardar() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da clic sobre Botón guardar",
                "Botón guardar",
                "/input[@id='password']"
        )));
    }

    @And("^Cierra la ventana emergente$")
    public void cierraLaVentanaEmergente() {
        actor.should(seeThat(the("/button[@name='action']"), isNotVisible()));
    }

    @And("^Actualiza el logo de la unidad inmobiliaria$")
    public void actualizaElLogoDeLaUnidadInmobiliaria() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^No actualiza la imagen de logo de la unidad inmobiliaria$")
    public void noActualizaLaImagenDeLogoDeLaUnidadInmobiliaria() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @When("^Da clic sobre una (.*) del menu$")
    public void daClicSobreUnaPaginaDelMenu(String pagina) {
        switch (pagina) {
            case "Inicio":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da clic sobre Inicio",
                        "Inicio",
                        "/input[@id='password']"
                )));
                break;
            case "Unidad Inmobiliaria":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da clic sobre Unidad Inmobiliaria",
                        "Unidad Inmobiliaria",
                        "/inp ut[@id='password']"
                )));
                break;
            case "Crear Unidad Inmobiliaria":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da clic sobre Botón guardar",
                        "Botón guardar",
                        "/input[@id='password']"
                )));
                break;
        }
    }

    @Then("^El sistema muestra la (.*)$")
    public void elSistemaMuestraLaRuta_de_navegacion(String ruta) {
        actor.should(new QuestionValidate(ruta).Execute(new GeneralParams(
                "Ruta de navegación",
                "Ruta de navegación",
                "//button[@name='action']"
        )));

    }

    @And("^Debe presentar como enlace la informacion antes de la ultima en la (.*)$")
    public void debePresentarComoEnlaceLaInformacionAntesDeLaUltimaEnLaRuta_de_navegacion(String ruta) {
        actor.should(new QuestionValidate(ruta).Execute(new GeneralParams(
                "Ruta de navegación",
                "Ruta de navegación",
                "//button[@name='action']"
        )));
    }


    @When("^Da clic sobre un (.*) de la (.*)$")
    public void daClicSobreUnEnlaceDeLaRuta_de_navegacion(String enlace, String ruta) {
        switch (ruta) {
            case "Unidad Inmobiliaria/Crear":
                if (enlace.equals("Unidad Inmobiliria")){actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da clic sobre Botón guardar",
                        "Botón guardar",
                        "/input[@id='password']"
                )));
                }
                break;
            case "Unidad Independiente/Crear":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da clic sobre Botón guardar",
                        "Botón guardar",
                        "/input[@id='p assword']"
                )));
                break;
        }
    }

    @Then("^El sistema debe presentar una (.*)$")
    public void elSistemaDebePresentarUnaPagina_resultado(String pagina_resultado) {
        actor.should(new QuestionValidate(pagina_resultado).Execute(new GeneralParams(
                "Ruta de navegación",
                "Ruta de navegación",
                "//button[@name='action']"
        )));
    }

    @When("^Da clic sobre la sección de perfil$")
    public void daClicSobreLaSeccionDePerfil() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da clic sobre Botón guardar",
                "Botón guardar",
                "/input[@id='password']"
        )));
    }

    @Then("^El sistema debe presentar una ventana con las opciones$")
    public void elSistemaDebePresentarUnaVentanaConLasOpciones() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Da clic sobre opción de cambiar foto perfil$")
    public void daClicSobreOpcionDeCambiarFotoPerfil() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da clic sobre Botón guardar",
                "Botón guardar",
                "/input[@id='password']"
        )));
    }

    @Then("^El sistema presenta una ventana emergente para realizar el cambio de imagen$")
    public void elSistemaPresentaUnaVentanaEmergenteParaRealizarElCambioDeImagen() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^botón de Seleccionar imagen$")
    public void botonDeSeleccionarImagen() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @When("^Un usuario selecciona el botón guardar$")
    public void unUsuarioSeleccionaElBotonGuardar() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da clic sobre Botón guardar",
                "Botón guardar",
                "/input[@id='password']"
        )));
    }

    @And("^Actualiza la imagen de perfil del usuario autenticado$")
    public void actualizaLaImagenDePerfilDelUsuarioAutenticado() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^No actualiza la imagen de perfil$")
    public void noActualizaLaImagenDePerfil() {
        actor.should(seeThat(the("/button[@name='action']"), isNotVisible()));
    }

    @And("^El sistema presenta la (.*) seleccionada$")
    public void elSistemaPresentaLaPaginaSeleccionada(String pagina) {
        actor.should(new QuestionValidate(pagina).Execute(new GeneralParams(
                "Ruta de navegación",
                "Ruta de navegación",
                "//button[@name='action']"
        )));
    }

    @Then("^Presenta la página de autenticacion$")
    public void presentaLaPaginaDeAutenticacion() {
        actor.should(new QuestionValidate("Pagina autenticación").Execute(new GeneralParams(
                "Ruta de navegación",
                "Ruta de navegación",
                "//button[@name='action']"
        )));
    }

    @Then("^Visualiza el logo de la unidad inmobiliaria$")
    public void visualizaElLogoDeLaUnidadInmobiliaria() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Visualiza Nombre de la unidad inmobiliaria$")
    public void visualizaNombreDeLaUnidadInmobiliaria() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Visualiza Ruta de navegacion$")
    public void visualizaRutaDeNavegacion() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Visualiza Icono de cambiar de unidad inmobiliaria$")
    public void visualizaIconoDeCambiarDeUnidadInmobiliaria() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Visualiza Seccion perfil con el usuario y foto$")
    public void visualizaSeccionPerfilConElUsuarioYFoto() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Visualiza cierre de sesion$")
    public void visualizaCierreDeSesion() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }


    @Then("^El sistema presenta el (.*)$")
    public void elSistemaPresentaElMensaje(String mensaje) {
        actor.should(new QuestionValidate(mensaje).Execute(new GeneralParams(
                "Mensaje no cumple con las reglas",
                "mensaje de error",
                "//button[@name='action']"
        )));
    }
}
