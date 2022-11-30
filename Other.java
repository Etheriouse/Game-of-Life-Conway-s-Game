package GameLife;

public class Other {

    //------------------- Other -------------------//

    //trouve le nobre de celulle ou de point vide d'une matrice
    public static int findNbCel(int sky[][], int l) {
        int count = 0;
        for(int i = 0; i<sky.length; i+=1) {
            for(int y = 0; y<sky[i].length; y+=1) {
                if(sky[i][y] == l) {
                    count+=1;
                }
            }
        }
        return count;
    }

    //zoom sur un point de la matrice defini en x y;
    public static int[][] emplacementRayonLuciole(int t[][], int positionX, int positionY) {
        //donne l'endroit qui va être regarder selon le rayon//
        int f[][] = new int[(1*2)+1][(1*2)+1];
        int a = 0, b=0;
        for(int i = positionY-1; i<=positionY+1; i+=1) {
            for(int y = positionX-1; y<=positionX+1; y+=1) {
                if(y < 0 || i < 0 || y>t.length-1 || i> t.length-1) {
                    f[a][b] = 2;
                } else {
                    f[a][b] = t[i][y];
                }
                b+=1;
            }
            b = 0;
            a+=1;
        }
        return f;
    }

    //recupere le nombre de ceullule autour d'une celulle
    public static int recup(int skyRestrin[][], int l) {
        int cellule = -1;
        for(int i = 0; i<skyRestrin.length; i+=1) {
            for(int y = 0; y<skyRestrin[i].length; y+=1) {
                //System.out.println(y);
                if(skyRestrin[i][y] == l) {
                    cellule+=1;
                }
            }
        }
        return cellule;
    }

    //recupere le nombre de ceullule autour d'un emplacement vide
    public static int recupN(int skyRestrin[][], int l) {
        int cellule = 0;
        for(int i = 0; i<skyRestrin.length; i+=1) {
            for(int y = 0; y<skyRestrin[i].length; y+=1) {
                //System.out.println(y);
                if(skyRestrin[i][y] == l) {
                    cellule+=1;
                }
            }
        }
        return cellule;
    }
    
    //Prend une matrice en entrer et rend une matrice remplis de -1 en sorti
    public static int[][] init(int t[][]) {
        for(int i = 0; i<t.length; i+=1) {
            for(int y = 0; y<t[i].length; y+=1) {
                t[i][y] = -1;
            }
        }
        return t;
    }

    
}
