package it.polito.tdp.parole.model;

import java.util.*;

public class ParoleArrayList {
		
	ArrayList<String> elenco = new ArrayList<String>();
	
	public ParoleArrayList() {
		//TODO
	}
	
	public boolean cercaParola (String p) {
		boolean presente = false;
		for(String s : elenco)
			if(s.equals(p))
				presente = true;
		return presente;
	}
	
	public void addParola(String p) {
		//TODO
		if(this.cercaParola(p)==false && this.parolaCorretta(p))
			elenco.add(p);
	}
	
	public void deleteParola (String p) {
		if(this.cercaParola(p))
			this.elenco.remove(p);
	}
	
	public boolean parolaCorretta (String s) {
		boolean b = true;
		for(int i=0; i<s.length(); i++)
			if(s==null || s.charAt(i)=='0' || s.charAt(i)=='1' || s.charAt(i)=='2' || s.charAt(i)=='3' || s.charAt(i)=='4' || s.charAt(i)=='5' || s.charAt(i)=='6' || s.charAt(i)=='7' || s.charAt(i)=='8' || s.charAt(i)=='9')
				b = false;
		return b;
	}
	
	public List<String> getElenco() {
		//TODO
		Collections.sort(this.elenco, new ComparatoreP());
		return elenco;
	}
	
	public void reset() {
		// TODO
		elenco.clear();
	}
	
	public class ComparatoreP implements Comparator<String> {

		@Override
		public int compare(String o1, String o2) {
			return o1.compareTo(o2);
		}
		
	}

}