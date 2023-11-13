package pe.edu.cibertec.APIreservasveterinariaHA.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message){
        super(message);
    }
}
