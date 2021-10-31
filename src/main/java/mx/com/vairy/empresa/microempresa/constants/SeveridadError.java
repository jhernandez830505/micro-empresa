
package mx.com.vairy.empresa.microempresa.constants;


import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumeracion que enlista las severidades de errores
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
public enum SeveridadError {
    /**
     * Severidad de error Alta
     */
    ALTA(1),

    /**
     * Severidad de error Media
     */
    MEDIA(2),

    /**
     * Severidad de error Baja
     */
    BAJA(3);

    /**
     * Numero que indica la severidad del error.
     */
    private int severidad;

    /**
     * Constructor de la enumeracion.
     *
     * @param severidad Numero que indica la severidad del error.
     */
    SeveridadError(int severidad) {
        this.severidad = severidad;
    }

    /**
     * Recupera el valor de {@code severidad}
     *
     * @return Valor de {@code severidad}
     */
    @JsonValue
    public int getSeveridad() {
        return severidad;
    }
}
