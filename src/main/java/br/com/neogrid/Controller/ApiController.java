package br.com.neogrid.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @RequestMapping(method = RequestMethod.GET, value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> api() {
        return new ResponseEntity<>("API ON!", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/servicos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> servicos() {
        String servicos = "API\n" +
                "\n" +
                "VERIFICA SE API ESTÁ ONLINE - GET - http://127.0.0.1:8080/api\n" +
                "\n" +
                "VERIFICA SERVIÇOS DA API - GET - http://127.0.0.1:8080/servicos\n" +
                "\n" +
                "_____________________________________\n" +
                "\n" +
                "MODELO\n" +
                "\n" +
                "HEADER - Content-Type:application/json\n" +
                "\n" +
                "SALVAR - POST - http://127.0.0.1:8080/modelo - JSON - { \"codigo\": \"ABC\", \"numeroRodas\": \"4\", \"cilindradas\": \"500\", \"nomeComercial\": \"Renaut\", \"numeroPassageiro\": \"2\", \"ano\": \"2019\", \"possuiEstepe\": \"true\" }\n" +
                "\n" +
                "ALTERAR - PUT - http://127.0.0.1:8080/modelo JSON - { \"codigo\": \"ABC\", \"numeroRodas\": \"3\", \"cilindradas\": \"1000\", \"nomeComercial\": \"Renaut\", \"numeroPassageiro\": \"2\", \"ano\": \"2019\", \"possuiEstepe\": \"true\" }\n" +
                "\n" +
                "EXCLUIR - DELETE - http://127.0.0.1:8080/modelo/ABC\n" +
                "\n" +
                "BUSCA 1 REGISTRO - GET - http://127.0.0.1:8080/modelo/ABC\n" +
                "\n" +
                "BUSCA TODOS - GET - http://127.0.0.1:8080/modelos\n" +
                "\n" +
                "_____________________________________\n" +
                "\n" +
                "CONTRUCAO\n" +
                "\n" +
                "HEADER - Content-Type:application/json\n" +
                "\n" +
                "SALVAR - POST - http://127.0.0.1:8080/contrucao - JSON - { \"codigo\": \"ABC\", \"corExterna\": \"PR\", \"pintura\": \"S\", \"revestimentoInterno\": \"T\" }\n" +
                "\n" +
                "BUSCA 1 REGISTRO - GET - http://127.0.0.1:8080/contrucao/5841eb49-ae7f-49ab-820c-6c793340d126\n";
        return new ResponseEntity<>(servicos, HttpStatus.OK);
    }
}