# Agenda de Contatos - API REST com Spring Boot

Uma **agenda telefônica completa** desenvolvida com **Spring Boot 3**, **Java 17**, **H2 Database** e boas práticas de mercado.

Perfeita para estudo, portfólio ou entrevista técnica de nível **Júnior**.

## Funcionalidades

- Criar, listar, buscar, atualizar e deletar contatos  
- Busca inteligente por nome ou telefone (parcial e ignorando maiúsculas/minúsculas)  
- Validação de campos com Bean Validation  
- Dados iniciais já carregados (10 contatos de exemplo)  
- Banco em memória H2 + console web  
- Código 100% em português (classes, mensagens, comentários)

## Tecnologias utilizadas

| Tecnologia              | Versão       |
|-------------------------|--------------|
| Java                    | 17           |
| Spring Boot             | 3.3.0        |
| Spring Data JPA         | Incluído     |
| H2 Database             | Em memória   |
| Hibernate               | Incluído     |
| Maven                   | Gerenciador  |

## Como rodar o projeto

### Pré-requisitos
- Java 17 ou superior
- Maven

### Passos

1. Clone o repositório
```bash
git clone https://github.com/seu-usuario/agenda-contatos.git
cd agenda-contatos

./mvnw spring-boot:run

./mvnw spring-boot:run

Método,Endpoint,Descrição
GET,/api/contatos,Lista todos os contatos
GET,/api/contatos?buscar=joao,Busca por nome ou telefone
GET,/api/contatos/{id},Busca contato por ID
POST,/api/contatos,Cria um novo contato
PUT,/api/contatos/{id},Atualiza um contato
DELETE,/api/contatos/{id},Remove um contato


{
  "nome": "Maria Souza",
  "telefone": "11987654321",
  "email": "maria@email.com"
}

Banco de Dados H2 (console web)
Acesse: http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:agendadb
Usuário: sa
Senha: (deixe em branco)

src/
 └── main/
     ├── java/com/agenda/
     │   ├── contato/        → entidade, DTOs, service, controller
     │   └── AgendaApplication.java
     └── resources/
         ├── application.yml
         └── data.sql            → 10 contatos de exemplo

Quer contribuir ou melhorar?
Fique à vontade para abrir issues ou pull requests!
Ideias legais para evoluir o projeto:

Adicionar paginação
Swagger/OpenAPI
Testes unitários e de integração
Front-end com React ou Thymeleaf
Autenticação JWT
