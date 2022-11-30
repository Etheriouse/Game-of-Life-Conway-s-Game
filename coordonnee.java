package GameLife;

public class coordonnee {
    
    //------------------- Coordonnée -------------------// 
    
    //verifie qu'une paire de nombre n'est pas déja dans le tableau, renvoie true si non presente, sinon false;
    public static boolean nonPresente(int t[][], int a, int b) {
        for(int i = 0; i<t.length; i+=1) {
            if(t[i][0] == a && t[i][1] == b) {
                return false;
            }
        }
        return true;
    }
    
    //genere des cordonnée aléatoire au nombre de nbCellule dans le cadre nbLigne nbColonne, et selon Random elle sont aléatoire ou déja connu;
    //Les cordonnée sont presnte comme sa: [x][y]       y
    //                                     [x][y]       |
    //                                     [x][y]     --+-- x
    public static int[][] assignate(int nbLigne,int nbColonne, int nbCellule, boolean Random) {
        int coo[][] = new int[nbCellule][2];
        coo = Other.init(coo);
        if(Random) {
            for(int i = 0; i<coo.length; i+=1) {
                boolean coordonnee_valide = false;
                while(!coordonnee_valide) {         
                    int x = index.random.nextInt(nbColonne);//((max - min) + min);
                    int y = index.random.nextInt(nbLigne);           
                    if(nonPresente(coo, x, y)) {
                        coordonnee_valide = true;
                        coo[i][0] = x;
                        coo[i][1] = y;
                    }
                }
            }
        } else {
            coo[0][0] = index.tailleX/2;
            coo[0][1] = index.tailleY/2;
            
            coo[1][0] = (index.tailleX/2) + 1;
            coo[1][1] = (index.tailleY/2);

            coo[3][0] = (index.tailleX/2);
            coo[3][1] = (index.tailleY/2)+1;

            
            coo[2][0] = (index.tailleX/2);
            coo[2][1] = (index.tailleY/2)+2;

            
            coo[4][0] = (index.tailleX/2)-1;
            coo[4][1] = (index.tailleY/2)+1;
        }
        return coo;
    }
    
}
