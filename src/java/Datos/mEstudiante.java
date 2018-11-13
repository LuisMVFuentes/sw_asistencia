package Datos;

import Beans.bEstudiante;

public class mEstudiante {

    CADO cado = new CADO();

    public boolean insertar(bEstudiante e) {
        String sql = "INSERT INTO estudiante VALUES (?, ?, ?, ?, ?)";
        return cado.Ejecutar(sql, e.getParametros());
    }

    public static void main(String[] args) {
        System.out.println(new mEstudiante().insertar(new bEstudiante(98741, "Juan Lopez Huaman", "jlh987@hotmail.com", "987456321", 34567)));
    }
}
