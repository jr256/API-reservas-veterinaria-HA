package pe.edu.cibertec.APIreservasveterinariaHA.model.dto;

public class MascotaDto {

    private Integer idmascota;
    private String nombrepropietario;
    private String nombremascota;
    private UserDto user;

    public Integer getIdmascota() {
        return idmascota;
    }

    public void setIdmascota(Integer idmascota) {
        this.idmascota = idmascota;
    }

    public String getNombrepropietario() {
        return nombrepropietario;
    }

    public void setNombrepropietario(String nombrepropietario) {
        this.nombrepropietario = nombrepropietario;
    }

    public String getNombremascota() {
        return nombremascota;
    }

    public void setNombremascota(String nombremascota) {
        this.nombremascota = nombremascota;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }


}
