# GESTÃO DE VENDAS (PRODUTOS BANCÁRIOS)
API RESTful de controle de vendas de produtos bancários.
Esta API foi desenvolvida para efeitos de estudos. Ela está baseada no modelo de maturidade proposto por Leonard Richardson alcançando os quatro níveis.

A proposta dessa API é Gerenciar a vendas de produtos ofertados pela empresa bancária onde poderemos inserir as vendas, passando as informações de (produto, nome, matrícula), a data e o ID serão inseridos automaticamente.

<img align="center" alt="Caio-pY" heigth="30" width="40" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original-wordmark.svg" > <img align="center" alt="Caio-pY" heigth="30" width="40" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original-wordmark.svg" >


## Tecnologias
 
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [PostgreSQL](https://www.postgresql.org/download/)
- [Postman](https://www.postman.com/downloads/)

## Práticas adotadas

- API RESTful
- Consultas com Spring Data JPA
- Injeção de Dependências


## API Endpoints
Testando a API
- Inserir vendas.

**POST: http://localhost:8080/vendas**
```

[
  {
    "produto" : "CAP_PM",
    "nome" : "Juliana Meira",
    "matricula" : "777771"

  }
]
```
Teremos um retorno com UUID e a data já inserida:
```
[
  {
      "id": "0bd85a4c-3bca-4167-b5f9-cc491b6558a7",
      "produto": "CAP_PM",
      "nome": "Juliana Meira",
      "matricula": "777771",
      "data": "2024-06-09T22:11:12.1336097"
  }
]
```
- Obtendo o retorno da lista completa.

**GET: http://localhost:8080/vendas**
```
[
    {
        "id": "a5107337-49cd-453f-84c3-af9dc936f2da",
        "produto": "CAP_PU",
        "nome": "Fabio",
        "matricula": "777772",
        "data": "2024-05-28T23:49:19.621768",
        "links": [
            {
                "rel": "self",
                "href": "http://localhost:8080/vendas/id/a5107337-49cd-453f-84c3-af9dc936f2da"
            }
        ]
    },
    {
        "id": "67ae4f21-132b-454a-84cc-7526779e1fb6",
        "produto": "CAP_PM",
        "nome": "Arthur César",
        "matricula": "777773",
        "data": "2024-05-29T22:49:21.797429",
        "links": [
            {
                "rel": "self",
                "href": "http://localhost:8080/vendas/id/67ae4f21-132b-454a-84cc-7526779e1fb6"
            }
        ]
    }
]
```
- Obtendo apenas uma venda.

**GET: http://localhost:8080/vendas/id/bb05ed77-eb34-4538-94e9-715e62a25e66**
```
{
    "id": "bb05ed77-eb34-4538-94e9-715e62a25e66",
    "produto": "CAP_PU",
    "nome": "Juliana Meira",
    "matricula": "777771",
    "data": "2024-06-06T00:06:38.020157",
    "_links": {
        "Vendas List": {
            "href": "http://localhost:8080/vendas"
        }
    }
}
```
-Obtendo todas as vendas por matrícula.

**GET: http://localhost:8080/vendas/777771**
```
[
    {
        "id": "0bd85a4c-3bca-4167-b5f9-cc491b6558a7",
        "produto": "CAP_PM",
        "nome": "Julia Ribeiro",
        "matricula": "777771",
        "data": "2024-06-09T22:11:12.13361",
        "links": []
    },
    {
        "id": "f38e7cc4-a2bf-4ea9-9e82-40d553489cf7",
        "produto": "CAP_PU",
        "nome": "Juliana Meira",
        "matricula": "777771",
        "data": "2024-06-09T23:15:37.396342",
        "links": []
    }
]
```
-Atualizando dados (produto, matricula ou nome).

**PUT: http://localhost:8080/vendas/a5107337-49cd-453f-84c3-af9dc936f2da**
```
{
        "produto": "CAP_PU",
        "nome": "Fabio Camargo",
        "matricula": "777772"
}
```
-Deletando dados.

**DELETE: http://localhost:8080/vendas/0bd85a4c-3bca-4167-b5f9-cc491b6558a7**

Venda deletada com sucesso.

EM Construção.............
