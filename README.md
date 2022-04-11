<h1 align="center"> Descrição de como iniciar a aplicação </h1>

1. Abra o ambiente de desenvolvimento de sua preferência (IntelliJ, Eclipse) e clone o projeto para o diretório escolhido.

2. Verifique as dependências do projeto e, eventualmente, habilite aquelas que estejam em falta. O projeto deve conter as seguintes dependências:

                    Spring BootDevTools | Lombok | Spring Data JPA | MySQL Driver | Spring Webflux | Spring Actuator

3. Adicione as suas credênciais MySQL no arquivo application.properties nas seguintes propriedades:

spring.datasource.url = jdbc:mysql://localhost:3306/SEU_SCHEMA_MYSQL? (adicione o seguinte comando para não truncar grandes textos nas colunas: sessionVariables=sql_mode='NO_ENGINE_SUBSTITUTION'&jdbcCompliantTruncation=false);

spring.datasource.username = seu login de usuário;

spring.datasource.password= sua senha.
                                              
Em alternativa, configure um banco de dados de sua preferência.

5. Inicie o projeto e acesse os endpoints da aplicação via Postman: localhost:8080/api/{endpointDesejado} (endpoints disponíveis conforme escopo: listCars, logs e createCar).

![endpoint api/listCars](https://user-images.githubusercontent.com/91033774/162839664-95c1cd9a-745b-41bd-a54d-237688c767e4.png)
![endpoint api/createCar](https://user-images.githubusercontent.com/91033774/162843275-9283844a-3fcd-4fa4-a68f-06f81aca5233.png)
![endpoint api/logs](https://user-images.githubusercontent.com/91033774/162839704-906b9ad2-efe8-4086-a954-d763f839e844.png)
![Tabela log visualizada no MySQL](https://user-images.githubusercontent.com/91033774/162839717-ba4e93ba-dc3f-49b9-8fa7-dc700bc2db5c.png)

