package Datos;

import Beans.bCarrera;

/**
 *
 * @author MARIANO
 */
public class mCarrera {

    CADO cado = new CADO();

    public boolean insertar(bCarrera c) {
        String sql = "INSERT INTO carrera VALUES(?, ?, ?)";
        return cado.Ejecutar(sql, c.getParametros());
    }

}
