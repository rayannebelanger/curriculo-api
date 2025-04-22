# Etapa de build com Maven e Java 17
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app

# Copia os arquivos do projeto pro container
COPY pom.xml .
COPY src ./src

# Compila o projeto e gera o .jar (sem rodar os testes)
RUN mvn clean package -DskipTests

# Etapa de runtime: só leva o .jar gerado
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copia o .jar gerado na etapa de build
COPY --from=build /app/target/*.jar app.jar

# Expõe a porta que o Spring Boot usa
EXPOSE 8080

# Comando que roda a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]