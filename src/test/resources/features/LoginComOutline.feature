# language: pt
Funcionalidade: Autenticação de usuário no sistema

  Como usuário autenticado
  Quero realizar login utilizando email e password válidos
  Para acessar as funcionalidades restritas do sistema

  Contexto:
    Dado que o usuário está na página de login

  Esquema do Cenário: Validação do login com diferentes combinações de email e password
    Quando o usuário insere o email "<email>"
    E o usuário insere o password "<password>"
    E o usuário clica no botão "Entrar"
    Então o sistema deve exibir a mensagem "<mensagemEsperada>"


    Exemplos:
      | email                | password       | mensagemEsperada                                            |
      | standard_user        | secret_sauce   | Products                                            |
      | locked_out_user      | secret_sauce   | Epic sadface: Sorry, this user has been locked out. |
      | standard_user        |                | Epic sadface: Password is required                  |
      |                      | secret_sauce   | Epic sadface: Username is required                  |
