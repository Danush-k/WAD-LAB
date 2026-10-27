# WAD-LAB (Web Application Development Laboratory)

This repository contains the lab exercises, assignments, and projects completed as part of the **Web Application Development (WAD)** curriculum.

---

## 📁 Repository Structure

| Folder / Project | Description | Tech Stack |
| :--- | :--- | :--- |
| [`CourseReg2`](./CourseReg2) | Course Registration backend application | Spring Boot, Java, Maven |
| [`student-frontend`](./student-frontend) | Student Portal / Course Registration frontend | React, Vite, JavaScript, CSS |
| [`Exercise-3_Bingo_Game`](./Exercise-3_Bingo_Game) | Interactive Bingo game application with reports | HTML5, CSS3, JavaScript |
| [`Servlet`](./Servlet) | Java Servlet web application | Java Servlets, XML (`web.xml`) |
| [`TechNova`](./TechNova) | Modern landing page and UI design | HTML5, Vanilla CSS |

---

## 🚀 Getting Started

### 1. Spring Boot Backend (`CourseReg2`)
```bash
cd CourseReg2
./mvnw spring-boot:run
```

### 2. React Frontend (`student-frontend`)
```bash
cd student-frontend
npm install
npm run dev
```

### 3. Static Web Applications (`Exercise-3_Bingo_Game`, `TechNova`)
Open `index.html` directly in your browser or run a static file server (e.g. `npx serve .` or VS Code Live Server).

### 4. Java Servlets (`Servlet`)
- **Start Tomcat:**
  ```bash
  tomcat-start   # or: ~/tomcat/bin/startup.sh
  ```
- **Compile Servlet:**
  ```bash
  cd Servlet
  ./compile.sh
  ```
- **Access in Browser:**
  Open [http://localhost:8080/Servlet/](http://localhost:8080/Servlet/) in your browser.
- **Stop Tomcat:**
  ```bash
  tomcat-stop    # or: ~/tomcat/bin/shutdown.sh
  ```

---

## 👤 Author
- **Danush K** ([@Danush-k](https://github.com/Danush-k))
