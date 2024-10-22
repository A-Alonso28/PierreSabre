package personnages;

public class Ronin extends Humain{
	private int honneur;
	
	public Ronin(String nom, String boisson, int argent) {
		super(nom,boisson,argent);
		this.honneur = 1;
	}
	
	public void donner(Commercant beneficiaire) {
		int somme = getArgent()/10;
		parler(beneficiaire.getNom() + " prend ces " + somme + " sous.");
		beneficiaire.recevoirArgent(somme);
		perdreArgent(somme);
	}
	
	public void provoquer(Yakuza adversaire) {
		parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand !");
		if(honneur*2 > adversaire.getReputation()) {
			parler("Je t'ai eu petit Yakusa !");
			gagnerArgent(adversaire.perdre());
			honneur += 1;
		}else {
			adversaire.gagner(getArgent());
			honneur -= 1;
			parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse ont en pris un coup.");
		}
	}
}