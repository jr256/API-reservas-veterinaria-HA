package pe.edu.cibertec.APIreservasveterinariaHA.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.APIreservasveterinariaHA.model.bd.Especialidad;
import pe.edu.cibertec.APIreservasveterinariaHA.service.EspecialidadService;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "especialidad")
@CrossOrigin(origins = "http://localhost:4200")
public class EspecialidadController {

    private EspecialidadService especialidadService;
    @GetMapping("")
    public ResponseEntity<List<Especialidad>> listarEspecialidades(){
        List<Especialidad> especialidadList = new ArrayList<>();
        especialidadService.listarEspecialidades()
                .forEach(especialidadList::add);
        if(especialidadList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(especialidadList, HttpStatus.OK);
    }

}
