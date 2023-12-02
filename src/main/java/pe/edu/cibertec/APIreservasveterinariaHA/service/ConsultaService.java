package pe.edu.cibertec.APIreservasveterinariaHA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.APIreservasveterinariaHA.model.bd.Consulta;
import pe.edu.cibertec.APIreservasveterinariaHA.model.dto.ConsultaDto;
import pe.edu.cibertec.APIreservasveterinariaHA.repository.ConsultaRepository;

import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;



    public List<Consulta> listarConsultas(){
        return consultaRepository.findAll();
    }
    public List<Consulta> listarConsultasPorUsuario(Long idUsuario) {
        return consultaRepository.findByUsuarioId(idUsuario);
    }

    public List<Consulta> listarConsultasDisponibles(Integer idsede, Integer idespecialidad, String fecha) {
        return consultaRepository.buscarConsultasDisponibles(idsede, idespecialidad, fecha);
    }


    public List<Consulta> listarConsultasReservadas(Integer idsede, Integer idespecialidad, String fecha) {
        return consultaRepository.buscarConsultasReservadas(idsede, idespecialidad, fecha);
    }

    public Consulta reservarConsulta(Consulta consulta){
        return consultaRepository.save(consulta);

    }



    public List<Consulta> listarConsultasPorMascota(Integer idmascota) {
        return consultaRepository.buscarConsultasReservadasPorMascota(idmascota);
    }

}
