package it.unibo.controller;


public class TaxCodeInfo {
	
	private int giorno;
	private int mese;
	private int anno;
	private String sesso;
	private String comuneDiNascita;
	
	/**
	 * Costruttore della classe
	 * @param dataDiNascita La data di nascita.
	 * @param sesso Il sesso.
	 * @param comuneDiNascita Il comune di nascita.
	 */
	public TaxCodeInfo(int giorno, int mese, int anno, String sesso, String comuneDiNascita){
		this.giorno = giorno;
		this.mese = mese;
		this.anno = anno;
		this.sesso = sesso;
		this.comuneDiNascita = comuneDiNascita;
	}
	

	/**
	 * @return the giorno
	 */
	public int getGiorno() {
		return giorno;
	}

	/**
	 * @param giorno the giorno to set
	 */
	public void setGiorno(int giorno) {
		this.giorno = giorno;
	}

	/**
	 * @return the mese
	 */
	public int getMese() {
		return mese;
	}

	/**
	 * @param mese the mese to set
	 */
	public void setMese(int mese) {
		this.mese = mese;
	}

	/**
	 * @return the anno
	 */
	public int getAnno() {
		return anno;
	}

	/**
	 * @param anno the anno to set
	 */
	public void setAnno(int anno) {
		this.anno = anno;
	}

	/**
	 * @return the sesso
	 */
	public String getSesso() {
		return sesso;
	}

	/**
	 * @param sesso the sesso to set
	 */
	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	/**
	 * @return the comuneDiNascita
	 */
	public String getComuneDiNascita() {
		return comuneDiNascita;
	}

	/**
	 * @param comuneDiNascita the comuneDiNascita to set
	 */
	public void setComuneDiNascita(String comuneDiNascita) {
		this.comuneDiNascita = comuneDiNascita;
	}
	
	
	/**
	 * Calcola il codice fiscale.
	 * @return Restituisce il codice fiscale generato.
	 * @throws Exception 
	 */
	public String calcola() throws Exception{
		String codiceDataNascitaESesso = this.calcolaCodiceDataNascitaESesso(this.anno, this.mese, this.giorno, this.sesso);
		
		String risultato = codiceDataNascitaESesso;
		
		String carattereDiControllo = this.calcolaCarattereDiControllo(risultato);
		
		risultato += carattereDiControllo;
		
		return risultato;
	}
	
	
	/**
	 * Calcola il codice della data di nascita e del sesso.
	 * @param anno l'anno da cui calcolare il codice.
	 * @param mese il mese da cui calcolare il codice.
	 * @param giorno il giorno da cui calcolare il codice.
	 * @param sesso il sesso da cui calcolare il codice.
	 * @return Il codice della data di nascita e del sesso del codice fiscale.
	 */
	private String calcolaCodiceDataNascitaESesso(int anno, int mese, int giorno, String sesso){
		String codiceDataNascitaESesso;
		String codiceAnno;
		String codiceMese;
		String codiceGiornoESesso;
		
		codiceAnno = calcolaCodiceAnno(anno);
		codiceMese = calcolaCodiceMese(mese);
		codiceGiornoESesso = calcolaCodiceGiornoESesso(giorno, sesso);
		
		codiceDataNascitaESesso = codiceAnno + codiceMese + codiceGiornoESesso;
		
		return codiceDataNascitaESesso;
	}
	
	/**
	 * Calcola il codice dell'anno.
	 * @param anno l'anno da cui calcolare il codice.
	 * @return Il codice dell'anno del codice fiscale.
	 */
	private String calcolaCodiceAnno(int anno){
		return Integer.toString(anno).substring(2);
	}
	
