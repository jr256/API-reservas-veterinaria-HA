package pe.edu.cibertec.APIreservasveterinariaHA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.APIreservasveterinariaHA.model.bd.Sede;
import pe.edu.cibertec.APIreservasveterinariaHA.model.bd.Servicio;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Integer> {
}
