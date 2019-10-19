
_________________________________________________________________________________________

O sistema foi desenvolvido em Java 8, utilizando o framework Spring Boot. A lingugem de banco utilizada foi o Mysql.

Configurações iniciais do sistema:

Deve-se possui o Mysql Server instalado;

Feito isso deve-se startar o projeto pra a criação das tabelas e colunas.

Obs: A o usuário e senha padrões do banco são 'root' e 'root' respectivamente. Caso já possu o Mysql instalado com outro usuário e senha deve-se altera-los no arquivo application.properties do projeto.

Após é possível utilizar os End-Point abaixo:
_____________________________________

API

VERIFICA SE API ESTÁ ONLINE - GET - http://127.0.0.1:8080/api

VERIFICA SERVIÇOS DA API - GET - http://127.0.0.1:8080/servicos

_____________________________________

MODELO

HEADER - Content-Type:application/json

SALVAR - POST - http://127.0.0.1:8080/modelo - JSON - { "codigo": "ABC", "numeroRodas": "4", "cilindradas": "500", "nomeComercial": "Renaut", "numeroPassageiro": "2", "ano": "2019", "possuiEstepe": "true" }

ALTERAR - PUT - http://127.0.0.1:8080/modelo JSON - { "codigo": "ABC", "numeroRodas": "3", "cilindradas": "1000", "nomeComercial": "Renaut", "numeroPassageiro": "2", "ano": "2019", "possuiEstepe": "true" }

EXCLUIR - DELETE - http://127.0.0.1:8080/modelo/ABC

BUSCA 1 REGISTRO - GET - http://127.0.0.1:8080/modelo/ABC

BUSCA TODOS - GET - http://127.0.0.1:8080/modelos

_____________________________________

CONTRUCAO

HEADER - Content-Type:application/json

SALVAR - POST - http://127.0.0.1:8080/contrucao - JSON - { "codigo": "ABdC", "corExterna": "PR", "pintura": "S", "revestimentoInterno": "T" }

BUSCA 1 REGISTRO - GET - http://127.0.0.1:8080/contrucao/5841eb49-ae7f-49ab-820c-6c793340d126
