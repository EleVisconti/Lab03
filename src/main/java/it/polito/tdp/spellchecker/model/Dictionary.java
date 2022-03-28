package it.polito.tdp.spellchecker.model;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Dictionary {
	
	Set<String> dictionary = new HashSet<String>();
	//Set<String> itDictionary = new HashSet<String>();
	int numErrori = 0;
	
	
	public void loadDictionary(String language) {
		if(language.equals("English")) {
		try {
			FileReader fr = new FileReader("src/main/resources/English.txt");
			   BufferedReader br = new BufferedReader(fr);
			  String word;
			  while ((word = br.readLine())!=null) {
				dictionary.add(word);  
			  } br.close();
		} catch(IOException e) {
			System.out.println("Errore nella lettura del file");}}
			if(language.equals("Italian")) {
				try {
					FileReader fr = new FileReader("src/main/resources/Italian.txt");
					   BufferedReader br = new BufferedReader(fr);
					  String word;
					  while ((word = br.readLine())!=null) {
						 dictionary.add(word);  
					  } br.close();
				} catch(IOException ex) {
					System.out.println("Errore nella lettura del file");}}
			
		}
		public Set<String> getDictionary() {
		return dictionary;
	}
		public List<RichWord> spellChecktext(List <String> inputTextList){
			List<RichWord> parole = new ArrayList<RichWord>();
			List<RichWord> paroleSbagliate = new ArrayList<RichWord>();
			RichWord parola;
			for(String s : inputTextList) {
				
				if(dictionary.contains(s))
				parola = new RichWord(s, true);
				else
				parola = new RichWord(s, false);
				parole.add(parola);
			}
			for(RichWord temp : parole) {
				if(temp.isCorretta()==false) {
					paroleSbagliate.add(temp);
				    numErrori++;
				}}
			return paroleSbagliate;
		}
		public int getNumErrori() {
			return numErrori;
		}
		
		
		
		public void setDictionary(Set<String> dictionary) {
			this.dictionary = dictionary;
		}
		public void setNumErrori(int numErrori) {
			this.numErrori = numErrori;
		}
		public List<RichWord> spellCheckText(List <String> inputTextList){
			List<RichWord> parole = new ArrayList<RichWord>();
			List<RichWord> paroleSbagliate = new ArrayList<RichWord>();
			RichWord parola;
			for(String s : inputTextList) {
				
				if(dictionary.contains(s))
				parola = new RichWord(s, true);
				else
				parola = new RichWord(s, false);
				parole.add(parola);
			}
			for(RichWord temp : parole) {
				if(temp.isCorretta()==false) {
					paroleSbagliate.add(temp);
				    numErrori++;
				}}
			return paroleSbagliate;
		}
		
		
		
		
		
	}


