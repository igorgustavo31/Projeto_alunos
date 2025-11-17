# 🧪 API REST de Gerenciamento de Alunos e Cursos

## 🎯 Descrição do Projeto
Esta é uma **API RESTful** desenvolvida em **Spring Boot** com persistência em **MariaDB**, para gerenciar **alunos** e **cursos**.  
O sistema implementa **CRUD completo** para ambas as entidades, utilizando **DTOs** para controle de dados expostos e validações básicas para garantir consistência.

---

## 🛠️ Tecnologias Utilizadas
- Java 17  
- Spring Boot  
- Spring Web (REST API)  
- Spring Data JPA (ORM)  
- Lombok (redução de boilerplate)  
- MariaDB (banco de dados)  
- Maven/Gradle (gerenciamento de dependências)  
- Postman / cURL (testes de API)  

---

## 📁 Estrutura do Banco de Dados

### Entidade: Curso
| Campo | Tipo | Observações |
|-------|------|------------|
| `id` | Long | Chave primária |
| `nome` | String | Nome do curso |
| `cargaHoraria` | Integer | Carga horária do curso |

### Entidade: Aluno
| Campo | Tipo | Observações |
|-------|------|------------|
| `id` | Long | Chave primária |
| `nome` | String | Nome completo do aluno |
| `email` | String | Email único do aluno |
| `dataNascimento` | LocalDate | Data de nascimento |
| `curso` | Curso | Relacionamento Many-to-One com Curso |

---

## ⚙️ Configuração do Banco (`application.properties`)
```properties
spring.datasource.url=jdbc:mariadb://localhost:3306/universidade
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MariaDBDialect
# 🧪 API REST de Gerenciamento de Alunos e Cursos

## 🎯 Descrição do Projeto
Esta é uma **API RESTful** desenvolvida em **Spring Boot** com persistência em **MariaDB**, para gerenciar **alunos** e **cursos**.  
O sistema implementa **CRUD completo** para ambas as entidades, utilizando **DTOs** para controle de dados expostos e validações básicas para garantir consistência.

---

## 🛠️ Tecnologias Utilizadas
- Java 17  
- Spring Boot  
- Spring Web (REST API)  
- Spring Data JPA (ORM)  
- Lombok (redução de boilerplate)  
- MariaDB (banco de dados)  
- Gradle (gerenciamento de dependências)  
- Postman(testes de API)  

---

## 📁 Estrutura do Banco de Dados

### Entidade: Curso
| Campo | Tipo | Observações |
|-------|------|------------|
| `id` | Long | Chave primária |
| `nome` | String | Nome do curso |
| `cargaHoraria` | Integer | Carga horária do curso |

### Entidade: Aluno
| Campo | Tipo | Observações |
|-------|------|------------|
| `id` | Long | Chave primária |
| `nome` | String | Nome completo do aluno |
| `email` | String | Email único do aluno |
| `dataNascimento` | LocalDate | Data de nascimento |
| `curso` | Curso | Relacionamento Many-to-One com Curso |

---

## ⚙️ Configuração do Banco (`application.properties`)
```properties
spring.datasource.url=jdbc:mariadb://localhost:3306/universidade
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MariaDBDialect
