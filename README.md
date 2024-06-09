## Ms cartoes 

## Usagem/Exemplos

- CRUD cliente

## Uso/Exemplos


Procurar cartao por cpf de um cliente

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `cpf` | `string` | **Obrigatório**. |

Method: GET
```
http://localhost:8080/cartoes?cpf=xxx.xxx.xxx-xx
```
Body (raw)
```JSON
[
  {
    "id": 0,
    "nome": "Bradesci visa",
    "bandeira": "VISA",
    "renda": 5000,
    "limiteBasico": 0
  }
]
```

Procurar cartao por renda


| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `renda` | `Long` | **Obrigatório**. |

Method: GET
```
http://localhost:8080/cartoes?renda=5000
```
Body (raw)
```JSON
[
    {
        "id": 1,
        "nome": "Bradesco visa",
        "bandeira": "VISA",
        "renda": 5000.00,
        "limiteBasico": 150.00
    }
]
```
Criar um novo cartao

Method: POST
```
http://localhost:8080/cartoes
```
Body (pretty)
```JSON
{
    "nome": "Bradesco visa",
    "bandeira": "VISA",
    "renda": 5000.0,
    "limiteBasico": 150.0
}
```
Atualizar um cartao

Method: PUT
```
http://localhost:8080/cartoes
```
Body (pretty)
```JSON
{
    "nome": "Bradesco visa",
    "bandeira": "VISA",
    "renda": 5000.0,
    "limiteBasico": 150.0
}
```
Deletar um cartao

Method: DELETE
```
http://localhost:8080/cartoes/1
```
