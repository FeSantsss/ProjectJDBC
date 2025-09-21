# ProjectJDBC

Repositório para testes e estudos com **JDBC** (Java Database Connectivity) e **MySQL**.

---

## 📋 Sobre

Projeto de exemplo/conceitual para implementar operações básicas de CRUD (Create, Read, Update, Delete) usando Java + JDBC + MySQL. Foi feito para praticar:

- conexão com banco de dados MySQL;
- uso de DAO (Data Access Object);
- tratamento de exceções de banco (integridade, erros de SQL, etc);
- organização de camadas de aplicação (entidades, DAOs, implementação JDBC, aplicação principal).

---

## 🧱 Estrutura do Projeto

A estrutura de diretórios principal inclui:
src/
├─ application/
│ ├ MenuDB.java ← Interface/principal para interagir com o usuário
│ └ Program.java ← Classe principal de execução
├─ db/
│ ├ DB.java ← Gerenciamento da conexão com o banco
│ ├ DbException.java
│ └ DbIntegrityException.java
└─ model/
├ dao/
│ ├ DepartmentDao.java
│ ├ SellerDao.java
│ └ FactoryDao.java
├ dao/impl/
│ ├ DepartmentDaoJDBC.java
│ └ SellerDaoJDBC.java
└ entities/
├ Department.java
└ Seller.java


---

## 🔧 Tecnologias / Dependências

- Java 17
- MySQL
- JDBC driver para MySQL `mysql-connector-java`

---

## 🛠 Funcionalidades implementadas

- Inserção de entidades (ex: Seller, Department)
- Leitura/listagem (select) de dados
- Atualização de registros
- Remoção de registros, com tratamento de possíveis violações de integridade (ex: chaves estrangeiras)
- Uso de padrão DAO para separar lógica de acesso a dados da lógica de aplicação

  ##AUTOR:
  - Felipy Santos
