package Datos;

import Beans.bEstudiante;

public class mEstudiante {

    CADO cado = new CADO();

    public boolean insertar(bEstudiante e) {
        String sql = "INSERT INTO estudiante VALUES (?, ?, ?, ?, ?)";
        return cado.Ejecutar(sql, e.getParametros());
    }

}
