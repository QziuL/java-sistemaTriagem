## Sistema de Consulta de Triagem Hospitalar

### Tecnologias usadas:
- Java 21 com Spring Boot
- Spring Web, Data MongoDB e RabbitMQ
- Docker para serviços do MongoDB e RabbitMQ

Utilizando uma fila para novas triagens, um microserviço escuta uma fila e realiza operações através de uma API que se comunicará com um banco de dados. 
O microserviço permite requisições a respeito das triagens, além de informar a quantidade de pacientes que não foram atendidos.

### Iniciar aplicação
Dentro da pasta <b>/local</b> executar "docker compose up" para baixar e iniciar os serviços configurados no arquivo <i>docker-compose.yml</i>.

RabbitMQ configurado em <i>localhost:15672</i> com user e password <b>'guest'</b>.

### Fluxo do sistema
<img src="https://github.com/user-attachments/assets/1a07ce4a-d853-42fa-be38-4a5d2571fb36" style="width: 540px;"></img>

<br/>

### JSON a ser recebido pelo RabbitMQ
```
{
	"paciente": {
			"nome": "Luiz Fernando Quinholi",
			"nascimento": "21-12-2004",
			"cpf": "12345678901",
			"telefone": "44912345678",
			"cep": "83838383"
			},
	"atendido": false
}
```

<br/>

### Diagramação Mermaid

```mermaid
classDiagram
	class Triagem {
			-Long codigoTriagem
			-Paciente paciente
			-Boolean atendido
	}
	
	class Paciente {
	    -Long codigoPaciente
	    -String nome
	    -String nascimento
	    -String cpf
	    -String telefone
	    -String cep
	}

Triagem --> Paciente
```

<br/>

### Endpoints

 ![image](https://github.com/user-attachments/assets/b85c0e9b-6e75-4534-baca-1fd1ae048da3)

 <!-- GET All <br/>
 ![image](https://github.com/user-attachments/assets/7acc81d4-05d7-4a63-9e95-fd25259eddb4)

 GET One <br/>
 ![image](https://github.com/user-attachments/assets/cc633727-e58c-4bf2-84b7-e5999d351f21) -->
