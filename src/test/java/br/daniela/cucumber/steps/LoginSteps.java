package br.daniela.cucumber.steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.By;
import Utils.BaseClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class LoginSteps extends BaseClass{

@Dado("^que usuario  entra com email correto no campo de email$")
public void que_usuario_entra_com_email_correto_no_campo_de_email() throws Throwable {
	BaseClass.getDriver().get("https://www.saucedemo.com/v1/");
	driver.findElement(By.id("user-name")).sendKeys("standard_user");
}


@E("^usuario entra com password correto no campo de password$")
public void usuario_entra_com_password_correto_no_campo_de_password() throws Throwable {
	driver.findElement(By.id("password")).sendKeys("secret_sauce");
}


@Quando("^usuario clicar no botão$")
public void usuario_clicar_no_botão() throws Throwable {
	driver.findElement(By.id("login-button")).click();
}

@Então("^usuario vai entrar logar corretamente no aplicativo$")
public void usuario_vai_entrar_logar_corretamente_no_aplicativo() throws Throwable {

}

}
