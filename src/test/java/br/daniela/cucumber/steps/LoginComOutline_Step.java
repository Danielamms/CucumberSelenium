package br.daniela.cucumber.steps;

import Utils.BaseClass;
import io.cucumber.java.es.Dado;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Então;
import org.junit.Assert;
import org.openqa.selenium.By;

import static org.bouncycastle.cms.RecipientId.password;

public class LoginComOutline_Step extends BaseClass {




    @Dado("que o usuário está na página de login")
    public void que_o_usuário_está_na_página_de_login() {
        BaseClass.getDriver().get("https://www.saucedemo.com/v1/");
        driver.findElement(By.xpath("/html/body/div[1]"));

    }

    @Quando("o usuário insere o email {string}")
    public void o_usuário_insere_o_email(String email) {
        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("user-name")).sendKeys(email);

    }

    @Quando("o usuário insere o password {string}")
    public void o_usuário_insere_o_password(String password) {
        driver.findElement(By.id("password")).sendKeys(password);

    }

    @Quando("o usuário clica no botão {string}")
    public void o_usuário_clica_no_botão(String Entrar) {
        driver.findElement(By.id("login-button")).click();

    }

    @Então("o sistema deve exibir a mensagem {string}")
    public void o_sistema_deve_exibir_a_mensagem(String mensagemEsperada) {
        String mensagemTela;

        // Se a mensagem esperada for "Products", entendemos que foi login bem-sucedido
        if (mensagemEsperada.equals("Products")) {
            // Localiza o título na página /inventory.html
            mensagemTela = driver.findElement(
                    By.xpath("//*[@id='inventory_filter_container']/div")
            ).getText();
        } else {
            // Senão, procura a mensagem de erro (Epic sadface) na página de login
            mensagemTela = driver.findElement(
                    By.xpath("//*[@id='login_button_container']/div/form/h3")
            ).getText();
        }

        Assert.assertEquals(mensagemEsperada, mensagemTela);
    }




}



