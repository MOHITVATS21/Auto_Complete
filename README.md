# Auto-Complete Project

A Spring Boot application providing **auto-complete suggestions** using **Trie** and **Fuzzy Search** algorithms. The project is Dockerized for easy deployment.

---

## Features

- **Auto-Complete Search:** Fast prefix-based search using Trie data structure.  
- **Fuzzy Search:** Handles typos or approximate matches in user input.  
- **In-Memory Database:** H2 database storing names.  
- **REST APIs:** Fetch suggestions based on prefix input.  

---

## Tech Stack

- **Backend:** Java 21, Spring Boot 3.5.4  
- **Database:** H2 (in-memory)  
- **Build Tool:** Maven  
- **Containerization:** Docker  
- **Testing:** JUnit  

---

## Port Configuration

| Environment        | Port |
|-------------------|------|
| Spring Boot App    | 9090 |
| Docker Container   | 9090 |

> Note: In Docker, the application is exposed on **9090** .

---

## How It Works

- **Trie Search:** Quickly finds all names starting with the given prefix.  
- **Fuzzy Search:** Returns names even with minor spelling mistakes.  

Example:

| Input Prefix | Output Suggestions         |
|--------------|---------------------------|
| `Mar`        | `["Mark", "Marcus", "Marlon"]` |
| `Jhn` (fuzzy)| `["John", "Johnny"]`      |

---

## Running the Application

### Locally
```bash
mvn spring-boot:run
```

### Using Docker
```bash
docker build -t auto-complete-app .
docker run -p 9090:9090 auto-complete-app
```

- Access API:  
  ```
  GET http://localhost:9090/autocomplete?prefix=<name>
  ```
- H2 Console:  
  ```
  http://localhost:9090/h2-console
  ```

---

## Example API Calls



**Response:**
```json
http://localhost:9090/api/autocomplete?prefix=Mar
{

  "prefix": "Mar",
  "suggestions": ["Mark", "Marcus", "Marlon"]
}
```



**Response:**
```json
http://localhost:9090/api/autocomplete?prefix=Jhn
{
  "prefix": "Jhn",
  "suggestions": ["John", "Johnny"]
}
```

---

## Notes

- Ensure `data.sql` is properly loaded for Trie initialization.  
- Dockerized version maps port 9090 externally same as Spring Boot.  
- Trie is used for exact prefix matches; Fuzzy Search handles approximate matches.
