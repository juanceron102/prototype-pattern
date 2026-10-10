package registry;

import java.util.HashMap;
import java.util.Map;

import prototype.Personaje;

public class RegistroPrototipos {
    private final Map<String, Personaje> prototipos = new HashMap<>();

    public void registrarPrototipo(String clave, Personaje personaje) {
        prototipos.put(clave, personaje);
    }

    public Personaje obtenerCopia(String clave) {
        Personaje prototipo = prototipos.get(clave);
        if (prototipo == null) {
            return null;
        }
        return prototipo.clonar();
    }

    public Personaje verPrototipo(String clave) {
        return prototipos.get(clave);
    }
}
