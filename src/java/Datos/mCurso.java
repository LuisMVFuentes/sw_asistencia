package Datos;

import Beans.bCurso;

/**
 *
 * @author MARIANO
 */
public class mCurso {

    CADO cado = new CADO();

    public boolean insertar(bCurso c) {
        String sql = "INSERT INTO curso VALUES (?, ?, ?, ?, ?, ?)";
        return cado.Ejecutar(sql, c.getParametros());
    }
    
    public static void main(String[] args) {
        System.out.println(new mCurso().insertar(new bCurso(34577, "IS151", "TALLER DE COMPUTACION E INFORMATICA BASICA", "18A", 2, 12345, 23456)));
    }
}
