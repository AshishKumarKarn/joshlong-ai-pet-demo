# joshlong-ai-pet-demo

Demo project based on [this YouTube video](https://www.youtube.com/watch?v=NMPf373dzvM&t=533s).

---

## Prerequisites

- **Java 24**
- **Maven**
- **PostgreSQL** with [PGVector extension](https://github.com/pgvector/pgvector)

---

## Setup

### 1. Database

Create a PostgreSQL database named `petstore` and ensure the PGVector extension is installed.

Set the following VM properties for database access:
```
-Dspring.datasource.username=<<your>> -Dspring.datasource.password=<<your>> -Dspring.datasource.url=jdbc:postgresql://localhost:5432/petstore</your></your>
```

### 2. API Key

Set your Spring AI OpenAI API key as an environment variable:

```
SPRING_AI_OPENAI_API_KEY=sk-proj-<<your>></your>
```

---

## Running the Application

Start the application using your preferred method (Maven, IDE, etc.).

---

## Example Usage

Adopt a dog using the following `curl` command:

```
curl --location 'http://localhost:8080/adoption/dog/adopt/6'
--header 'content-type: application/json'
--data '{"name":"Ashish"}'
```

Monitor the console for published events.

---