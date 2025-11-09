# jessycaMVCSpringBoot-2.0

##Ali no application.properties temos essas duas linhas aqui:

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

Basicamente a linha: spring.jpa.hibernate.ddl-auto=update é a responsável por gerar de forma automática as tabelas do banco de dados, o update ali significa que caso algum atributo de alguma classe seja alterada, tipo:

public class Cliente {
Integer id;
String nome;
Integer CPF;
}

Vamos supor que o Integer do CPF seja alterado para Spring, automaticamente, o banco de dados irá atualizar o CPF (que antes era Integer) para String também.

------------------------------------------

Outro detalhe, o projeto para ser rodado precisa ter o Apache Tomcat configurado no Computador (Se criar no Spring Initializr, não é necessário instalar o Tomcat, já que você pode adicioná-lo pela dependência Spring Web, o mesmo vale para o Driver JDBC MySQL, Spring Data JPA (que contém o hibernate e o JPA) e entre outros). 

Já a linha: spring.jpa.show-sql=true define que todas as queries SQL que são geradas pelo hibernate sejam exibidas no console.
