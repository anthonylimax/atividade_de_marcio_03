# Etapa de Build
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app

# Copie apenas o pom.xml primeiro para otimizar o cache de dependências
COPY pom.xml .
RUN mvn dependency:go-offline -B  # Faz download das dependências offline

# Agora copie o código-fonte
COPY src ./src

# Compile e empacote o projeto, ignorando os testes
RUN mvn clean package -DskipTests

# Etapa de Runtime
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copiar o JAR gerado da etapa de build
COPY --from=build /app/target/*.jar app.jar

# Expor a porta 8080
EXPOSE 8080

# Definir o ponto de entrada do container
ENTRYPOINT ["java", "-jar", "app.jar"]
