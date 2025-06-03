# language: pt
# language: pt
Funcionalidade: Escolha de produtos na loja e adição ao carrinho

  Contexto:
    Dado que usuario  entra com email correto no campo de email
    E usuario entra com password correto no campo de password
    Quando usuario clicar no botão
    Então usuario vai entrar logar corretamente no aplicativo

  Cenário: Adicionar múltiplos produtos ao carrinho (quantidade variável)
    Quando o usuário adiciona ao carrinho os seguintes produtos:
      | produto                    |
      | Sauce Labs Backpack        |
      | Sauce Labs Bike Light      |
      | Sauce Labs Bolt T-Shirt    |
    Então o carrinho deve conter a mesma quantidade de itens adicionados

  Cenário: Adicionar apenas um produto ao carrinho (quantidade variável)
    Quando o usuário adiciona ao carrinho os seguintes produtos:
      | produto                 |
      | Sauce Labs Fleece Jacket |
    Então o carrinho deve conter a mesma quantidade de itens adicionados
