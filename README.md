# 🎓 SysAcademy

A comprehensive academic management system API built with Spring Boot 3.5.15, featuring complete REST API documentation with Swagger/OpenAPI.

## ✨ Features

- 📚 Student management (CRUD operations)
- 🔍 Advanced filtering and pagination
- 📄 Complete API documentation with Swagger UI
- 🗄️ PostgreSQL database with Flyway migrations
- ✅ Input validation and error handling
- 🎯 RESTful API design

## 🚀 Quick Start

### Prerequisites

- Java 21+
- Maven 3.8+
- PostgreSQL 12+

### Installation

1. **Clone the repository**
```bash
git clone https://github.com/gustavvocruzz/sysacademy.git
cd sysacademy
```

2. **Configure the database**
Update `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/academia
spring.datasource.username=postgres
spring.datasource.password=postgres
```

3. **Build the project**
```bash
./mvnw clean install
```

4. **Run the application**
```bash
./mvnw spring-boot:run
```

The application will start on **http://localhost:8080**

## 📚 API Documentation

### Swagger UI (Interactive)
Access the interactive API documentation at:
```
http://localhost:8080/swagger-ui.html
```

Here you can:
- ✅ Explore all available endpoints
- ✅ View request/response schemas
- ✅ Test endpoints directly
- ✅ See detailed error responses

### OpenAPI Specifications
- **JSON format:** `http://localhost:8080/v3/api-docs`
- **YAML format:** `http://localhost:8080/v3/api-docs.yaml`

## 📡 API Endpoints

### Students (`/alunos`)

| Method | Endpoint | Description | Status |
|--------|----------|-------------|--------|
| `POST` | `/alunos` | Create a new student | 201 |
| `GET` | `/alunos` | List students (paginated) | 200 |
| `GET` | `/alunos/{id}` | Get student by ID | 200 |
| `PUT` | `/alunos/{id}` | Update student | 200 |
| `DELETE` | `/alunos/{id}` | Delete student | 204 |

## 🔍 Example Usage

### Create a Student
```bash
curl -X POST http://localhost:8080/alunos \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "João da Silva",
    "dataNascimento": "2000-05-15",
    "genero": "M",
    "celular": "(11) 98765-4321",
    "email": "joao@example.com",
    "cidade": "São Paulo",
    "estado": "SP",
    "endereco": "Rua Principal, 123",
    "complemento": "Apto 42",
    "bairro": "Centro",
    "cep": "01310-100"
  }'
```

### List Students with Pagination
```bash
curl -X GET "http://localhost:8080/alunos?page=0&size=10&sort=nome,asc"
```

### Get Student by ID
```bash
curl -X GET http://localhost:8080/alunos/1
```

### Update Student
```bash
curl -X PUT http://localhost:8080/alunos/1 \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "João da Silva Updated",
    "email": "joao.novo@example.com",
    ...
  }'
```

### Delete Student
```bash
curl -X DELETE http://localhost:8080/alunos/1
```

## 📋 Request/Response Example

### Request (POST /alunos)
```json
{
  "nome": "João da Silva",
  "dataNascimento": "2000-05-15",
  "genero": "M",
  "telefone": "(11) 3456-7890",
  "celular": "(11) 98765-4321",
  "email": "joao@example.com",
  "observacao": "Observação do aluno",
  "endereco": "Rua Principal, 123",
  "complemento": "Apto 42",
  "bairro": "Centro",
  "cidade": "São Paulo",
  "estado": "SP",
  "cep": "01310-100"
}
```

### Response (201 Created)
```json
{
  "id": 1,
  "nome": "João da Silva",
  "dataNascimento": "2000-05-15",
  "genero": "M",
  "celular": "(11) 98765-4321",
  "email": "joao@example.com",
  "cidade": "São Paulo",
  "estado": "SP",
  "dataCadastro": "2024-01-15T10:30:00"
}
```

## 🛠️ Technology Stack

- **Framework:** Spring Boot 3.5.15
- **Language:** Java 21
- **Database:** PostgreSQL
- **Migration:** Flyway
- **API Documentation:** Springdoc OpenAPI 2.0.2 (Swagger UI)
- **Validation:** Jakarta Validation
- **Build Tool:** Maven

## 📄 Project Structure

```
sysacademy/
├── src/main/java/dev/gustavocruz/sysacademy/
│   ├── config/
│   │   └── SwaggerConfig.java              # OpenAPI configuration
│   ├── controller/
│   │   └── AlunoController.java            # Student endpoints
│   ├── domain/
│   │   ├── Aluno.java                      # Student entity
│   │   ├── Matricula.java                  # Enrollment entity
│   │   ├── Graduacao.java                  # Graduation entity
│   │   └── ...
│   ├── dtos/
│   │   ├── AlunoRequest.java               # Input DTO
│   │   ├── AlunoResponse.java              # Output DTO
│   │   └── AlunoFiltroRequest.java         # Filter DTO
│   ├── service/
│   │   └── AlunoService.java               # Business logic
│   ├── repository/
│   │   └── AlunoRepository.java            # Data access
│   └── exception/
│       └── GlobalExceptionHandler.java     # Exception handling
├── src/main/resources/
│   ├── application.properties              # Configuration
│   └── db/migration/                       # Flyway migrations
└── pom.xml                                 # Maven dependencies
```

## ✅ Field Validations

### Student (Aluno) Fields

| Field | Type | Required | Validation |
|-------|------|----------|-----------|
| nome | String | ✅ Yes | Max 150 chars, not empty |
| dataNascimento | LocalDate | ❌ No | Must be in the past (YYYY-MM-DD) |
| genero | String | ❌ No | Max 1 char (M or F) |
| telefone | String | ❌ No | Max 30 chars |
| celular | String | ❌ No | Max 30 chars |
| email | String | ❌ No | Valid email, max 150 chars |
| endereco | String | ❌ No | Max 150 chars |
| complemento | String | ❌ No | Max 150 chars |
| bairro | String | ❌ No | Max 100 chars |
| cidade | String | ❌ No | Max 100 chars |
| estado | String | ❌ No | Max 2 chars (State code) |
| cep | String | ❌ No | Max 25 chars |

## 📖 Documentation Files

- **[SWAGGER.md](./SWAGGER.md)** - Complete API documentation (Portuguese)
- **[SWAGGER_SETUP.md](./SWAGGER_SETUP.md)** - Swagger setup and configuration guide
- **[README_SWAGGER.md](./README_SWAGGER.md)** - Executive summary of Swagger implementation
- **[openapi.yaml](./openapi.yaml)** - OpenAPI 3.0 specification in YAML format

## 🔄 Database Migrations

Database migrations are managed by Flyway. Migration scripts are located in:
```
src/main/resources/db/migration/
```

Migrations are automatically applied when the application starts (if enabled in properties).

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👨‍💻 Author

**Gustavo Cruz**
- GitHub: [@gustavvocruzz](https://github.com/gustavvocruzz)
- Email: contato@gustavocruz.dev

## 🙏 Support

If you have questions or found a bug, please open an issue on GitHub.

---

**Project Status:** ✅ Active Development

**Last Updated:** 2024-01-15

**Version:** 1.0.0
