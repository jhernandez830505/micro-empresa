package mx.com.vairy.empresa.microempresa.constants;


import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumeración que enlista los tipo de errores
 *
 *
 */
public enum TipoError {
    /**
     * Error por parte del cliente
     */
    CLIENTE("Error del Cliente"),

    /**
     * Error por parte del servidor
     */
    SERVIDOR("Error del Servidor");

    /**
     * Cadena que indica el tipo de error
     */
    private String tipo;

    /**
     * Constructor
     *
     * @param tipo Cadena que indica el tipo de error
     */
    TipoError(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Recupera el valor de {@code tipo}
     *
     * @return Valor de {@code tipo}
     */
    @JsonValue
    public String getTipo() {
        return tipo;
    }
}