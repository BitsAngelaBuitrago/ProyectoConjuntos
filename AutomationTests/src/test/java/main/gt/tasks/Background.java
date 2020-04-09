package main.gt.tasks;

import core.actions.OpenUrlAction;
import core.Helpers.GeneralParams;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Background {

    Actor actor;

    @Managed
    WebDriver navegador;


    @Given("^Que usuario ingresa a la pagina de inicio$")
    public void ingresarAUrl() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador)); //Abrir navegador
        actor.has(new OpenUrlAction().Execute(new GeneralParams(
                "https://app-frontresidentialcomplex-dev-001.azurewebsites.net/account/login")));

    }

    @And("^Inicia sesión$")
    public void iniciarSesion() {

        actor.attemptsTo(
                Enter.keyValues("test").into("//input[@id='userName']")
        );
        actor.attemptsTo(
                Enter.keyValues("test").into("//input[@id='password']")
        );

        actor.attemptsTo(
                MoveMouse.to("//a[contains(text(),'Ingresar')]").andThen(Actions::click));

    }


}
