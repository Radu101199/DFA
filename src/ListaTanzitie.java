import java.util.*;

public class ListaTanzitie {
	private ArrayList <Tranzitie> lista = new ArrayList();
	
	void adaugaTranzitie(Tranzitie th) {
		this.lista.add(th); 
	}
	Tranzitie returneazaTranzitie(int i) {
		return this.lista.get(i);
	}
	
	Tranzitie gasesteTranzitie(String stare, char simbol)
	{
		for(int i=0; i<lista.size();i++) {
			Tranzitie tmp=lista.get(i);
			if(tmp.spuneStinceput().equals(stare) && 
					tmp.spuneSimbol()==simbol)
				return tmp;
	}
		return null;
	}
	
}
