package mx.com.vairy.empresa.microempresa.controller;

import io.swagger.annotations.*;
import mx.com.vairy.empresa.microempresa.dto.Response;
import mx.com.vairy.empresa.microempresa.exception.EmpresaNotFoundException;
import mx.com.vairy.empresa.microempresa.model.Empresa;
import mx.com.vairy.empresa.microempresa.service.EmpresaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vairy/v1")
@Api(value = "Servicio que permite realizar acciones a nivel de empresas.", produces = MediaType.APPLICATION_JSON_VALUE,  protocols = "http", tags = {"Empresas"})
public class EmpresaController {


    @Autowired
    private EmpresaService empresaService;

    /**
     * Mensaje que sera enviado si se recuperaron los registros correctamente
     */
    private static final String MSG_SUCCESS = "Registros recuperados correctamente.";


    /**
     * Instancia que registra los eventos en la bitacora
     */
    private final Logger log = LoggerFactory.getLogger(EmpresaController.class);


    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "empresas/{idEmpresa}", produces = MediaType.APPLICATION_JSON_VALUE, name = "Empresas")
    @ApiOperation(httpMethod = "GET", value = "Regresa la informacion asociados a una empresa.")
    @ApiResponses({ @ApiResponse(code = 200, response = Response.class, message = "Registros obtenidos"),
            @ApiResponse(code = 400, response = Response.class, message = "El parámetro especificado es invalido."),
            @ApiResponse(code = 404, response = Response.class, message = "No existen registros para el catalogo especificado"),
            @ApiResponse(code = 500, response = Response.class, message = "Error no esperado") })
    public Response get(@PathVariable(value = "idEmpresa", required = true) long idEmpresa){

        log.debug("Entrando a operacion de servicio CatalogoController.get()...");

        Empresa empresa = empresaService.consultaEmpresa(idEmpresa).orElseThrow(()-> new EmpresaNotFoundException(String.valueOf(idEmpresa)));
        Response out = new Response();
        out.setCode(String.valueOf(HttpStatus.OK));
        out.setMessage(MSG_SUCCESS);
        out.setObject(empresa);
        out.setTotal(1L);

        return out;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "empresas", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(httpMethod = "POST", value = "Actualiza la informacion de la empresa.")
    @ApiResponses({ @ApiResponse(code = 200, response = Response.class, message = "Registros obtenidos"),
            @ApiResponse(code = 400, response = Response.class, message = "El parámetro especificado es invalido."),
            @ApiResponse(code = 404, response = Response.class, message = "No existen registros para el catalogo especificado"),
            @ApiResponse(code = 500, response = Response.class, message = "Error no esperado") })
    public Response post(@RequestBody Empresa emp){
        log.debug("Entrando al servicio para actualizar una empresa...");
        Assert.notNull(emp, "Argumentos enviados no validos");
        Empresa empresa = empresaService.saveEmpresa(emp);
        Response out = new Response();
        out.setCode(String.valueOf(HttpStatus.OK));
        out.setMessage(MSG_SUCCESS);
        out.setObject(empresa);
        out.setTotal(1L);
        return out;
    }

}
