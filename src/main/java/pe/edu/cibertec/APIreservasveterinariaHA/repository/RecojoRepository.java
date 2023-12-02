package pe.edu.cibertec.APIreservasveterinariaHA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.APIreservasveterinariaHA.model.bd.Consulta;
import pe.edu.cibertec.APIreservasveterinariaHA.model.bd.Recojo;

import java.util.List;

@Repository
public interface RecojoRepository extends JpaRepository<Recojo, Integer> {


    @Query("SELECT recojo FROM Recojo recojo WHERE recojo.mascota.idmascota = :idmascota AND recojo.estadoservicio.idestadoservicio = 2")
    List<Recojo> buscarRecojosPorMascota(@Param("idmascota") Integer idmascota);



    @Query("SELECT recojo FROM Recojo recojo WHERE recojo.estadoservicio.idestadoservicio = 2")
    List<Recojo> listarRecojos();

    @Query("SELECT recojo FROM Recojo recojo WHERE recojo.fecha = :fecha AND recojo.estadoservicio.idestadoservicio = 2")
    List<Recojo> buscarRecojosReservados( @Param("fecha") String fecha);




}
