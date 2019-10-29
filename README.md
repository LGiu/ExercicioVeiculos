O desafio

1) Crie um conjunto de serviços REST para operações de manutenção em um cadastro de modelos de veículos automotores.

Operações:

- Inserção de um novo registro;

- Alteração dos dados de um registro;

- Exclusão de um registro;

- Consulta de um único registro pela chave única;

- Listagem dos registros existentes.

Dados:

- Chave primária artificial (campo interno, não deve ser visível através dos serviços REST);

- Código do modelo (deve ser único);

- Número de rodas (2, 3 ou 4 rodas);

- Cilindradas do motor (de 125cc a 2000cc);

- Nome comercial;

- Número de passageiros (0 a 4);

- Ano do Modelo (ano corrente);

- Se possui ou não estepe;

2) Crie um serviço para construção de um veículo. Esse serviço deve APENAS receber os dados listados abaixo e disparar um processo assíncrono de construção retornando um identificador para posterior consulta do status.

Dados recebidos:

- Código do modelo

- Cor externa (preto, branco, prata ou vermelho)

- Se pintura metálica ou sólida

- Revestimento interno (tecido ou couro)

Processo de construção deve ser implementado como uma linha de montagem (pipeline) com 3 etapas distintas:

- Etapa 1: criação do veículo com os dados provenientes do modelo (adicionar o ano de construção);

- Etapa 2: pintura externa;

- Etapa 3: revestimento interno;

3) Crie um serviço que irá receber o identificador retornado pelo serviço de construção e que irá retornar os dados do veículo concluído ou o motivo que tenha impedido a finalização do processo de construção.

4) Crie um serviço que possa ser utilizado para indicar que a aplicação está no ar e funcionando normalmente;

5) Crie um serviço que possa ser utilizado para consultar todos os serviços disponibilizados pela aplicação;
_____________________________________


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

SALVAR - POST - http://127.0.0.1:8080/contrucao - JSON - { "codigo": "ABC", "corExterna": "PR", "pintura": "S", "revestimentoInterno": "T" }

BUSCA 1 REGISTRO - GET - http://127.0.0.1:8080/contrucao/5841eb49-ae7f-49ab-820c-6c793340d126
