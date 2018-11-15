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
        Double m = Math.random()*9999+30000;
        i=m.intValue();
        return i;
    }
    public static void main(String[] args) {
        random r = new random();
        System.out.println(r.getInt());;
    }
}
