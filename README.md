DESCRIÇÃO DE COMO INICIAR A APLICAÇÃO

1. Abra o ambiente de desenvolvimento de sua preferência (IntelliJ, Eclipse) e clone o projeto para o diretório de sua preferência.

2. Verifique as dependências do projeto e, eventualmente, habilite aquelas que estejam em falta. O projeto deve conter as seguintes dependências:

Spring BootDevTools | Lombok | Spring Data JPA | MySQL Driver | Spring Webflux | Spring Actuator

3. Adicione as suas credênciais MySQL no arquivo application.properties nas seguintes propriedades:

spring.datasource.url = jdbc:mysql://localhost:3306/SEU_SCHEMA_MYSQL? (adicione o seguinte comando para não truncar grandes textos nas colunas: sessionVariables=sql_mode='NO_ENGINE_SUBSTITUTION'&jdbcCompliantTruncation=false);

spring.datasource.username = seu login de usuário;

spring.datasource.password= sua senha.
                                              OU
                                              
Em alternativa, configure um banco de dados de sua preferência.

5. Inicie o projeto e acesse os endpoints da aplicação via Postman: localhost:8080/api/{endpointDesejado} (endpoints disponíveis conforme escopo: listCars, logs e createCar)


.![get](https://user-images.githubusercontent.com/91033774/162839664-95c1cd9a-745b-41bd-a54d-237688c767e4.png)
![get log](https://user-images.githubusercontent.com/91033774/162839704-906b9ad2-efe8-4086-a954-d763f839e844.png)
![mysql](https://user-images.githubusercontent.com/91033774/162839717-ba4e93ba-dc3f-49b9-8fa7-dc700bc2db5c.png)
