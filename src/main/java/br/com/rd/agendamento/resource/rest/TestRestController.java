package br.com.rd.agendamento.resource.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.rd.agendamento.entity.TbCdRegional;
import br.com.rd.agendamento.service.CentroDistribuicaoService;


/**
 * Anotação @{@link RestController} transforma a classe em um controller rest
 */
@RestController
@RequestMapping(
        value = "testes",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
)
public class TestRestController {

	 @Autowired
	    private CentroDistribuicaoService service;
	 
    /**
     * Anotacao @{@link GetMapping} determina que o metodo de chamada para esse metodo é via get
     * @return List<Curso>
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TbCdRegional> listar() {
//       return "Teste12";
    	return service.findAll();
    }
}
