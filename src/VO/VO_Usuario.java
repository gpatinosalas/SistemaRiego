/*
 * Esta es la clase con la cual vamos a manejar los datos de la tabla tb_usuarios hacia la vista, en teoria lo que se haria es crear
 * un objeto de esta clase, con el cual se va a mostrar los datos relacionados a un registro de la tabla tb_usuarios. De este modo
 * mantendremos los datos disponible para el usuario final sin necesidad de realizar un gran numero de consultas en la base de datos.
 */

package VO;

/**
 *
 * @author Gustavo Patiño Salas
 */
public class VO_Usuario {
    
    private String usu_id;
    private String usu_nombres;
    private String usu_apellidos;
    private String usu_nickName;
    private String usu_password;
    private int usu_estado;
    private VO_RolUsuario rol;

    public VO_Usuario() {
    }

    public VO_Usuario(String usu_id, String usu_nombres, String usu_apellidos, String usu_nickName, String usu_password, int usu_estado, VO_RolUsuario rol) {
        this.usu_id = usu_id;
        this.usu_nombres = usu_nombres;
        this.usu_apellidos = usu_apellidos;
        this.usu_nickName = usu_nickName;
        this.usu_password = usu_password;
        this.usu_estado = usu_estado;
        this.rol = rol;
    }

    public String getUsu_id() {
        return usu_id;
    }

    public void setUsu_id(String usu_id) {
        this.usu_id = usu_id;
    }

    public String getUsu_nombres() {
        return usu_nombres;
    }

    public void setUsu_nombres(String usu_nombres) {
        this.usu_nombres = usu_nombres;
    }

    public String getUsu_apellidos() {
        return usu_apellidos;
    }

    public void setUsu_apellidos(String usu_apellidos) {
        this.usu_apellidos = usu_apellidos;
    }

    public String getUsu_nickName() {
        return usu_nickName;
    }

    public void setUsu_nickName(String usu_nickName) {
        this.usu_nickName = usu_nickName;
    }

    public String getUsu_password() {
        return usu_password;
    }

    public void setUsu_password(String usu_password) {
        this.usu_password = usu_password;
    }

    public int getUsu_estado() {
        return usu_estado;
    }

    public void setUsu_estado(int usu_estado) {
        this.usu_estado = usu_estado;
    }

    public VO_RolUsuario getRol() {
        return rol;
    }

    public void setRol(VO_RolUsuario rol) {
        this.rol = rol;
    }
    
}
