# Sistema de Lanchonete Web (E-commerce Simulado)

## 📌 Sobre o Projeto
Aplicação web simulando o ecossistema de uma lanchonete online. Este projeto foi desenvolvido como trabalho final da disciplina de Programação para Internet e teve como principal objetivo a implementação de camadas de segurança robustas e autenticação.

## 🚀 Tecnologias e Ferramentas Utilizadas
* **Linguagem e Framework:** Java, Spring Boot
* **Segurança:** Spring Security (Autenticação e Autorização)
* **Banco de Dados:** MySQL, Spring Data JPA
* **Validação de Dados:** Spring Boot Validation

## ⚙️ Funcionalidades Principais
* **Autenticação e Controle de Acesso:** Proteção de rotas e funcionalidades utilizando Spring Security.
* Gerenciamento de cardápio, produtos e pedidos.
* Validação rigorosa de dados inseridos pelo usuário no back-end.

## 🛠️ Como executar este projeto
1. Clone este repositório: `git clone github.com/victorkaell/ocorrencias`
2. Atualize o arquivo `application.properties` com as informações do seu banco de dados MySQL local.
3. Inicie a aplicação Spring Boot (o Hibernate criará as tabelas necessárias automaticamente).
4. Acesse a aplicação no navegador via `http://localhost:8080`.
5. **Primeiro Acesso:** Vá até a página de registro e crie um novo usuário, selecionando o cargo desejado (ex: ADMIN ou COZINHA) na própria interface para ter acesso às rotas protegidas pelo Spring Security.
