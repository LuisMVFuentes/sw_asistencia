package Beans;

import java.sql.ResultSet;

/**
 *
 * @author MARIANO
 */
public class bCarrera {

    private int idcarrera;
    private String carrera;
    private String facultad;

    public bCarrera() {
    }

    public bCarrera(int idcarrera, String carrera, String facultad) {
        this.idcarrera = idcarrera;
        this.carrera = carrera;
        this.facultad = facultad;
    }

    public bCarrera(ResultSet rs) {
        try {
            this.idcarrera = rs.getInt(1);
            this.carrera = rs.getString(2);
            this.facultad = rs.getString(3);
        } catch (Exception e) {
        }
    }

    public int getIdcarrera() {
        return idcarrera;
    }

    public void setIdcarrera(int idcarrera) {
        this.idcarrera = idcarrera;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public Object[] getParametros() {
        Object[] os = new Object[3];
        os[0] = this.idcarrera;
        os[1] = this.carrera;
        os[2] = this.facultad;
        return os;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < getParametros().length; i++) {
            s += (i != 0 && i < getParametros().length) ? ", " : "";
            s += getParametros()[i];
        }
        return s;
    }
}
