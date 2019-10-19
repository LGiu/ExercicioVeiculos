package br.com.neogrid.Controller;

import br.com.neogrid.Model.Modelo;
import br.com.neogrid.Service.ModeloService;
import br.com.neogrid.Util.Retorno;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiController {

    @RequestMapping(method = RequestMethod.GET, value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> api() {
        return new ResponseEntity<>("API ON!", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/servicos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> servicos() {
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}