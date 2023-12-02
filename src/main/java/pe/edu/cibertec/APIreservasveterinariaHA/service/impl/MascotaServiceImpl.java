package pe.edu.cibertec.APIreservasveterinariaHA.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.cibertec.APIreservasveterinariaHA.mapper.MascotaMapper;
import pe.edu.cibertec.APIreservasveterinariaHA.model.bd.Mascota;
import pe.edu.cibertec.APIreservasveterinariaHA.model.bd.User;
import pe.edu.cibertec.APIreservasveterinariaHA.model.dto.MascotaDto;
import pe.edu.cibertec.APIreservasveterinariaHA.repository.MascotaRepository;
import pe.edu.cibertec.APIreservasveterinariaHA.service.MascotaService;
import pe.edu.cibertec.APIreservasveterinariaHA.service.UserService;

@Service
@Transactional
public class MascotaServiceImpl implements MascotaService {

    private MascotaRepository mascotaRepository;

    private MascotaMapper mascotaMapper;

    private UserService userService;

    public MascotaServiceImpl(MascotaRepository mascotarepository, MascotaMapper mascotaMapper, UserService userService) {
        this.mascotaRepository = mascotarepository;
        this.mascotaMapper = mascotaMapper;
        this.userService = userService;
    }


    @Override
    public Mascota loadMascotaById(Integer idmascota) {
        return mascotaRepository.findById(idmascota).orElseThrow(() -> new EntityNotFoundException("Mascota no encontrada"));
    }

    @Override
    public MascotaDto loadMascotaByEmail(String email) {
        return mascotaMapper.fromMascota(mascotaRepository.findMascotaByEmail(email));
    }

    @Override
    public MascotaDto createMascota(MascotaDto mascotaDto) {
        User user = userService.createUser(mascotaDto.getUser().getEmail(), mascotaDto.getUser().getPassword());
        userService.assignRoleToUser(user.getEmail(), "Customer");
        Mascota mascota = mascotaMapper.fromMascotaDTO(mascotaDto);
        mascota.setUser(user);
        Mascota savedMascota = mascotaRepository.save(mascota);
        return mascotaMapper.fromMascota(savedMascota);

    }

    @Override
    public MascotaDto updateMascota(MascotaDto mascotaDto) {
        return null;
    }

    @Override
    public Page<MascotaDto> loadMascotasByName(String name, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Mascota> mascotasPage = mascotaRepository.findMascotasByName(name, pageRequest);
        return new PageImpl<>(mascotasPage.getContent().stream().map(mascota -> mascotaMapper.fromMascota(mascota)).collect(java.util.stream.Collectors.toList()), pageRequest, mascotasPage.getTotalElements());
    }


}
