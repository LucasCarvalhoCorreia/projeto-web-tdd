# projeto-web-tdd
Projeto desenvolvido com o objetivo de testar conhecimentos em relação a desenvolvimento de testes de automação em TDD.

Conteúdo e descrições do projeto:

projeto-web-tdd
  - src/main/java (pasta onde estão as classes e pacotes)
    - br.com.rsinet.hub_tdd.pageFactory (pacote onde foram criadas as classes de manipulação de elementos por pagina.)
      - CadastroPage.java (classe responsável por executar os elementos localizados na página de cadastro.)
      - HomePage.java (classe responsável por executar os elementos localizados na página inicial.)
      - PagamentoPage.java (classe responsável por executar os elementos localizados na página de pagamento dos produtos.)
      -PesquisaPage.java (classe responsável por executar os elementos localizados na página de pesquisa de produtos.)
      
    - br.com.rsinet.hub_tdd.testData (pacote onde está o arquivo responsável por armazenar a massa de dados.)
      - MassaDeDados.xlsx (arquivo de massa de dados.)
      
    - br.com.rsinet.hub_tdd.testes.falhas (pacote onde estão as classes de teste de falha de cada cenário.)
      - CadastroErrado.java (classe responsável por executar o teste de cadastro com cenário de falha.)
      - ConsultaPorBarraDePesquisaErrado.java (classe responsável por executar o teste de consulta em barra de pesquisa com cenário de falha.)
      - ConsultaPorCategoriaErrado.java (classe responsável por executar o teste de consulta de produto por categoria na pagina inicial com cenário de falha.)
      
    - br.com.rsinet.hub_tdd.testes.sucessos (pacote onde estão as classes de teste de sucesso de cada cenário.)
      - CadastroSucesso.java (classe responsável por executar o teste de cadastro com cenário de sucesso.)
      - ConsultaPorBarraDePesquisaSucesso.java (classe responsável por executar o teste de consulta em barra de pesquisa com cenário de sucesso.)
      - ConsultaPorCategoriaSucesso.java (classe responsável por executar o teste de consulta de produto por categoria na pagina inicial com cenário de sucesso.)
      
    - br.com.rsinet.hub_tdd.utils (pacote onde estão classes com algumas utilidades do projeto.)
      - Constantes.java (classe responsável por localizar a coluna de cada elemento utilizado nos testes dentro do arquivo de massa de dados.)
      - DriverFactory.java (classe que contém métodos responsáveis por iniciar e fechar o browser dos testes.)
      - ExcelUtils.java (classe responsável por fazer a comunicação dos testes com o arquivo de massa de dados.)
      - PegaMassa.java (classe responsável por pegar dados do arquivo de massa e retornar na classe de teste.)
      - Prints.java (classe que contem métodos responsáveis por tirar prints dos cenários de teste.)
      
  - target
    - falhas (pasta onde são guardados os prints de testes de falha.)
    - sucessos (pasta onde são guardados os prints de testes de sucesso.)
    
  - test-output
    - emailable-report.html (arquivo gerado apos os testes onde mostra um relatório do andamento da execução dos testes.)
        
  - pom.xml (arquivo onde são declaradas as dependencias do maven.)
  - TestNG.xml (arquivo utilizado para executar todos os testes de falha e sucesso de uma vez para gerar um único report.)
