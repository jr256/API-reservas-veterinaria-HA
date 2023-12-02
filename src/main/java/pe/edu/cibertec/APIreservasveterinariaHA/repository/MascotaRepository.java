package pe.edu.cibertec.APIreservasveterinariaHA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.APIreservasveterinariaHA.model.bd.Mascota;
@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Integer> {

    @Query(value = "select m from Mascota as m where m.user.email=:email")
    Mascota findMascotaByEmail(@Param("email") String email);
}
