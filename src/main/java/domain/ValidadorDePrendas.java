package domain;

import java.util.ArrayList;
import java.util.List;

public class ValidadorDePrendas {
    private List<Validacion> validaciones = new ArrayList<>();

    private static ValidadorDePrendas instance = null;
    ValidadorDePrendas() {
        // Asi nadie puede llamar al constructor de esta clase
    }

    public static ValidadorDePrendas getInstance() {
        if(instance == null)
            instance = new ValidadorDePrendas();
        return instance;
    }

    public void agregarValidacion(Validacion validacion) {
        validaciones.add(validacion);
    }

    public void quitarValidacion(Validacion validacion) {
        validaciones.remove(validacion);
    }

    public void validarPrenda(Prenda prenda) {
        validaciones.forEach(validacion -> validacion.validar(prenda));
    }

}
