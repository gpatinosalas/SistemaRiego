/*
 * Este objeto nos suministra los datos de cada regitro de la tabla tb_sistema. Con los tipos de sistemas posibles para cada cultivo.
 */

package VO;

/**
 *
 * @author Gustavo Patiño Salas
 */
public class VO_Sistema {
    
    private String sis_id;
    private String sis_nombre;

    public VO_Sistema() {
    }

    public VO_Sistema(String sis_id, String sis_nombre) {
        this.sis_id = sis_id;
        this.sis_nombre = sis_nombre;
    }

    public String getSis_id() {
        return sis_id;
    }

    public void setSis_id(String sis_id) {
        this.sis_id = sis_id;
    }

    public String getSis_nombre() {
        return sis_nombre;
    }

    public void setSis_nombre(String sis_nombre) {
        this.sis_nombre = sis_nombre;
    }
    
}
