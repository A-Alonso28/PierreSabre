package personnages;

public class Yakuza extends Humain{
	private String clan;
	private int reputation;
	
	public Yakuza(String nom, String boisson, int argent, String clan) {
		super(nom,boisson,argent);
		this.clan = clan;
		this.reputation = 0;
	}
	
	public int getReputation() {
		return reputation;
	}
	
	public void extorquer(Commercant victime) {
		int argentVictime = victime.getArgent();
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ?");
		parler(victime.getNom() + ", si tu tiens à la vie donne moi ta bourse !");
		victime.seFaireExtorquer();
		gagnerArgent(argentVictime);
		reputation += 1;
		parler("J'ai piqué les " + argentVictime + " sous de " + victime.getNom() + ", ce qui me fait " + getArgent() + " sous dans ma poche !");
	}
	
	public void gagner(int gain) {
		gagnerArgent(gain);
		reputation += 1;
		parler("Ce Ronin pensait vraiment pouvoir battre " + getNom() + " du clan " + clan + "?");
		parler("Je l'ai dépouillé de ses " + gain + " sous.");
	}
	
	public int perdre() {
		int perte = getArgent();
		reputation -= 1;
		perdreArgent(perte);
		parler("J'ai perdu mon duel et mes " + perte + " sous, snif... J'ai déshonnoré le clan " + clan + ".");
		return perte;
	}
	
}
