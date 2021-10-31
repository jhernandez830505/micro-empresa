package mx.com.vairy.empresa.microempresa.advice;

import mx.com.vairy.empresa.microempresa.constants.CodigoError;
import mx.com.vairy.empresa.microempresa.dto.ErrorResponse;
import mx.com.vairy.empresa.microempresa.dto.Response;
import mx.com.vairy.empresa.microempresa.exception.EmpresaNotFoundException;
import mx.com.vairy.empresa.microempresa.util.CodigoErrorResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


@RestControllerAdvice
public class ControllerAdvice {


    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerAdvice.class);

    /**
     *  Fabrica de Beans de spring
     */
    @Autowired
    private BeanFactory beanFactory;

    /**
     * Constructor de la clase
     */
    public ControllerAdvice(){
        super();
    }

    /**
     * Se encarga de manejar las excepciones que se espera puedan ocurrir
     *
     * @param e Excepcion producida
     *
     * @return Objeto con información del error
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({

            EmpresaNotFoundException.class,

    })
    public Response manejarExcepcionNotFound(RuntimeException e) {
        return resolverCodigo(e, HttpStatus.NOT_FOUND);
    }

    /**
     * Se encarga de manejar las excepciones que se espera puedan ocurrir
     * @see IllegalArgumentException
     * @see MethodArgumentTypeMismatchException
     *
     * @param e Excepcion producida
     *
     * @return Objeto con información del error
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
            IllegalArgumentException.class,
            MethodArgumentTypeMismatchException.class,
            HttpMessageNotReadableException.class,
            UnsatisfiedServletRequestParameterException.class
    })
    public Response manejarExcepcionBadRequest(Exception e) {
        return resolverCodigo(e, HttpStatus.BAD_REQUEST);
    }

    /**
     * Se encarga de manejar las excepciones de validacion de beans
     * @see javax.validation.constraints
     *
     * @param e Excepción manejada
     *
     * @return Objeto con información del error
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response manejarMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        Response response = resolverCodigo(e, HttpStatus.BAD_REQUEST);
        StringBuilder errorMsj = new StringBuilder();

        e.getBindingResult().getAllErrors().forEach(oe -> {
            errorMsj.append(oe.getDefaultMessage());
            errorMsj.append(String.format("%n"));
        });

        response.setMessage(errorMsj.toString());

        return response;
    }

    /**
     * Se encarga de manejar las excepción que son inesperadas
     *
     * @param e Excepción manejada
     *
     * @return Objeto con información del error
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Response manejarExcepcion(Exception e) {
        LOGGER.error("Ocurrio un error inesperado", e);
        ErrorResponse errorResponse = new ErrorResponse(CodigoError.NMP_AUD_9999);

        return beanFactory.getBean(Response.class, HttpStatus.INTERNAL_SERVER_ERROR.toString(), e.getMessage(), errorResponse);
    }

    /**
     * Decide el codigo de error según la excepción
     *
     * @param e Excepción que ocurrio
     *
     * @return Respuesta con el codigo correpondiente
     */
    private Response resolverCodigo(Exception e, HttpStatus status) {
        LOGGER.warn("Ocurrio el siguiente error", e);
        ErrorResponse errorResponse = new ErrorResponse(CodigoErrorResolver.get(e.getClass()));

        return beanFactory.getBean(Response.class, status.toString(), e.getMessage(), errorResponse);
    }
}
