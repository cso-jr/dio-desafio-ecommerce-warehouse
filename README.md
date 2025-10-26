# Desafio de projeto DIO - Arquitetura de microsserviços em Java utilizando Spring Boot:
# /storefront e /warehouse

Este projeto tem como objetivo desenvolver uma arquitetura de microsserviços em Java utilizando Spring Boot, abordando desde a criação e configuração dos serviços até a integração de mensageria e ferramentas de apoio ao desenvolvimento. Este desafio consiste em dois microsserviços principais:
 - warehouse (armazém) ---> esse projeto.
 - storefront (vitrine) ---> link do repositório: https://github.com/cso-jr/dio-desafio-ecommerce
Que se comunicam tanto de forma síncrona (HTTP) quanto assíncrona (via RabbitMQ).

Essa aplicação foi desenvolvida na IDE Eclipse e utlizando Maven como builder e gerenciador de dependências, lombok para automação de código, mapstruct e Docker.

## Atividades proporcionadas pela execução desse projeto:

 - Aplicação de conceitos de orientação a objetos;
 - Implementação da estrutura de entidades com herança e composição;
 - Criação de repositórios simulando persistência em memória com bando de dados H2;
 - Pratica de boas práticas com uso de Lombok, enums e records;
 - Documentação de processos técnicos de forma clara e estruturada; 
 - Utilização o GitHub como ferramenta para compartilhamento de documentação técnica.
 - Configuração e utilização de conteinerização por meio do Docker, docker-compose e dockerfile;
 - Utilização de recursos de mensageria via RabbitMQ;
 - experiência com Docker, docker-compose, dockerfile.

## Conceitos praticados e pontos de atenção:

- Diferente da proposta do professor, foi utilizado o Maven ao invés do Gradle como builder, o que trouxe alguns desafios adicionais, uma vez adaptar um projeto é mais complicado que apenas reproduzí-lo. Esse é um ponto que deve ser considerado.
- O lombok e o mapstruct são ferramentas muito interessantes de serem utilizadas mas requerem cuidado com correta instalação de todo o sistema e interação entre esses recursos. Eventualmente alguma incompatibilidade aparece e o resultado não sai como desejado;
- Falando compatibilidade, o RabbitMQ requer uma atenção especial ao ser utilizado juntamente com Spring Boot e Docker. Orquestar esse sistema é desafiador e merece um tempo a mais investido para aparar algumas arestas em algo tão promissor.
- O tratamento de erros, exceções e validações é uma avenida a ser explorada nesse projeto que certamente proporciona enorme evolução na compreensão do código e vai ficar para melhorias futuras.
- Em melhorias, pode-se incluir a verificação de endpoints e trechos de código de forma intermediária para reduzir grandes alterações na fase final do projeto.
  
## 🚀 Instalando storefront e warehouse
- Baixe os projetos separadamente
  
  storefront: https://github.com/cso-jr/dio-desafio-ecommerce

  warehouse: https://github.com/cso-jr/dio-desafio-ecommerce-warehouse
  
- Tenha o docker instalado.

Na pasta /storefront execute o comando:
```
docker-compose up --build
```
Na pasta /warehouse execute o comando:
```
docker-compose up --build
```

Esse comando vai executar o docker-compose, subir os containers com storefront, warehouse e rabbitmq.
