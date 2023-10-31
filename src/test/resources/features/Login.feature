
@Login
Feature: Fazer login


  
  Scenario: Usuario fazer login com credenciais validas
    Given que usuario  entra com email correto no campo de email
    And usuario entra com password correto no campo de password
    When usuario clicar no botão
    Then usuario vai entrar logar corretamente no aplicativo
