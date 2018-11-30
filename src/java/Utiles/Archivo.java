package Utiles;

import java.io.*;

public class Archivo {

    public static String Leer(String ubicacionArchivo, String nombreArchivo) throws Exception {
        File file = null;
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String linea = "";
        String datos = "";

        try {
            file = new File(ubicacionArchivo + "\\" + nombreArchivo);
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            while ((linea = bufferedReader.readLine()) != null) {
                datos = datos + linea;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }

            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (Exception e) {
                    throw e;
                }
            }
        }

        return datos;
    }

    public static void Escribir(String ubicacionArchivo, String nombreArchivo, String datos) throws Exception {
        File file = null;
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;

        try {
            file = new File(ubicacionArchivo + "\\" + nombreArchivo);
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(datos);
        } catch (Exception e) {
            throw e;
        } finally {
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }

            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (Exception e) {
                    throw e;
                }
            }
        }
    }

    public static boolean copiar(String origen, String destino) {
        File archivoOrigen;
        File archivoDestino;
        FileInputStream in = null;
        FileOutputStream out = null;
        boolean b;
        try {
            archivoOrigen = new File(origen);
            archivoDestino = new File(destino);

            /**
             * Validamos que el archivo de origen exista. En caso de que no
             * exista saldremos del método
             */
            if (b = archivoOrigen.exists()) {
                /**
                 * Validamos que el archivo de origen se pueda leer
                 */
                if (b = archivoOrigen.canRead()) {
                    /**
                     * Creamos el lector y el escritor
                     */
                    in = new FileInputStream(archivoOrigen);
                    out = new FileOutputStream(archivoDestino);

                    /**
                     * Mientras se lee de un lado por otro lado se escribe
                     */
                    int c;
                    while ((c = in.read()) != -1) {
                        out.write(c);
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            b = false;
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
                b = false;
            }
        }
        return b;
    }
}
