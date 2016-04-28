package betaplusplus;
/**
 * 
 * @author Julie
 * 
 */
public class Grille implements Etat{
final static int BLOQUE=1;
final static int JOUER=2;
final static int VIDE=0;
private int [][] grille;
public boolean isPlein(){
	return false;
}

public int placer(int x,int y){
	return 0;
}

public int get (int x, int y){
	try {
		return grille[x][y];
	}
	catch (ArrayIndexOutOfBoundsException e) {
		return BLOQUE;
	}
}

public void RempliCarres() {
	
}

private boolean CarreComplet (int x, int y){
	return true;
}

@Override
public boolean equals(Object obj) {
	// TODO Auto-generated method stub
	return super.equals(obj);
}



}
