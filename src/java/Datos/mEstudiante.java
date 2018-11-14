package Datos;

import Beans.bEstudiante;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class mEstudiante {

    CADO cado = new CADO();

    public boolean insertar(bEstudiante e) {
        String sql = "INSERT INTO estudiante VALUES (?, ?, ?, ?, ?)";
        return cado.Ejecutar(sql, e.getParametros());
    }
    
    public List listarE(String codigo){
        String sql = "SELECT * FROM estudiante WHERE codigo="+codigo;
        ResultSet rs = cado.Recuperar(sql);
        return list(rs);
    }
    public List listar(int curso_idcurso){
        String sql = "SELECT * FROM estudiante WHERE curso_idcurso="+curso_idcurso;
        ResultSet rs = cado.Recuperar(sql);
        return list(rs);
    }
    
    private List<bEstudiante> list(ResultSet rs) {
        List<bEstudiante> les = new ArrayList<>();
        try {
            rs.beforeFirst();
            while (rs.next()) {
                bEstudiante e = new bEstudiante(rs);
                les.add(e);
            }
        } catch (SQLException e) {
            les = new ArrayList<>();
        }
        return les;
    }
}
