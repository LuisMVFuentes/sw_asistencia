package Beans;

import java.sql.ResultSet;

public class bEstudiante {

    private int codigo;
    private String nombre;
    private String correo;
    private String celular;
    private int curso_idcurso;

    public bEstudiante() {
    }

    public bEstudiante(int codigo, String nombre, String correo, String celular, int curso_idcurso) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.correo = correo;
        this.celular = celular;
        this.curso_idcurso = curso_idcurso;
    }

    public bEstudiante(ResultSet rs) {
        try {
            this.codigo = rs.getInt(1);
            this.nombre = rs.getString(2);
            this.correo = rs.getString(3);
            this.celular = rs.getString(4);
            this.curso_idcurso = rs.getInt(5);
        } catch (Exception e) {
        }
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public int getCurso_idcurso() {
        return curso_idcurso;
    }

    public void setCurso_idcurso(int curso_idcurso) {
        this.curso_idcurso = curso_idcurso;
    }

    public Object[] getParametros() {
        Object[] os = new Object[5];
        os[0] = this.codigo;
        os[1] = this.nombre;
        os[2] = this.correo;
        os[3] = this.celular;
        os[4] = this.curso_idcurso;
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
