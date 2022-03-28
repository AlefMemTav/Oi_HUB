# OrientacaoAObjetos
Disciplina UnB
O erro que tenho é o seguinte: No combo box de hospitaleiros da classe telaHospedagem eu atualizo os nomes dos hospitaleiros.
Para isso, na classe Hospitaleiros criei uma toString que converte o hashcode.
Quando uso getNome na toString, ela não me retorna nada. Quando uso getEmail, ela me retorna o nome e quando uso outro get, me retorna a string correta.
Então o erro está entre getNome e getEmail.

Para testar, rodar a main em telaLogin e vai para > telaHospedagem > clica no combo box hospitaleiros.
Depois vai para a classe Hospitaleiros e muda o get da toString e testa de novo.

