import java.io.*;
import java.util.*;

public class Automat {
	private String st_init;
	private String stari_finale[];
	private HashSet<String> stariunice = new HashSet<String>();
	private ListaTanzitie lt = new ListaTanzitie();
	
	Automat(String nume_fis) throws Exception{
		BufferedReader buf = new BufferedReader(new FileReader("automat.txt"));
		this.st_init = buf.readLine();
		String stari_finale_str = buf.readLine();
		this.stari_finale = stari_finale_str.split(" ");
		while (true) {
			String tmp = buf.readLine();
			if(tmp == null)
				break;
			else
			{
				String tbl[]=tmp.split(" ");
				Tranzitie tr = new Tranzitie(tbl[0],tbl[1].charAt(0),tbl[2]);
					this.stariunice.add(tbl[0]);
				
				this.lt.adaugaTranzitie(tr);
			}
		}
		
		buf.close();
	}

		boolean analizeazaCuvant(String sir_intrare) {
				boolean match = false;
				if(sir_intrare.length()==0) {
					match = true;
					stariunice.remove(this.st_init);
					}
					else {
						for(int i =0; i<sir_intrare.length(); i++) 
							if (lt.gasesteTranzitie(this.st_init, sir_intrare.charAt(i))!=null) {
								Tranzitie tmp = this.lt.gasesteTranzitie(this.st_init, sir_intrare.charAt(i));
								stariunice.remove(tmp.spuneStsfarsit());
								this.st_init=String.valueOf(tmp.spuneStsfarsit());
						
							}
					}
				System.out.println("Starile prin care nu a trecut sirul nostru sunt : "+stariunice);
				for(int i =0; i<this.stari_finale.length; i++) 
					if(this.st_init.equals(this.stari_finale[i])) 
						{
						match = true;
						break;
						}
				return match;
			}
		 }
		
	

class DFA{
	public static void main(String[] args) throws Exception{
		Automat M = new Automat("automat.txt");
		System.out.println(M.analizeazaCuvant(""));
	}
}
