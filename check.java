package GameLife;

public class check {

    //------------------- Checking -------------------//

    //renvoie un tableau de checking qui contient pour toute le point vide combien elle on de celulle autour d'elle
    public static int[] chekingNaissance(int skyCelulle[][]) {
        int numbCel[] = new int[Other.findNbCel(skyCelulle, -1)];
        int k = 0;
        for(int i = 0; i<skyCelulle.length; i+=1) {
            for(int y = 0; y<skyCelulle[i].length; y+=1) {
                
                if(skyCelulle[i][y] == -1 && k<numbCel.length) {
                    int rayon[][] = Other.emplacementRayonLuciole(skyCelulle, y, i);
                    //System.out.println(numbCel.length + " k: " + k);
                    numbCel[k] = Other.recupN(rayon, 0);
                    k+=1;
                }
            }
        }
        return numbCel;
    }

    //renvoie un tableau de checking qui contient pour toute les cellule combien elle on de celulle autour d'elle
    public static int[] cheking(int skyCelulle[][]) {
        int numbCel[] = new int[Other.findNbCel(skyCelulle, 0)];
        int k= 0;
            for(int i = 0; i<skyCelulle.length; i+=1) {
                for(int y = 0; y<skyCelulle[i].length; y+=1) {
                    //System.out.println(i + " " + y);
                    if(skyCelulle[i][y] == 0) {
                        int rayon[][] = Other.emplacementRayonLuciole(skyCelulle, y, i);
                        //System.out.println("rang: " + k);
                        //affgen(rayon);
                        numbCel[k] = Other.recup(rayon, 0);
                        k+=1;
                    }
                }
            }
        return numbCel;
    }
    
}
