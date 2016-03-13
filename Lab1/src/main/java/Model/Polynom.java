package Model;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**  
* Polynom.java - Polynom class saves the list of terms.
* @author  Vlad Bonta
* @see Term
*/
public class Polynom {
	private ArrayList<Term> terms;

	public Polynom() {
		this.terms = new ArrayList<Term>();
	}

	public Polynom(String polynomString) {
		this.terms = new ArrayList<Term>();

		Pattern p = Pattern.compile( "(-?\\b\\d+)[xX]\\^(-?\\d+\\b)");
		Matcher m = p.matcher( polynomString );

		while (m.find()) {
		    Term term = new Term(Float.parseFloat(m.group(1)), Integer.parseInt(m.group(2)));
		    this.terms.add(term);
		    
		}
	}
	
	public void clearZeros(){
		int i = 0;
		while(i<this.getNumberOfTerms()){
			Term polynomTerm = this.terms.get(i);
			if (polynomTerm.getCoefficient() == 0){
				this.terms.remove(i);		
			} else {
				i++;
			}
		}
	}
	
	public String polynomToString() {
		int polynomDegree = getNumberOfTerms();
		String polynomString = "";
		for (int index = 0; index < polynomDegree;index++){
			Term term = terms.get(index);
			polynomString += term.termToString(index);
		}

		return polynomString.replace(" ", "");
	}
	
	public void addTerm(Term term){
		this.terms.add(term);
	}

	public Polynom(ArrayList<Term> arguments) {
		this.terms = arguments;
	}

	public ArrayList<Term> getTerms() {
		return terms;
	}

	public void setTerms(ArrayList<Term> terms) {
		this.terms = terms;
	}

	public int getNumberOfTerms() {
		return terms.size();
	}

}
