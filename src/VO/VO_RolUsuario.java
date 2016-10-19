/*
 * Esta es la clase que nos refleja el contenido de cada registro de la tabla RolUsuario.
 */

package VO;

/**
 *
 * @author Gustavo Patiño Salas
 */
public class VO_RolUsuario {
    
    private String rol_id;
    private String rol_nombre;

    public VO_RolUsuario() {
    }

    public VO_RolUsuario(String rol_id, String rol_nombre) {
        this.rol_id = rol_id;
        this.rol_nombre = rol_nombre;
    }

    public String getRol_id() {
        return rol_id;
    }

    public void setRol_id(String rol_id) {
        this.rol_id = rol_id;
    }

    public String getRol_nombre() {
        return rol_nombre;
    }

    public void setRol_nombre(String rol_nombre) {
        this.rol_nombre = rol_nombre;
    }
    
    
}
