package pe.edu.cibertec.APIreservasveterinariaHA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.cibertec.APIreservasveterinariaHA.model.bd.Usuario;

public interface UsuarioRepository  extends JpaRepository<Usuario, Integer> {
    public Usuario findByEmail(String email);

    @Query("SELECT u.tipousuario FROM Usuario u WHERE u.email = :email")
    String findTipoUsuarioByEmail(@Param("email") String email);

}
