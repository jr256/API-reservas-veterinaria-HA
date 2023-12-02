package pe.edu.cibertec.APIreservasveterinariaHA.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.APIreservasveterinariaHA.model.bd.Consulta;
import pe.edu.cibertec.APIreservasveterinariaHA.model.bd.Recojo;
import pe.edu.cibertec.APIreservasveterinariaHA.model.dto.ConsultaDto;
import pe.edu.cibertec.APIreservasveterinariaHA.model.dto.DtoEntity;
import pe.edu.cibertec.APIreservasveterinariaHA.model.dto.RecojoDto;
import pe.edu.cibertec.APIreservasveterinariaHA.service.ConsultaService;
import pe.edu.cibertec.APIreservasveterinariaHA.service.RecojoService;
import pe.edu.cibertec.APIreservasveterinariaHA.util.DtoUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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


/*
    @GetMapping("/reservadas")
    @ResponseBody
    public ResponseEntity<List<DtoEntity>> listasRecojosDto(
            RequestParam("fecha") String fecha
    ){
        List<DtoEntity> recojoList = new ArrayList<>();
        recojoList = recojoService.buscarRecojosReservados(fecha)
                .stream()
                .map(recojo -> new DtoUtil().convertirADto(recojo, new RecojoDto()))
                .collect(Collectors.toList());
        if(recojoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(recojoList, HttpStatus.OK);
    }*/


    @GetMapping("/reservados")
    @ResponseBody
    public ResponseEntity<List<DtoEntity>> listarRecojosReservadasDto(

            @RequestParam("fecha") String fecha
    ) {
        List<DtoEntity> recojoList = new ArrayList<>();
        recojoList = recojoService.listarRecojosReservados(fecha)
                .stream()
                .map(recojo -> new DtoUtil().convertirADto(recojo, new RecojoDto()))
                .collect(Collectors.toList());
        if(recojoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(recojoList, HttpStatus.OK);
    }

    @GetMapping("/recojoMascota")
    @ResponseBody
    public ResponseEntity<List<DtoEntity>> listarRecojosPorMascota(
          @RequestParam("idmascota") Integer idmascota
    ){
        List<DtoEntity> recojoList = new ArrayList<>();
        recojoList = recojoService.buscarRecojosPorMascota(idmascota)
                .stream()
                .map(recojo -> new DtoUtil().convertirADto(recojo, new RecojoDto()))
                .collect(Collectors.toList());
        if(recojoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(recojoList, HttpStatus.OK);
    }


}
