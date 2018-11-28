package Beans;

import java.sql.ResultSet;

/**
 *
 * @author MARIANO
 */
public class bCurso {

    private int idcurso;
    private String codigo;
    private String nombre;
    private String grupo;
    private int ciclo;
    private int doc_iddocente;
    private int car_idcarrera;

    public bCurso() {
    }

    public bCurso(Object[] parametros) {
        parametros[0] = this.idcurso;
        parametros[1] = this.codigo;
        parametros[2] = this.nombre;
        parametros[3] = this.grupo;
        parametros[4] = this.ciclo;
        parametros[5] = this.doc_iddocente;
        parametros[6] = this.car_idcarrera;
    }

    public bCurso(int idcurso, String codigo, String nombre, String grupo, int ciclo, int doc_iddocente, int car_idcarrera) {
        this.idcurso = idcurso;
        this.codigo = codigo;
        this.nombre = nombre.toUpperCase();
        this.grupo = grupo;
        this.ciclo = ciclo;
        this.doc_iddocente = doc_iddocente;
        this.car_idcarrera = car_idcarrera;
    }

    public bCurso(ResultSet rs) {
        try {
            this.idcurso = rs.getInt(1);
            this.codigo = rs.getString(2);
            this.nombre = rs.getString(3).toUpperCase();
            this.grupo = rs.getString(4);
            this.ciclo = rs.getInt(5);
            this.doc_iddocente = rs.getInt(6);
            this.car_idcarrera = rs.getInt(7);
        } catch (Exception e) {
        }
    }

    public int getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(int idcurso) {
        this.idcurso = idcurso;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre.toUpperCase();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre.toUpperCase();
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public int getCiclo() {
        return ciclo;
    }

    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }

    public int getDoc_iddocente() {
        return doc_iddocente;
    }

    public void setDoc_iddocente(int doc_iddocente) {
        this.doc_iddocente = doc_iddocente;
    }

    public int getCar_idcarrera() {
        return car_idcarrera;
    }

    public void setCar_idcarrera(int car_idcarrera) {
        this.car_idcarrera = car_idcarrera;
    }

    public Object[] getParametros() {
        Object[] os = new Object[7];
        os[0] = this.idcurso;
        os[1] = this.codigo;
        os[2] = this.nombre.toUpperCase();
        os[3] = this.grupo;
        os[4] = this.ciclo;
        os[5] = this.doc_iddocente;
        os[6] = this.car_idcarrera;
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
