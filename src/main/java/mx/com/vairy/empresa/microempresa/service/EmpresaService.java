package mx.com.vairy.empresa.microempresa.service;

import mx.com.vairy.empresa.microempresa.model.Empresa;

import java.util.Optional;

/**
 * Nombre: EmpresaService
 * Descripcion: Interface que define la operacion encargada de obtener los registros del la empresa
 *
 * @author Javier Hernandez
 * Fecha: 07/02/2018 08:00 PM
 * @version 0.1
 */
public interface EmpresaService {

    Optional<Empresa> consultaEmpresa(Long idEmpresa);

    Empresa saveEmpresa(Empresa empresa);

}
