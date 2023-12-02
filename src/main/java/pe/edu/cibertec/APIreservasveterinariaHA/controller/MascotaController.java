package pe.edu.cibertec.APIreservasveterinariaHA.controller;

import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.APIreservasveterinariaHA.model.bd.User;
import pe.edu.cibertec.APIreservasveterinariaHA.model.dto.MascotaDto;
import pe.edu.cibertec.APIreservasveterinariaHA.service.MascotaService;
import pe.edu.cibertec.APIreservasveterinariaHA.service.UserService;

import java.util.List;


@RestController
@RequestMapping(path = "mascota")
@CrossOrigin(origins = "http://localhost:4200")
public class MascotaController {

    private MascotaService mascotaService;
    private UserService userService;

    public MascotaController(MascotaService mascotaService, UserService userService) {
        this.mascotaService = mascotaService;
        this.userService = userService;
    }

    @PostMapping("/save")
    @PreAuthorize("hasAuthority('Admin')")
    public MascotaDto saveMascota(@RequestBody MascotaDto mascotaDTO) {
        User user = userService.loadUserByEmail(mascotaDTO.getUser().getEmail());
        if (user != null) throw new RuntimeException("Email Already Exist");
        return mascotaService.createMascota(mascotaDTO);
    }



    @GetMapping("/find")
    public MascotaDto loadMascotaByEmail(@RequestParam(name = "email", defaultValue = "") String email) {
        return mascotaService.loadMascotaByEmail(email);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('Admin')")
    public Page<MascotaDto> searchMascotas(@RequestParam(name = "keyword", defaultValue = "") String keyword,
                                           @RequestParam(name = "page", defaultValue = "0") int page,
                                           @RequestParam(name = "size", defaultValue = "5") int size) {
        return mascotaService.loadMascotasByName(keyword, page, size);
    }


}
