# Usa uma imagem base com Maven e JDK 21
FROM maven:3.9.9-eclipse-temurin-21

# Atualiza pacotes e instala dependências mínimas
RUN apt-get update && apt-get install -y --no-install-recommends \
    && rm -rf /var/lib/apt/lists/*

# Define o diretório da aplicação
ENV INSTALL_PATH=/warehouse

RUN mkdir -p ${INSTALL_PATH}
WORKDIR ${INSTALL_PATH}

# Copia todos os arquivos do projeto para o container
COPY . .

# Compila o projeto (gera o JAR dentro de /target)
#RUN mvn clean package -DskipTests

# Expõe a porta padrão do Spring Boot
#EXPOSE 8080

# Executa a aplicação
#CMD ["java", "-jar", "target/*.jar"]
