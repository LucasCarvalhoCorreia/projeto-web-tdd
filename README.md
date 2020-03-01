# projeto-web-tdd
Projeto desenvolvido com o objetivo de testar conhecimentos em relação a desenvolvimento de testes de automação em TDD.

Conteúdo e descrições do projeto:

projeto-web-tdd
  - src/main/java (pasta onde estão as classes e pacotes)
  
    - br.com.rsinet.hub_bdd.excel (Pacote responsável por agrupar as classes que vão manipular dados relacionados ao excel.)
      - Constantes.java (Classe responsável por identificar as colunas dentro do arquivo de massa de dados através de variáveis.)
      - ExcelUtils.java (Classe responsável por fazer a comunicação do arquivo de massa de dados com a automação.)
      - PegaMassa.java (Classe responsável por pegar os dos armazenados na massa de dados.)
      
    - br.com.rsinet.hub_tdd.extendReport (Pacote responsável por agrupar as classes que vão manipular dados relacionados ao Extend Report.)
      - ExtendReport.java (Classe responsável por manipular o relatorio gerado pelo extend report.)
      - Prints.java (Classe responsável por tirar os prints.)
      
    - br.com.rsinet.hub_tdd.manager (Pacote responsável por agrupar as classes que vão manipular os drivers.)
      - DriverFactory.java (Classe responsável por criar os drivers, iniciar e fechar o app.)
      
    - br.com.rsinet.hub_tdd.pageObject (pacote onde foram criadas as classes de manipulação de elementos por pagina.)
      - CadastroPage.java (classe responsável por executar os elementos localizados na página de cadastro.)
      - HomePage.java (classe responsável por executar os elementos localizados na página inicial.)
      - PagamentoPage.java (classe responsável por executar os elementos localizados na página de pagamento dos produtos.)
      - PesquisaPage.java (classe responsável por executar os elementos localizados na página de pesquisa de produtos.)
      
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
      
  - target
        
  - pom.xml (arquivo onde são declaradas as dependencias do maven.)
  - SuiteDeTestes.xml (arquivo utilizado para executar todos os testes de falha e sucesso de uma vez para gerar um único report.)
