# Define a imagem base
FROM eclipse-temurin:21

# Define o diretório de trabalho no container
WORKDIR /app

# Copia o código-fonte para o container
COPY src/ /impacto_manager_web/src/

# Instala as dependências
RUN mvn clean package

# Define a variável de ambiente para a porta
ENV PORT=8080

# Expose a porta
EXPOSE $PORT

# Define o comando de execução
CMD ["java", "-jar", "target/my-project-0.0.1-SNAPSHOT.jar"]