	/**
	 * Calcola il codice del mese.
	 * @param mese il mese da cui calcolare il codice.
	 * @return Il codice del mese del codice fiscale.
	 */
	private String calcolaCodiceMese(int mese){
		String risultato;
		mese++; //I mesi iniziano da 1
		switch(mese){
			case 1:
				risultato = "A";
				break;
			case 2:
				risultato = "B";
				break;
			case 3:
				risultato = "C";
				break;
			case 4:
				risultato = "D";
				break;
			case 5:
				risultato = "E";
				break;
			case 6:
				risultato = "H";
				break;
			case 7:
				risultato = "L";
				break;
			case 8:
				risultato = "M";
				break;
			case 9:
				risultato = "P";
				break;
			case 10:
				risultato = "R";
				break;
			case 11:
				risultato = "S";
				break;
			case 12:
				risultato = "T";
				break;
			default:
				risultato = "";
				break;
		}
		return risultato;
	}
	
	
	/**
	 * Calcola il codice del giorno e del sesso.
	 * @param giorno il giorno da cui calcolare il codice.
	 * @param sesso il sesso da cui calcolare il codice.
	 * @return Il codice del giorno e del sesso del codice fiscale.
	 */
	private String calcolaCodiceGiornoESesso(int giorno, String sesso){
		String codiceGiorno = String.format("%02d", giorno);
		
		if(sesso.equals("F")){
			int codiceGiornoIntero;
			codiceGiornoIntero = Integer.parseInt(codiceGiorno);
			codiceGiornoIntero += 40;
			codiceGiorno = Integer.toString(codiceGiornoIntero);
		}
		
		return codiceGiorno;
	}
	
	
	
	
	/**
	 * Calcola il codice di controllo.
	 * @param codice il codice fiscale senza l'ultima cifra.
	 * @return Il codice di controllo del codice fiscale.
	 * @throws Exception
	 */
	private String calcolaCarattereDiControllo(String codice) throws Exception{
		
		//Passaggio 1 (suddivisione dispari e pari)
		String pari = getStringaPari(codice);
		String dispari = getStringaDispari(codice);
		
		//Passaggio 2 (conversione valori)
		int sommaDispari = conversioneCaratteriDispari(dispari);
		int sommaPari = conversioneCaratteriPari(pari);
		
		//Passaggio 3 (somma, divisione e conversione finale)
		int somma = sommaDispari + sommaPari;
		int resto = (int) somma % 26;
		char restoConvertito = conversioneResto(resto);
		
		return Character.toString(restoConvertito);
	}
	
	/**
	 * Conversione dei caratteri dispari per il secondo passaggio della creazione del carattere di controllo.
	 * @param string la stringa dei caratteri dispari.
	 * @return Numero intero convertito (parte dispari).
	 */
	private int conversioneCaratteriDispari(String string){
		int risultato = 0;
		for(int i = 0; i < string.length(); i++){
			char carattere = string.charAt(i);
			switch(carattere){
			case '0':
			case 'A':
				risultato += 1;
				break;
			case '1':
			case 'B':
				risultato += 0;
				break;
			case '2':
			case 'C':
				risultato += 5;
				break;
			case '3':
			case 'D':
				risultato += 7;
				break;
			case '4':
			case 'E':
				risultato += 9;
				break;
			case '5':
			case 'F':
				risultato += 13;
				break;
			case '6':
			case 'G':
				risultato += 15;
				break;
			case '7':
			case 'H':
				risultato += 17;
				break;
			case '8':
			case 'I':
				risultato += 19;
				break;
			case '9':
			case 'J':
				risultato += 21;
				break;
			case 'K':
				risultato += 2;
				break;
			case 'L':
				risultato += 4;
				break;
			case 'M':
				risultato += 18;
				break;
			case 'N':
				risultato += 20;
				break;
			case 'O':
				risultato += 11;
				break;
			case 'P':
				risultato += 3;
				break;
			case 'Q':
				risultato += 6;
				break;
			case 'R':
				risultato += 8;
				break;
			case 'S':
				risultato += 12;
				break;
			case 'T':
				risultato += 14;
				break;
			case 'U':
				risultato += 16;
				break;
			case 'V':
				risultato += 10;
				break;
			case 'W':
				risultato += 22;
				break;
			case 'X':
				risultato += 25;
				break;
			case 'Y':
				risultato += 24;
				break;
			case 'Z':
				risultato += 23;
				break;
			}
		}
		return risultato;
	}
	
	
	/**
	 * Conversione dei caratteri pari per il secondo passaggio della creazione del carattere di controllo.
	 * @param string la stringa dei caratteri pari.
	 * @return Numero intero convertito (parte pari).
	 */
	private int conversioneCaratteriPari(String string){
		int risultato = 0;
		for(int i = 0; i < string.length(); i++){
			char carattere = string.charAt(i);
			int numero = Character.getNumericValue(carattere);

			if(Character.isLetter(carattere)){
				numero = carattere - 65;
				risultato += numero;
			}
			else{

				risultato += numero;
			}
		}
		return risultato;
	}

	
	/**
	 * Conversione del resto in un carattere per il terzo passaggio della creazione del carattere di controllo.
	 * @param resto il resto da convertire.
	 * @return Resto convertito.
	 */
	private char conversioneResto(int resto){
		return (char) (resto + 65);
	}

	public static String getStringaPari(String string){
		String risultato = "";
		for(int i = 0; i < string.length(); i++){
			if((i+1) % 2 == 0){
				risultato += Character.toString(string.charAt(i));
			}
		}
		return risultato;
	}
	
	public static String getStringaDispari(String string){
		String risultato = "";
		for(int i = 0; i < string.length(); i++){
			if((i+1) % 2 == 1){
				risultato += Character.toString(string.charAt(i));
			}
		}
		return risultato;
	}

}
