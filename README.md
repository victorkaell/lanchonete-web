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

1. Clone este repositório: `git clone https://github.com/victorkaell/lanchonete-web`
2. Atualize o arquivo `application.properties` com as informações do seu banco de dados MySQL local.
3. Inicie a aplicação Spring Boot (o Hibernate criará as tabelas e o `import.sql` populará os produtos e usuários automaticamente).
4. Acesse a aplicação no navegador via `http://localhost:8080`.
5. **Primeiro Acesso:** Não é necessário criar uma conta. Utilize as credenciais de teste listadas abaixo para fazer o login diretamente e explorar os diferentes níveis de acesso.

### 🔑 Credenciais de Teste e Controle de Acesso

Para facilitar a avaliação e demonstrar a aplicação prática do **Spring Security** (Role-Based Access Control), o banco de dados é inicializado automaticamente com três perfis de teste. 

> **Nota de Arquitetura:** As permissões foram isoladas intencionalmente para fins de demonstração técnica. Diferente de um cenário real onde o Administrador teria acesso global, neste projeto as rotas foram estritamente segmentadas para provar a eficácia do bloqueio de segurança entre os perfis.

Você pode utilizar as seguintes credenciais na tela de login:

**1. Perfil Administrador**
* **Usuário:** ADMIN
* **Senha:** 12345678
* **Permissões:** Acesso exclusivo ao gerenciamento do cardápio (CRUD de Produtos). *Sem permissão para visualizar a fila de pedidos.*

**2. Perfil Cozinha**
* **Usuário:** COZINHA
* **Senha:** 12345678
* **Permissões:** Acesso exclusivo à visualização e gestão da fila de pedidos. *Sem permissão para alterar produtos.*

**3. Perfil Cliente**
* **Usuário:** CLIENTE
* **Senha:** 12345678
* **Permissões:** Acesso restrito apenas à realização de novos pedidos.

---
*💡 **Detalhe Técnico de Segurança:** Embora você digite a senha em texto plano (`12345678`) na tela de login, o sistema não armazena essa informação de forma vulnerável. Todas as senhas inseridas via script de inicialização estão protegidas e armazenadas no banco de dados como hashes irreversíveis utilizando o `BCryptPasswordEncoder`.*
