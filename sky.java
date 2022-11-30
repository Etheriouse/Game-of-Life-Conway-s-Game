package GameLife;

import EtherLibrary.functionPrimary.*;

public class sky {

    //------------------- Sky -------------------//

    //genere un ciel composer de cellule placer aléatoirement
    public static int[][] skyCelulle(int nbLigne, int nbColonne) {
        int sky[][] = new int[nbLigne][nbColonne];
        sky = Other.init(sky);
        int coo[][] = coordonnee.assignate(nbLigne, nbColonne, index.NombreCelulle, index.defaults); // if random: true => coordonée random;
        Tab.Int2(coo);
        for(int i = 0; i<coo.length; i+=1) {
            sky[coo[i][1]][coo[i][0]] = 0;
        }
        return sky;
    }
    
    //evolution au pas suivant des celulle de la matrice
    public static int[][] nextSkyCelulle(int nbLigne, int nbColonne, int cheking[], int chekingNaissance[], int skyCelulle[][]) {
        int count = 0;
        int countN = 0;
        //Tab.Int(chekingNaissance);
        //Tab.Int(cheking);
        for(int i = 0; i<skyCelulle.length; i+=1) {
            for(int y = 0; y<skyCelulle[i].length; y+=1) {
                if(skyCelulle[i][y] != -1) {
                    if(cheking[count]<2) {
                        skyCelulle[i][y] = -1;
                    } 
                    if(cheking[count]>3) {
                        skyCelulle[i][y] = -1;
                    }
                    if(cheking[count]==2 || cheking[count] == 3) {
                       skyCelulle[i][y] = 0;
                    }
                    count+=1;
                    
                } else {
                    
                    //System.out.println(chekingNaissance.length + " " + countN);
                    if(chekingNaissance[countN]==3) {
                        skyCelulle[i][y] = 0;
                    } else {
                        skyCelulle[i][y] = -1;
                    }
                    countN+=1;
                
                }
            }
        }
        return skyCelulle;
    }

    //simule un ciel de cellule pour un nombre d'itération et un temps de pas defini en parametre
    public static void simulationCellule(int nbItteration, int tps) throws Exception {
        /*
         * int t[][] = skyCelulle(tailleX, tailleY);
         */
        int t[][] = skyCelulle(index.tailleX, index.tailleY);
        for(int i = 0; i<nbItteration; i+=1) {
            affgen(t);
            int e[] = check.cheking(t);
            int n[] = check.chekingNaissance(t);
            t = nextSkyCelulle(index.tailleX, index.tailleY, e, n, t);
            //Tab.Int2(t);
            System.out.println("round: " + i);
            Thread.sleep(tps);
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
        
    }
    
    //affiche une matrice qui lui est donner en entrer( int );
    public static void affgen(int gen[][]) {
        int population = 0;
        for(int i = 0; i<gen.length+2; i+=1) {
            System.out.print("% ");
        }
        System.out.println();

        for(int i = 0; i<gen.length; i+=1) {
            System.out.print("% ");
            for(int y = 0; y<gen[i].length; y+=1) {
                if(gen[i][y] == -1) {
                    System.out.print("  ");
                } else if(gen[i][y] == 2) {
                    System.out.print("- ");
                } else {
                    System.out.print("@ ");
                    population+=1;
                }
            }
            System.out.println("% ");
        }

        for(int i = 0; i<gen.length+2; i+=1) {
            System.out.print("% ");
        }
        System.out.println();
        System.out.println("Population actuel: " + population);
    }

    
}
