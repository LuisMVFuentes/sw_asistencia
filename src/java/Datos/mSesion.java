package Datos;

import Beans.bSesion;
import Beans.bSesion_Estudiante;
import Utiles.Fecha;

/**
 *
 * @author MARIANO
 */
public class mSesion {

    CADO cado = new CADO();

    public boolean insertar(bSesion s) {
        String sql = "INSERT INTO sesion VALUES (?, ?, ?, ?, ?)";
        return cado.Ejecutar(sql, s.getParametros());
    }

    public boolean insertar(bSesion_Estudiante se) {
        String sql = "INSERT INTO `sesion_has_estudiante` VALUES (?, ?, ?, ?)";
        return cado.Ejecutar(sql, se.getParametros());
    }

    public static void main(String[] args) {
        System.out.println(new mSesion().insertar(new bSesion_Estudiante(95147, "98741", "A", "")));
    }
}
