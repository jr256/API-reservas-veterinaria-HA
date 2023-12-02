package pe.edu.cibertec.APIreservasveterinariaHA.service;

import pe.edu.cibertec.APIreservasveterinariaHA.model.bd.User;

public interface UserService {

    User loadUserByEmail(String email);

    User createUser(String email, String password);

    void assignRoleToUser(String email, String roleName);
}
