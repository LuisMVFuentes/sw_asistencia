package Datos;

import Beans.bSesion;

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
    
    public static void main(String[] args) {
        System.out.println(new mSesion().insertar(new bSesion(95148, "MA", "12:30", "13:20", 34567)));
    }
}
