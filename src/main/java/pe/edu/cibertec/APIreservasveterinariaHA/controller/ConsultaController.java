package pe.edu.cibertec.APIreservasveterinariaHA.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.APIreservasveterinariaHA.model.bd.Consulta;
import pe.edu.cibertec.APIreservasveterinariaHA.model.bd.Veterinario;
import pe.edu.cibertec.APIreservasveterinariaHA.service.ConsultaService;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/consulta")
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


    @GetMapping("/reservadas")
    @ResponseBody
    public ResponseEntity<List<Consulta>> listarConsultasReservadas(
            @RequestParam("idsede") Integer idsede,
            @RequestParam("idespecialidad") Integer idespecialidad,
            @RequestParam("fecha") String fecha
    ) {
        List<Consulta> consultaList = new ArrayList<>();
        consultaService.listarConsultasReservadas(idsede, idespecialidad, fecha)
                .forEach(consultaList::add);

        if(consultaList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(consultaList, HttpStatus.OK);
    }




}
