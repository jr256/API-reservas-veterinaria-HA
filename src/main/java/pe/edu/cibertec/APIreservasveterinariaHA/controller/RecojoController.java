package pe.edu.cibertec.APIreservasveterinariaHA.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.APIreservasveterinariaHA.model.bd.Consulta;
import pe.edu.cibertec.APIreservasveterinariaHA.model.bd.Recojo;
import pe.edu.cibertec.APIreservasveterinariaHA.model.dto.RecojoDto;
import pe.edu.cibertec.APIreservasveterinariaHA.service.ConsultaService;
import pe.edu.cibertec.APIreservasveterinariaHA.service.RecojoService;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "recojo")
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



    @GetMapping("/reservadas")
    @ResponseBody
    public ResponseEntity<List<Recojo>> listarRecojosReservadas(

    ) {
        List<Recojo> recojoList = new ArrayList<>();
        recojoService.listarRecojos()
                .forEach(recojoList::add);

        if(recojoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(recojoList, HttpStatus.OK);
    }

}
