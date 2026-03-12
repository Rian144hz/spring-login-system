# 🚀 Spring-login-system

Sistema de autenticação e gestão de utilizadores desenvolvido com **Java** e **Spring Boot**. O projeto implementa um fluxo completo de registo e login, com integração a uma base de dados **MySQL**.

## 📋 Funcionalidades

* **Registo de Utilizadores**: Captura de nome, sobrenome, e-mail e senha.
* **Validação de E-mail Único**: Impede o registo de e-mails duplicados através da restrição `@Column(unique = true)` na entidade e validação lógica no Controller.
* **Autenticação (Login)**: Verificação de credenciais diretamente na base de dados com feedback de erro para dados incorretos.
* **Interface Web**: Páginas de front-end integradas via JavaScript utilizando a Fetch API.

## 🛠️ Tecnologias Utilizadas

* **Linguagem**: Java 17
* **Framework**: Spring Boot 3
* **Persistência**: Spring Data JPA
* **Base de Dados**: MySQL
* **Front-end**: HTML5, CSS3 e JavaScript

## 📂 Estrutura do Projeto

O projeto está organizado seguindo as melhores práticas do ecossistema Spring:

* `src/main/java/com/cadastroUsuario/controller/`: Endpoints da API.
* `src/main/java/com/cadastroUsuario/model/`: Entidades JPA.
* `src/main/java/com/cadastroUsuario/repository/`: Interfaces de acesso aos dados.
* `src/main/resources/static/`: Front-end do sistema.

## 🚀 Como Executar

1. **Clonar o repositório**:
   ```bash
   git clone [https://github.com/rian144hz/spring-login-system.git](https://github.com/rian144hz/spring-login-system.git)
