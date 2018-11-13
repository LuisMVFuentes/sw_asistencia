package Datos;

import java.sql.*;
import java.util.Properties;

public class CADO {

    public Connection conectar() {
        String cadenaConexion = "";

        String tipoBase = "mysql";
        String servidorBD = "localhost";
        String puertoBD = "3306";
        String BD = "sw_asistencia";

        cadenaConexion = "jdbc:" + tipoBase + "://"
                + servidorBD + ":" + puertoBD + "/" + BD;

        Properties parametros = new Properties();
        parametros.put("user", "root");
        parametros.put("password", "");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(cadenaConexion, parametros);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean Ejecutar(String sql) {
        Statement st;
        try {
            st = this.conectar().createStatement();
            st.executeUpdate(sql);
            this.conectar().close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean Ejecutar(String sql, Object parametros[]) {
        PreparedStatement pst;
        try {
            pst = this.conectar().prepareStatement(sql);
            for (int x = 0; x < parametros.length; x++) {
                switch (parametros[x].getClass().toString()) {
                    case "class java.lang.Integer":
                        if ((int) parametros[x] == 0 || parametros[x].equals(null)) {
                            pst.setObject(x + 1, null);
                        } else {
                            pst.setInt(x + 1, Integer.parseInt(parametros[x].toString()));
                        }
                        break;
                    case "class java.lang.String":
                        if (parametros[x].toString().equals("") || parametros[x].equals(null)) {
                            pst.setObject(x + 1, null);
                        } else {
                            pst.setString(x + 1, parametros[x].toString());
                        }
                        break;
                    case "class java.lang.Double":
                        pst.setDouble(x + 1, Double.parseDouble(parametros[x].toString()));
                        break;
                    case "class java.lang.Long":
                        pst.setLong(x + 1, Long.parseLong(parametros[x].toString()));
                        break;
                    default:
                        break;
                }
            }
            pst.executeUpdate();
            this.conectar().close();
            return true;
        } catch (NumberFormatException | SQLException ex) {
            return false;
        }
    }

    public ResultSet Recuperar(String sql) {
        Statement stm;
        try {
            stm = this.conectar().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            this.conectar().close();
            return stm.executeQuery(sql);
        } catch (Exception e) {
            return null;
        }
    }

    public ResultSet Recuperar(String sql, Object parametros[]) {
        PreparedStatement pst;
        try {
            pst = this.conectar().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            for (int x = 0; x < parametros.length; x++) {
                switch (parametros[x].getClass().toString()) {
                    case "class java.lang.Integer":
                        pst.setInt(x + 1, Integer.parseInt(parametros[x].toString()));
                        break;
                    case "class java.lang.String":
                        pst.setString(x + 1, parametros[x].toString());
                        break;
                    case "class java.lang.Double":
                        pst.setDouble(x + 1, Double.parseDouble(parametros[x].toString()));
                        break;
                    case "class java.lang.Long":
                        pst.setLong(x + 1, Long.parseLong(parametros[x].toString()));
                        break;
                    default:
                        break;
                }
            }
            this.conectar().close();
            return pst.executeQuery();
        } catch (NumberFormatException | SQLException ex) {
            return null;
        }
    }
}
