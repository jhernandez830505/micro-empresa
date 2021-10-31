package mx.com.vairy.empresa.microempresa.dto;

import mx.com.vairy.empresa.microempresa.constants.CodigoError;
import mx.com.vairy.empresa.microempresa.constants.SeveridadError;
import mx.com.vairy.empresa.microempresa.constants.TipoError;

/**
 * Representa la repuesta cuando ocurre algún error al procesar la petición
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
public class ErrorResponse {
    /**
     * Código del error.
     */
    private String codigoError;

    /**
     * Descripción del error.
     */
    private String descripcionError;

    /**
     * Tipo de error.
     */
    private TipoError tipoError;

    /**
     * Severidad del error.
     */
    private SeveridadError severidad;

    /**
     * Constructor de la clase.
     *
     * @param codigoError Código del error.
     * @param descripcionError Descripción del error.
     * @param tipoError Tipo de error.
     * @param severidad Severidad del error.
     */
    public ErrorResponse(String codigoError, String descripcionError, TipoError tipoError, SeveridadError severidad) {
        this.codigoError = codigoError;
        this.descripcionError = descripcionError;
        this.tipoError = tipoError;
        this.severidad = severidad;
    }

    /**
     * Constructor de la clase
     *
     * @param codigoError Enumeración con el codigo de error
     */
    public ErrorResponse(CodigoError codigoError) {
        this.codigoError = codigoError.getCodigo();
        this.descripcionError = codigoError.getDescripcion();
        this.tipoError = codigoError.getTipoError();
        this.severidad = codigoError.getSeveridadError();
    }

    /**
     * Recupera el valor de {@code codigoError}
     * @return Valor de {@code codigoError}
     */
    public String getCodigoError() {
        return codigoError;
    }

    /**
     * Recupera el valor de {@code descripcionError}
     * @return Valor de {@code descripcionError}
     */
    public String getDescripcionError() {
        return descripcionError;
    }

    /**
     * Recupera el valor de {@code tipoError}
     * @return Valor de {@code tipoError}
     */
    public TipoError getTipoError() {
        return tipoError;
    }

    /**
     * Recupera el valor de {@code severidad}
     * @return Valor de {@code severidad}
     */
    public SeveridadError getSeveridad() {
        return severidad;
    }

}