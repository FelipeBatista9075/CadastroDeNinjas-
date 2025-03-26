FROM eclipse-temurin:17
LABEL maintainer="felipebdias248@gmail.com"
WORKDIR /api
COPY target/CadastroDeNinjas-0.0.1-SNAPSHOT /api/cadastro10x.jar
ENTRYPOINT ["java","-jar","cadastro10x.jar"]
