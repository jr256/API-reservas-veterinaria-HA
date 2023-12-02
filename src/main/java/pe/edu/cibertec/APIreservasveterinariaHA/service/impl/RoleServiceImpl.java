package pe.edu.cibertec.APIreservasveterinariaHA.service.impl;

import pe.edu.cibertec.APIreservasveterinariaHA.repository.RoleRepository;
import pe.edu.cibertec.APIreservasveterinariaHA.model.bd.Role;
import pe.edu.cibertec.APIreservasveterinariaHA.service.RoleService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleDao;

    public RoleServiceImpl(RoleRepository roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Role createRole(String roleName) {
        return roleDao.save(new Role(roleName));
    }
}
