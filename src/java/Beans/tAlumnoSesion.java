package Beans;

import java.sql.ResultSet;

/**
 *
 * @author MARIANO
 */
public class tAlumnoSesion {

    private String codigo;
    private String nombre;
    private String estado;
    private String observacion;
    private int idsesiones;
    private int idcurso;
    private String fecha;

    public tAlumnoSesion() {
    }

    public tAlumnoSesion(String codigo, String nombre, String estado, String observacion, int idsesiones, int idcurso, String fecha) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.estado = estado;
        this.observacion = observacion;
        this.idsesiones = idsesiones;
        this.idcurso = idcurso;
        this.fecha = fecha;
    }

    public tAlumnoSesion(ResultSet rs) {
        try {
            this.codigo = rs.getString(1);
            this.nombre = rs.getString(2);
            this.estado = rs.getString(3);
            this.observacion = rs.getString(4);
            this.idsesiones = rs.getInt(5);
            this.idcurso = rs.getInt(6);
            this.fecha = rs.getDate(7).toString();
        } catch (Exception e) {
        }
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getIdsesiones() {
        return idsesiones;
    }

    public void setIdsesiones(int idsesiones) {
        this.idsesiones = idsesiones;
    }

    public int getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(int idcurso) {
        this.idcurso = idcurso;
    }

    public Object[] getParametros() {
        Object[] os = new Object[7];
        os[0] = this.codigo;
        os[1] = this.nombre;
        os[2] = this.estado;
        os[3] = this.observacion;
        os[4] = this.idsesiones;
        os[5] = this.idcurso;
        os[6] = this.fecha;
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
