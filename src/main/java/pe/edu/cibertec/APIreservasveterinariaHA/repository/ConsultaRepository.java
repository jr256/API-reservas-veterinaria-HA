package pe.edu.cibertec.APIreservasveterinariaHA.repository;

import jdk.jfr.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.APIreservasveterinariaHA.model.bd.Consulta;

import java.util.List;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {

    @Query("SELECT consultas FROM Consulta consultas WHERE consultas.mascota.idmascota = :userId")
    List<Consulta> findByUsuarioId(@Param("userId") Long userId);

    @Query("SELECT cc FROM Consulta cc WHERE cc.sede.idsede = :idsede AND cc.especialidad.idespecialidad = :idespecialidad AND cc.fecha = :fecha AND cc.estadoservicio.idestadoservicio = 1")
    List<Consulta> buscarConsultasDisponibles(@Param("idsede") Integer idsede, @Param("idespecialidad")  Integer idespecialidad, @Param("fecha") String fecha);


    @Query("SELECT cc FROM Consulta cc WHERE cc.sede.idsede = :idsede AND cc.especialidad.idespecialidad = :idespecialidad AND cc.fecha = :fecha AND cc.estadoservicio.idestadoservicio = 2")
    List<Consulta> buscarConsultasReservadas(@Param("idsede") Integer idsede,@Param("idespecialidad")  Integer idespecialidad,@Param("fecha") String fecha);


   // quiero poner este native query SELECT * FROM consulta WHERE idmascota = 108 AND idestadoservicio = 2;
    @Query(value = "SELECT * FROM consulta WHERE idmascota = :idmascota AND idestadoservicio = 2", nativeQuery = true)
    List<Consulta> buscarConsultasReservadasPorMascota(@Param("idmascota") Integer idmascota);

}
