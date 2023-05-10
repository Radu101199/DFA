
public class Tranzitie {
	private String st_inceput;
	private char simbol;
	private String st_sfarsit;
	
	Tranzitie(String st_inceput, char simbol, String st_sfarsit){
		this.st_inceput=st_inceput;
		this.simbol=simbol;
		this.st_sfarsit=st_sfarsit;
	}
	
	String spuneStinceput() {
		return this.st_inceput;
	}
	
	char spuneSimbol() {
		return this.simbol;
	}
	
	String spuneStsfarsit() {
		return this.st_sfarsit;
	}
}
