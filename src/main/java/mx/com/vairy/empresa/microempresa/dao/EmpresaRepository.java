package mx.com.vairy.empresa.microempresa.dao;

import mx.com.vairy.empresa.microempresa.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    Empresa findEmpresaByEmail(String email);

}

