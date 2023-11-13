package pe.edu.cibertec.APIreservasveterinariaHA.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.APIreservasveterinariaHA.model.bd.Veterinario;
import pe.edu.cibertec.APIreservasveterinariaHA.service.VeterinarioService;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/veterinario")
public class VeterinarioController {

    private VeterinarioService veterinarioService;
    @GetMapping("")
    public ResponseEntity<List<Veterinario>> listarVeterinarios(){
        List<Veterinario> veterinarioList = new ArrayList<>();
        veterinarioService.listarVeterinarios()
                .forEach(veterinarioList::add);
        if(veterinarioList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(veterinarioList, HttpStatus.OK);
    }
    
}
