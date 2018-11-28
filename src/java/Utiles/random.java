/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utiles;

/**
 *
 * @author manue
 */
public class random {

    public int getInt() {
        int i;
        Double m = Math.random() * 90000 + 10000;
        i = m.intValue();
        return i;
    }

    /*public static void main(String[] args) {
        int random = 0;
        int mayor = 0;
        int menor = 0;
        int aux = 0;
        for (int i = 0; i < 100000; i++) {
            random = new random().getInt();
            if (mayor < menor) {
                aux = mayor;
                mayor = menor;
                menor = aux;
            }
            if (mayor < random) {
                mayor = random;
            }
            if (menor > random) {
                menor = random;
            }
        }
        System.out.println("Mayor: " + mayor);
        System.out.println("Menor: " + menor);
    }*/
}
