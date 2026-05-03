# 🏦 J-Finance: Sistema de Financiamento Imobiliário

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java 17+
* **Banco de Dados:** PostgreSQL 16/18
* **Driver:** JDBC PostgreSQL Driver
* **IDE:** IntelliJ IDEA

---

## 🚀 Como Executar o Projeto Localmente

Para rodar este projeto no seu computador, siga estes passos:

### 1. Preparar o Banco de Dados
1. Certifique-se de ter o PostgreSQL instalado.
2. Crie um banco de dados chamado `db_jfinance`.
3. Execute o script contido no arquivo `schema.sql` (disponível na raiz deste projeto) para criar a tabela de financiamentos.

### 2. Configurar a Conexão no Java
1. No IntelliJ, abra a classe `util.ConnectionDB`.
2. Altere a constante `PASSWORD` para a senha do seu PostgreSQL local:
   ```java
   private static final String PASSWORD = "sua_senha_aqui";
