package pe.edu.cibertec.APIreservasveterinariaHA.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.APIreservasveterinariaHA.model.bd.Consulta;
import pe.edu.cibertec.APIreservasveterinariaHA.model.bd.Recojo;
import pe.edu.cibertec.APIreservasveterinariaHA.service.ConsultaService;
import pe.edu.cibertec.APIreservasveterinariaHA.service.RecojoService;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/recojo")
@CrossOrigin(origins = "http://localhost:4200")
public class RecojoController {

    private RecojoService recojoService;
    @PostMapping("/programar")
    public ResponseEntity<Recojo> programarRecojo(
            @RequestBody Recojo recojo
    ){
        return new ResponseEntity<>(
                recojoService.programarRecojo(recojo), HttpStatus.OK
        );
    }


}
