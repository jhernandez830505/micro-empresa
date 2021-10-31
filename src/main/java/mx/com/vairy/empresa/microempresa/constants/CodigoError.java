

/*
 *
 *
 *
 * <p><a href="https://wiki.quarksoft.net/display/Auditoria/Home">Auditoria - Backend</a></p>
 *
 * <p><b><a href="https://quarksoft.net/">Quarksoft S.A.P.I. de C.V. Copyrigth © 2018</a></b></p>
 *
 *
 */


package mx.com.vairy.empresa.microempresa.constants;


/**
 *
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
public enum CodigoError {
    NMP_AUD_0001("Los parametros no son correctos", TipoError.CLIENTE, SeveridadError.BAJA),
    NMP_AUD_0002("La auditoría que desea consultar no existe", TipoError.CLIENTE, SeveridadError.MEDIA),
    NMP_AUD_0003("La partida que desea consultar no existe, o no pertenece a la auditoria indicada",
            TipoError.CLIENTE, SeveridadError.MEDIA),
    NMP_AUD_0004("El resultado que desea consultar no existe", TipoError.CLIENTE, SeveridadError.MEDIA),
    NMP_AUD_0005("No existen registros para el catalogo especificado", TipoError.CLIENTE, SeveridadError.MEDIA),
    NMP_AUD_0006("Cuerpo de la peticion vacio o ocurrio un error al leerla",
            TipoError.CLIENTE, SeveridadError.MEDIA),
    NMP_AUD_0007("Los valores de las propiedades del cuerpo de la petición no son correctos",
            TipoError.CLIENTE, SeveridadError.MEDIA),
    NMP_AUD_0008("Los parametros de la peticion no son correctos",
            TipoError.CLIENTE, SeveridadError.MEDIA),
    NMP_AUD_SEG_0001("Los parametros no son correctos", TipoError.CLIENTE, SeveridadError.BAJA),
    NMP_AUD_SEG_0002("La sesion que desea consultar no existe o se encuentra inactiva", TipoError.CLIENTE, SeveridadError.MEDIA),
    NMP_AUD_SEG_0003("Error de autorizacion en los servicios de OAuth", TipoError.CLIENTE, SeveridadError.MEDIA),
    NMP_AUD_SEG_0004("Error inesperado en servicios de OAuth", TipoError.CLIENTE, SeveridadError.MEDIA),
    NMP_AUD_9999("Error no esperado",
            TipoError.SERVIDOR, SeveridadError.ALTA);

    /**
     * Descripción del error
     */
    private String descripcion;

    /**
     * Tipo de error
     */
    private TipoError tipoError;

    /**
     * Severidad del error
     */
    private SeveridadError severidadError;

    /**
     * Constructor
     *
     * @param descripcion Descripción del error
     * @param tipoError Tipo de error
     * @param severidadError Severidad del error
     */
    CodigoError(String descripcion, TipoError tipoError, SeveridadError severidadError) {
        this.descripcion = descripcion;
        this.tipoError = tipoError;
        this.severidadError = severidadError;
    }

    /**
     * Recupera el valor de {@code codigo}
     *
     * @return Valor de {@code codigo}
     */
    public String getCodigo() {
        return name();
    }

    /**
     * Recupera el valor de {@code descripcion}
     *
     * @return Valor de {@code descripcion}
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Recupera el valor de {@code tipoError}
     *
     * @return Valor de {@code tipoError}
     */
    public TipoError getTipoError() {
        return tipoError;
    }

    /**
     * Recupera el valor de {@code severidadError}
     *
     * @return Valor de {@code severidadError}
     */
    public SeveridadError getSeveridadError() {
        return severidadError;
    }
}
