package Model;
/**  
* Term.java - Term class is the representation of a monome. It has real coefficient and integer degree.
* @author  Vlad Bonta
* @see Polynom
*/
public class Term {
	private float coefficient;
	private int degree;

	public Term() {
		this.coefficient = 0;
		this.degree = 0;
	}

	public Term(float coefficient, int degree) {
		this.coefficient = coefficient;
		this.degree = degree;
	}

	public float getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(float coefficient) {
		this.coefficient = coefficient;
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	public String termToString(int index) {
		String termString = "";

		if (coefficient == 0) {
			termString = "0 ";
		} else if (this.coefficient < 0) {
			if (this.degree == 0) {
				termString = String.valueOf(this.coefficient);
			} else if (this.degree == 1) {
				termString = this.coefficient + "X";
			} else {
				termString = this.coefficient + "X^" + superscript(String.valueOf(this.degree)) + " ";
			}
		} else {
			if (this.degree == 0) {
				termString = "+" + this.coefficient;
			} else if (this.degree == 1) {
				termString = "+" + this.coefficient + "X";
			} else {
				termString = "+" + this.coefficient + "X^" + superscript(String.valueOf(this.degree)) + " ";
			}
		}
		if (index == 0) {
			termString = termString.substring(1, termString.length());
		}
		return termString;
	}

	public static String superscript(String str) {
		str = str.replaceAll("0", "⁰");
		str = str.replaceAll("1", "¹");
		str = str.replaceAll("2", "²");
		str = str.replaceAll("3", "³");
		str = str.replaceAll("4", "⁴");
		str = str.replaceAll("5", "⁵");
		str = str.replaceAll("6", "⁶");
		str = str.replaceAll("7", "⁷");
		str = str.replaceAll("8", "⁸");
		str = str.replaceAll("9", "⁹");

		return str;
	}

}
