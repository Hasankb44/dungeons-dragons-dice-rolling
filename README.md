# Dungeons and Dragons Dice Rolling Program



## 📦 Dependency

1. **spring-boot-starter**
   ```markdown
   ```xml
   <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
   <dependency>

2. **spring-boot-starter-test**
   ```markdown
   ```xml
   <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
   <dependency>
   
**
## 🛠️ Requirements

- **Java Development Kit (JDK 17)**
- **Maven 3.6+**
- **Spring Boot 3.x**
- Internet connection (for Maven dependencies)

---

## 📁 Project Structure

- **Main class:** `src/main/java/org/dnd/DndApplication.java`
- **Controller:** `src/main/java/org/dnd/controller/SpringController.java`
- **Service:** `src/main/java/org/dnd/service/SpringService.java`
- **Interface:** `src/main/java/org/dnd/service/impl/SSI.java`
- **Enum:** `src/main/java/org/dnd/enums/Operations.java`
- **Exception classes:**
    - `IllegalStringException.java`

---

## 🔧 How It Works

### Example Request

#### Postman
1. ```[POST] http://localhost:8000/dnd/api/roll```

#### Headers : 
##### times                           : 6
##### face                            : 100
##### op                              : SUBTRACT
##### n                               : 10
#### That's mean  : 6d100-10

2. ```[POST] http://localhost:8000/dnd/api/roll/{times}/{face}```

The difference of this method is that it does not perform any addition/subtraction operations compared to the other endpoint.

3. ```[POST] http://localhost:8000/dnd/api/roll/random```

###### All properties get random values
