package br.com.neogrid.Controller;

import br.com.neogrid.Model.Modelo;
import br.com.neogrid.Service.ModeloService;
import br.com.neogrid.Util.Retorno;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class ModeloController {

    private final ModeloService modeloService;

    public ModeloController(ModeloService modeloService) {
        this.modeloService = modeloService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/modelo/{codigo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Modelo> buscaModelo(@PathVariable String codigo) {
        return new ResponseEntity<>(modeloService.buscaPorCodigo(codigo), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/modelos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Modelo>> buscaModelos() {
        return new ResponseEntity<>(modeloService.buscaLista(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/modelo", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Retorno> salvaModelo(@RequestBody Modelo modelo) {
        return new ResponseEntity<>(modeloService.salva(modelo), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/modelo", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Retorno> alteraModelo(@RequestBody Modelo modelo) {
        return new ResponseEntity<>(modeloService.altera(modelo), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/modelo/{codigo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Retorno> excluiModelo(@PathVariable String codigo) {
        return new ResponseEntity<>(modeloService.exclui(codigo), HttpStatus.OK);

    }
}