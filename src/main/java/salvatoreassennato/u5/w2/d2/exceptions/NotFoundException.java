package salvatoreassennato.u5.w2.d2.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(int id) {
        super("Elemento con id " + id + " non trovato!");
    }
}
