package pe.edu.cibertec.APIreservasveterinariaHA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.APIreservasveterinariaHA.model.bd.DistritoCobertura;


@Repository
public interface DistritoCoberturaRepository extends JpaRepository<DistritoCobertura, Integer> {
}
