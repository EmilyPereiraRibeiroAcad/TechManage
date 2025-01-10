# Tech Manage 

Uma API back-end com objetivo de gerenciar usuiarios.
APIRESTful com Spring boot. Contendo operaçõe sbasicas de gerenciamento de usuarios.

## 🚀 Começando

Essas instruções permitirão que você obtenha uma cópia do projeto em operação na sua máquina local para fins de desenvolvimento e teste.

## **Pré-requisitos**

Certifique-se de ter os seguintes programas instalados:

- **Java JDK 17** (ou a versão que você está usando)  
  Verifique com:
  ```bash
  java -version
  ```

- **Maven** (ou Gradle, dependendo do seu projeto)  
  Verifique com:
  ```bash
  mvn -version
  ```

- **Banco de Dados MySQL**  
  Certifique-se de que o MySQL esteja rodando e que as credenciais estejam configuradas corretamente.

---
### 🔧 Instalação
## **Passo 1: Clone o Repositório**

Clone o repositório para sua máquina local:
```bash
git clone https://github.com/seu-usuario/sua-api.git
cd sua-api
```

---

## **Passo 2: Configure o Banco de Dados**

1. Crie um banco de dados no MySQL:
   ```sql
   CREATE DATABASE sua_base_de_dados;
   ```

2. Atualize o arquivo `src/main/resources/application.properties` (ou `application.yml`) com as credenciais do banco:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/sua_base_de_dados
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   ```

---
## **Passo 3: Compile o Projeto**

Compile e empacote o projeto com o seguinte comando:
```bash
mvn clean package
```
---

## **Passo 4: Execute a Aplicação**

Execute o arquivo `.jar` gerado:
```bash
java -jar target/sua-api-1.0.0.jar
```
> Substitua `sua-api-1.0.0.jar` pelo nome correto do arquivo gerado.

---

## **Passo 5: Teste a API**

Após a execução bem-sucedida, a API estará disponível em:
```
http://localhost:8080
```

---
### ⌨️ E testes de estilo de codificação

O teste valida a integração do Controller
```
```

## **Rotas Disponíveis**

- **GET /api/users**  
  Retorna a lista de usuários.  

- **GET /api/users/{id}**  
  Retorna um usuário específico pelo ID.  

- **POST /api/users**  
  Cria um novo usuário.  
  - **Exemplo de Payload:**
    ```json
    {
      "fullName": "Joana Marcolina",
      "email": "joanaMac@example.com",
      "phone": "+1 123 4567-8901",
      "birthDate": "1990-01-01",
      "userType": "EDITOR"
    }
    ```

---
## **Erros Comuns**

1. **Banco de dados não configurado corretamente:**  
   Certifique-se de que o MySQL está rodando e as credenciais estão corretas no arquivo de configuração.  

2. **Porta já em uso:**  
   Se a porta 8080 estiver ocupada, altere a porta no arquivo `application.properties`:
   ```properties
   server.port=9090
   ```

---

## 📦 Implantação

A API é construida de forma que permite facil manutenção e implantação, dessa forma para uma maior implementação seria necessário apenas pequenos ajustes.

## 🛠️ Construído com

Este projeto foi desenvolvido utilizando as seguintes tecnologias:

- **[Java](https://www.oracle.com/java/)** - Linguagem principal para desenvolvimento da API.
- **[Spring Boot](https://spring.io/projects/spring-boot)** - Framework para construção da aplicação.
- **[Maven](https://maven.apache.org/)** - Gerenciador de dependências e build.
- **[MySQL](https://www.mysql.com/)** - Banco de dados relacional utilizado.
- **[Lombok](https://projectlombok.org/)** - Biblioteca para reduzir código boilerplate no Java.

## **Contato**

Se tiver dúvidas ou encontrar problemas, entre em contato:
- **Email:** emily2003profissional@outlook.com

