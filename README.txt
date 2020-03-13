
To access the fully Doc run the API and access /swagger-ui.html#/, but to access the swagger u need create a user and login.

U can use graphic interface, but still have some bugs.

=====================================================================

method POST at /api/usuarios/novo to creat a new User

	-----USER-----

GET /api/usuarios Listar usuarios.
DELETE /api/usuarios/{id} Deletar um usuário.
GET /api/usuarios/{ID} Buscar um usuario específico.

User :
    {
        "id": xx,
        "username": "user",
        "email": "xxxxxx@xxxxxxxx.com",
        "password": "password",
        "adm": true,
        "data": "xxxx-xx-xx"
    }

=====================================================================

	-----CASA DE SHOW-----


GET /api/casas Lista das casas.
POST /api/casas Salvar novas casas.
GET /api/casas/{ID} Buscar um casa específica.
PUT /api/casas/{ID} Atualizar um dado de uma casa.
DELETE /api/casas/{ID} Deletar um casa
GET /api/casas/asc Colocar em ordem alfabética ascendente.
GET /api/casas/desc Colocar em ordem alfabética descendente.
GET /api/casas/nome/{end} Buscar por nome.

Casa :
 {
        "id": xx,
        "nome": "name",
        "descr": "subtitle",
        "end": "adress",
        "dono": "dono",
        "preco": 1000,
        "capa": size
  }

=====================================================================
	-----Evento-----


GET /api/eventos Lista de eventos.
POST /api/eventos Salvar novos eventos.
GET /api/eventos/{codigo} Buscar um evento específico.
PUT /api/eventos/{codigo} Atualizar um dado do evento.
DELETE /api/eventos/{codigo} Deletar um evento
GET /api/eventos/capacidade/asc Buscar em ordem capacidade crescente.
GET /api/eventos/capacidade/desc Buscar em ordem capacidade decrescente.
GET /api/eventos/data/asc Buscar em ordem de data mais recente.
GET /api/eventos/data/desc Buscar em ordem de datas futuras.
GET /api/eventos/nome/asc Buscar em ordem alfabética ascendente
GET /api/eventos/nome/desc Buscar em ordem alfabética descendente.
GET /api/eventos/preco/asc Buscar em ordem preço crescente.
GET /api/eventos/preco/desc Buscar em ordem preço decrescente.

 Evento: {
        "descr": "dfs",
        "talento": "fgfgh",
        "organizador": "org",
        "local":  {
     	     "id": xx,
    	     "nome": "name",
   	     "descr": "subtitle",
   	     "end": "adress",
    	     "dono": "dono",
  	     "preco": 1000,
   	     "capa": size
 	},
        "preco": 233.0,
        "ingressos": 2444,
        "ingressosd": 2444,
        "data": "2020-03-26",
        "grat": true,
        "id": 1,
        "nome": "asdasd",
        "nomeevento": "asdasd"
    }


