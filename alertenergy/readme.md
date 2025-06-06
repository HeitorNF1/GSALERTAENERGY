# AlertEnergy

Sistema para monitoramento de locais com e sem energia, com visualização em tempo real por meio de gráficos. A aplicação é dividida em um back-end com Spring Boot e front-end em React, ambos orquestrados via Docker.

---

## Integrantes

- Guilherme Daher 98611
- Gustavo Akio 550241
- Heitor Farias 551539

---

## Tecnologias

- **Back-end:** Java, Spring Boot, JPA, Hibernate
- **Banco de Dados:** MySQL 8
- **Front-end:** React + Vite + Recharts
- **Containerização:** Docker e Docker Compose

---

## Estrutura

```
alertenergy/
├── backend/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/
│   │   │   │       └── alertenergy/
│   │   │   │           ├── AlertEnergyApplication.java
│   │   │   │           ├── controller/
│   │   │   │           │   └── AlertaController.java
│   │   │   │           ├── model/
│   │   │   │           │   └── Alerta.java
│   │   │   │           ├── repository/
│   │   │   │           │   └── AlertaRepository.java
│   │   │   │           └── service/
│   │   │   │               └── AlertaService.java
│   │   │   └── resources/
│   │   │       ├── application.properties
│   │   │       └── static/
│   └── Dockerfile
│
├── frontend/
│   ├── public/
│   ├── src/
│   │   ├── components/
│   │   │   ├── DonutChart.jsx
│   │   │   └── SummaryCards.jsx
│   │   ├── pages/
│   │   │   └── Home.jsx
│   │   ├── App.jsx
│   │   └── main.jsx
│   ├── Dockerfile
│   └── vite.config.js
│
├── docker-compose.yml
└── README.md

```

---

## Como executar

### Pré-requisitos

- Docker instalado
- Docker Compose

### 1. Clonar o projeto

```bash
git clone https://github.com/seuusuario/alertenergy.git
cd alertenergy 
```
### 2. Subir containers

```
docker-compose up --build
```
### 3. Acessos
 - Back-end (Spring Boot): http://localhost:8080

 - Swagger: http://localhost:8080/swagger-ui.html

 - Front-end (React): http://localhost:5173

 - MySQL: Acessível via localhost:3308, banco alertdb, usuário root, senha senha123


### 4. front-end

 - entrar na pasta alert-energy-front e rodar o comando
 ```
 npm run dev
 ```

### Funcionalidade principal
 - Cadastro, listagem, atualização e remoção de alertas via API REST

 - Exibição gráfica (gráfico de rosquinha) da quantidade de locais com e sem energia

 - Cartões de resumo com totais

### Exemplo de resposta

```
[
  {
    "id": 1,
    "nome": "Residência A",
    "bairro": "Centro",
    "cidade": "São Paulo",
    "comEnergia": true,
    "mensagem": "Você tem energia."
  },
  {
    "id": 2,
    "nome": "Residência B",
    "bairro": "Centro",
    "cidade": "São Paulo",
    "comEnergia": false,
    "mensagem": "Você está sem energia."
  }
]
```