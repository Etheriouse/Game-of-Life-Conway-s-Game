package GameLife;

import java.util.*;

public class index {

    static Random random = new Random();

    static boolean defaults = false;
    static int NombreCelulle = 500;
    static int tailleX = 50;
    static int tailleY = 50;

    //------------------- Main -------------------//
    public static void main(String[] args) throws Exception {
        if(NombreCelulle>(tailleX*tailleY)+1) {
            System.out.println("Out of cellule !");
            System.exit(1);
        }
        if(!defaults) {
            NombreCelulle = 5;
            sky.simulationCellule(5000, 10);
        }
    }
}
