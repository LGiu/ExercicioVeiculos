package br.com.neogrid.Controller;

import br.com.neogrid.Model.Construcao;
import br.com.neogrid.Service.ContrucaoService;
import br.com.neogrid.Util.Retorno;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContrucaoController {

    private final ContrucaoService contrucaoService;

    public ContrucaoController(ContrucaoService contrucaoService) {
        this.contrucaoService = contrucaoService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/contrucao/{codigo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Construcao> buscaContrucao(@PathVariable String codigo) {
        return new ResponseEntity<>(contrucaoService.buscaPorCodigo(codigo), HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/contrucao", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Retorno> salvaContrucao(@RequestBody Construcao construcao) {
        return new ResponseEntity<>(contrucaoService.salva(construcao), HttpStatus.OK);
    }
}