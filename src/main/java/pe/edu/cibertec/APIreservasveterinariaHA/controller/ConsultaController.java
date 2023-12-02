package pe.edu.cibertec.APIreservasveterinariaHA.controller;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.APIreservasveterinariaHA.model.bd.Consulta;
import pe.edu.cibertec.APIreservasveterinariaHA.model.bd.Veterinario;
import pe.edu.cibertec.APIreservasveterinariaHA.model.dto.ConsultaDto;
import pe.edu.cibertec.APIreservasveterinariaHA.model.dto.DtoEntity;
import pe.edu.cibertec.APIreservasveterinariaHA.model.dto.RecojoDto;
import pe.edu.cibertec.APIreservasveterinariaHA.service.ConsultaService;
import pe.edu.cibertec.APIreservasveterinariaHA.util.DtoUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping(path = "consulta")
@CrossOrigin(origins = "http://localhost:4200")
public class ConsultaController {

    private ConsultaService consultaService;



    @GetMapping("/disponibles")
    @ResponseBody
    public ResponseEntity<List<Consulta>> listarConsultasDisponibles(
            @RequestParam("idsede") Integer idsede,
            @RequestParam("idespecialidad") Integer idespecialidad,
            @RequestParam("fecha") String fecha
    ) {
        List<Consulta> consultaList = new ArrayList<>();
        consultaService.listarConsultasDisponibles(idsede, idespecialidad, fecha)
                .forEach(consultaList::add);

        if(consultaList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(consultaList, HttpStatus.OK);
    }




    @PutMapping("/reservar")
    public ResponseEntity<Consulta> reservarConsulta(
            @RequestBody Consulta consulta
    ){
        return new ResponseEntity<>(
                consultaService.reservarConsulta(consulta), HttpStatus.OK
        );
    }






    @GetMapping("/consultaMascota")
    @ResponseBody
    //implementemos con dto
    public ResponseEntity<List<DtoEntity>> listarConsultasPorMascota(
            @RequestParam("idmascota") Integer idmascota
    ){
        List<DtoEntity> consultaList = new ArrayList<>();
        consultaList = consultaService.listarConsultasPorMascota(idmascota)
                .stream()
                .map(consulta -> new DtoUtil().convertirADto(consulta, new ConsultaDto()))
                .collect(Collectors.toList());
        if(consultaList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(consultaList, HttpStatus.OK);
    }




    @GetMapping("/reservadas")
    @ResponseBody
    public ResponseEntity<List<DtoEntity>> listarConsultasReservadasDto(
            @RequestParam("idsede") Integer idsede,
            @RequestParam("idespecialidad") Integer idespecialidad,
            @RequestParam("fecha") String fecha
    ) {
        List<DtoEntity> consultaList = new ArrayList<>();
        consultaList = consultaService.listarConsultasReservadas(idsede, idespecialidad, fecha)
                .stream()
                .map(consulta -> new DtoUtil().convertirADto(consulta, new ConsultaDto()))
                .collect(Collectors.toList());
        if(consultaList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(consultaList, HttpStatus.OK);
    }

}
