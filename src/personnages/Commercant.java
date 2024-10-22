package personnages;

public class Commercant extends Humain {
	
	public Commercant(String nom, int argent) {
		super(nom,"thé",argent);
	}
	
	public int seFaireExtorquer() {
		int somme = getArgent();
		perdreArgent(getArgent());
		parler("J'ai tout perdu ! Le monde est vraiment trop injuste !");
		return somme;
	}
	
	public void recevoirArgent(int somme) {
		gagnerArgent(somme);
		parler(somme + " sous ! Merci généreux donateur !");
	}
}
