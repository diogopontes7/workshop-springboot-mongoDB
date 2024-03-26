# Projeto MongoDB com Spring Boot

## Introdução
Neste projeto vai ser simulado uma rede social, ou seja, os usuários existentes nesta base de dados podem fazer posts e comentários e esses dados vão ser armazenados em agregados. Temos de utilizar NoSql, já que este tipo de redes sociais necessitam de um grande volume de acesso a dados.
Este projeto utiliza o framework Spring Boot para criar uma API REST, disponibilizando serviços web para o sistema. A API REST permite a comunicação entre diferentes sistemas por meio de requisições HTTP(POST,GET...), seguindo os princípios RESTful. Para testar e interagir com a API, utilizamos a ferramenta Postman, que oferece uma interface intuitiva para enviar requisições e receber respostas.

## Descrição
Este projeto implementa um sistema utilizando o Spring Boot e o MongoDB, explorando as diferenças entre o paradigma orientado a documentos e relacional. Implementa operações de CRUD (Create, Read, Update, Delete), reflete sobre decisões de design para um base de dados orientado a documentos e aborda a implementação de associações entre objetos, tanto por meio de objetos aninhados quanto de referências. Também realiza consultas utilizando Spring Data e MongoRepository.

## Requisitos
- Java Development Kit (JDK)
- Maven
- MongoDB
- Spring Boot

## Configuração
1. Clone o repositório do projeto para o seu ambiente local.
2. Certifique-se de ter o MongoDB instalado e em execução no seu sistema.
3. Abra o projeto em sua IDE de preferência.
4. Configure as informações de conexão com o MongoDB no arquivo `application.properties`.
5. Execute o projeto.

## Funcionalidades

### 1. Compreensão das diferenças entre paradigmas de banco de dados
- Este projeto proporciona uma oportunidade para entender as diferenças fundamentais entre bancos de dados orientados a documentos e relacionais, incluindo suas vantagens e desvantagens.

### 2. Implementação de operações CRUD
- Create: Criação de novos documentos.
- Read: Recuperação de documentos existentes.
- Update: Atualização de documentos existentes.
- Delete: Remoção de documentos existentes.

### 3. Decisões de design para um banco de dados orientado a documentos
- Aborda decisões de design específicas para bancos de dados orientados a documentos, como a modelagem de dados denormalizados e a incorporação de dados em objetos aninhados.

### 4. Implementação de associações entre objetos
- Demonstra duas formas de estabelecer associações entre objetos no MongoDB:
  - Objetos aninhados: Incorporação de objetos relacionados dentro de um único documento.
  - Referências: Utilização de referências entre documentos para representar associações.

### 5. Consultas com Spring Data e MongoRepository
- Apresenta exemplos de consultas utilizando o Spring Data e o MongoRepository, facilitando a interação com o MongoDB por meio de interfaces simples e métodos intuitivos.

## Contribuição
Contribuições são bem-vindas! Se você identificar bugs, problemas de desempenho ou tiver sugestões de melhorias, sinta-se à vontade para abrir uma issue ou enviar um pull request.

##Desenvolvedores
Este projeto foi desenvolvido pelo [Diogo Pontes](https://github.com/diogopontes7) com a ajuda do Prof. Nélio ALves no curso [Java COMPLETO Programação Orientada a Objetos + Projetos](https://www.udemy.com/course/java-curso-completo/?couponCode=GENAISALE24). Queria agradecer ao Prof Nélio Alves pelos os ensinamentos e pela a ajuda na realização deste projeto.
