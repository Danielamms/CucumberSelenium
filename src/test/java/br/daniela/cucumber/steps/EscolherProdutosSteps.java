package br.daniela.cucumber.steps;

import Utils.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class EscolherProdutosSteps extends BaseClass {

    private int expectedCount;

    @Quando("o usuário adiciona ao carrinho os seguintes produtos:")
    public void o_usuario_adiciona_ao_carrinho_os_seguintes_produtos(DataTable tabelaProdutos) {
        org.openqa.selenium.WebDriver driver = getDriver(); // Já retornará o ChromeDriver com o Password Manager desabilitado

        List<String> listaDeProdutos = tabelaProdutos.column(0);
        expectedCount = listaDeProdutos.size();

        for (String nomeProduto : listaDeProdutos) {
            String xpathDoBotao = String.format(
                    "//div[@class='inventory_item_name' and text()='%s']" +
                            "/ancestor::div[@class='inventory_item']//button",
                    nomeProduto
            );
            WebElement botaoAdd = driver.findElement(By.xpath(xpathDoBotao));
            botaoAdd.click();
        }
    }

    @Então("o carrinho deve conter a mesma quantidade de itens adicionados")
    public void o_carrinho_deve_conter_a_mesma_quantidade_de_itens_adicionados() {
        org.openqa.selenium.WebDriver driver = getDriver();
        WebElement badge = driver.findElement(By.className("shopping_cart_badge"));
        int quantidadeReal = Integer.parseInt(badge.getText());

        Assert.assertEquals(
                "A quantidade exibida no ícone do carrinho está incorreta.",
                expectedCount,
                quantidadeReal
        );
        // Não chame driver.quit() aqui, o Hook @After cuidará disso
    }
}
