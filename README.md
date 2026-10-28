# E-Commerce Backend Service

Um serviço backend desenvolvido em Java com Spring Boot que simula o fluxo central de processamento de um e-commerce. A aplicação abrange desde o gerenciamento de clientes e catálogo de produtos até o processamento de pedidos, cálculo de frete e persitência em banco de dados em memória.

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java 21+
* **Framework:** Spring Boot 3.2.x
* **Acesso a Dados:** Spring Data JPA / Hibernate
* **Banco de Dados:** H2 Database (Em memória)
* **Gerenciador de Dependências:** Apache Maven
* **Arquitetura:** REST API em camadas (Controller, Service, Repository, Model)

## 📋 Pré-requisitos

Para compilar e executar esta aplicação localmente, você precisará de:

1. **Java Development Kit (JDK) 21** ou superior instalado e configurado nas variáveis de ambiente.
2. **Apache Maven 3.8+** instalado (ou via wrapper).
3. Um terminal (Bash, Zsh, PowerShell ou Prompt de Comando).

## 🚀 Como Executar o Projeto

### 1. Clonar ou Baixar o Repositório
Certifique-se de estar na pasta raiz do projeto (onde se encontra o arquivo `pom.xml`).

```bash
cd ecommerce-refactoring

**Compile o projeto e baixe as dependências:**
mvn clean install

**Inicie  a aplicação:**
mvn spring-boot:run

**Compile o projeto e baixe as dependências:**
mvn clean install

**Inicie  a aplicação:**
mvn spring-boot:run
