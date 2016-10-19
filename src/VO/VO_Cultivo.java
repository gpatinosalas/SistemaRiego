/*
 * Esta es la clase que me reflejara la informacion de cada registro de la tabla tb_cultivo, de la base de datos.
**/

package VO;

/**
 *
 * @author Gustavo Patiño Salas
 */
public class VO_Cultivo {
    
    private String cul_id;
    private String cul_nombre;
    //Este es el tiempo en dias en el que deberia estar listo el cultivo, definido por el agronomo.
    private int cul_tiempo;
    //Estas sera las variables ideales definidas por el agronomo en etapa de desarrollo y el numero de dias que dura la etapa.
    private float humedadsd;
    private float humedadrd;
    private float temperaturad;
    private float cul_phd;
    private int cul_diasd;
    //Estas sera las variables ideales definidas por el agronomo en etapa de floracion y el numero de dias que dura esta etapa.
    private float humedadsfl;
    private float humedadrfl;
    private float temperaturafl;
    private float cul_phfl;
    private int cul_diasfl;
    //Estas sera las variables ideales definidas por el agronomo en etapa de fructificacion y el numero de dias que dura esta etapa.
    private float humedadsfr;
    private float humedadrfr;
    private float temperaturafr;
    private float cul_phfr;
    private int cul_diasfr;
    private VO_Sistema cul_sis;

    public VO_Cultivo() {
    }

    public VO_Cultivo(String cul_id, String cul_nombre, int cul_tiempo, float humedadsd, float humedadrd, float temperaturad, float cul_phd, int cul_diasd, float humedadsfl, float humedadrfl, float temperaturafl, float cul_phfl, int cul_diasfl, float humedadsfr, float humedadrfr, float temperaturafr, float cul_phfr, int cul_diasfr, VO_Sistema cul_sis) {
        this.cul_id = cul_id;
        this.cul_nombre = cul_nombre;
        this.cul_tiempo = cul_tiempo;
        this.humedadsd = humedadsd;
        this.humedadrd = humedadrd;
        this.temperaturad = temperaturad;
        this.cul_phd = cul_phd;
        this.cul_diasd = cul_diasd;
        this.humedadsfl = humedadsfl;
        this.humedadrfl = humedadrfl;
        this.temperaturafl = temperaturafl;
        this.cul_phfl = cul_phfl;
        this.cul_diasfl = cul_diasfl;
        this.humedadsfr = humedadsfr;
        this.humedadrfr = humedadrfr;
        this.temperaturafr = temperaturafr;
        this.cul_phfr = cul_phfr;
        this.cul_diasfr = cul_diasfr;
        this.cul_sis = cul_sis;
    }

    public String getCul_id() {
        return cul_id;
    }

    public void setCul_id(String cul_id) {
        this.cul_id = cul_id;
    }

    public String getCul_nombre() {
        return cul_nombre;
    }

    public void setCul_nombre(String cul_nombre) {
        this.cul_nombre = cul_nombre;
    }

    public int getCul_tiempo() {
        return cul_tiempo;
    }

    public void setCul_tiempo(int cul_tiempo) {
        this.cul_tiempo = cul_tiempo;
    }

    public float getHumedadsd() {
        return humedadsd;
    }

    public void setHumedadsd(float humedadsd) {
        this.humedadsd = humedadsd;
    }

    public float getHumedadrd() {
        return humedadrd;
    }

    public void setHumedadrd(float humedadrd) {
        this.humedadrd = humedadrd;
    }

    public float getTemperaturad() {
        return temperaturad;
    }

    public void setTemperaturad(float temperaturad) {
        this.temperaturad = temperaturad;
    }

    public float getCul_phd() {
        return cul_phd;
    }

    public void setCul_phd(float cul_phd) {
        this.cul_phd = cul_phd;
    }

    public int getCul_diasd() {
        return cul_diasd;
    }

    public void setCul_diasd(int cul_diasd) {
        this.cul_diasd = cul_diasd;
    }

    public float getHumedadsfl() {
        return humedadsfl;
    }

    public void setHumedadsfl(float humedadsfl) {
        this.humedadsfl = humedadsfl;
    }

    public float getHumedadrfl() {
        return humedadrfl;
    }

    public void setHumedadrfl(float humedadrfl) {
        this.humedadrfl = humedadrfl;
    }

    public float getTemperaturafl() {
        return temperaturafl;
    }

    public void setTemperaturafl(float temperaturafl) {
        this.temperaturafl = temperaturafl;
    }

    public float getCul_phfl() {
        return cul_phfl;
    }

    public void setCul_phfl(float cul_phfl) {
        this.cul_phfl = cul_phfl;
    }

    public int getCul_diasfl() {
        return cul_diasfl;
    }

    public void setCul_diasfl(int cul_diasfl) {
        this.cul_diasfl = cul_diasfl;
    }

    public float getHumedadsfr() {
        return humedadsfr;
    }

    public void setHumedadsfr(float humedadsfr) {
        this.humedadsfr = humedadsfr;
    }

    public float getHumedadrfr() {
        return humedadrfr;
    }

    public void setHumedadrfr(float humedadrfr) {
        this.humedadrfr = humedadrfr;
    }

    public float getTemperaturafr() {
        return temperaturafr;
    }

    public void setTemperaturafr(float temperaturafr) {
        this.temperaturafr = temperaturafr;
    }

    public float getCul_phfr() {
        return cul_phfr;
    }

    public void setCul_phfr(float cul_phfr) {
        this.cul_phfr = cul_phfr;
    }

    public int getCul_diasfr() {
        return cul_diasfr;
    }

    public void setCul_diasfr(int cul_diasfr) {
        this.cul_diasfr = cul_diasfr;
    }

    public VO_Sistema getCul_sis() {
        return cul_sis;
    }

    public void setCul_sis(VO_Sistema cul_sis) {
        this.cul_sis = cul_sis;
    }
    
    
}
