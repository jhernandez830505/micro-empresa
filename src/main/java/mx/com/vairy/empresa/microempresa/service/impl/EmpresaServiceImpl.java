package mx.com.vairy.empresa.microempresa.service.impl;

import mx.com.vairy.empresa.microempresa.dao.EmpresaRepository;
import mx.com.vairy.empresa.microempresa.model.Empresa;
import mx.com.vairy.empresa.microempresa.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class EmpresaServiceImpl implements EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;


    @Override
    public Optional<Empresa> consultaEmpresa(Long idEmpresa) {
        return empresaRepository.findById(idEmpresa);
    }

    @Override
    public Empresa saveEmpresa(Empresa empresa) {
        Empresa e = (Empresa) empresaRepository.saveAndFlush(empresa);
        return e;

    }

}
