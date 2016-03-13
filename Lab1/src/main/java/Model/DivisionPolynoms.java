package Model;
/**  
* DivisionPolynoms.java - DivisionPolynoms class handles with the result of the division of two polynomials, the result being saved in a quotientPolynom and a remainderPolynom.
* @author  Vlad Bonta
* @see Operations
*/
public class DivisionPolynoms {
	private Polynom quotientPolynom = new Polynom();
	private Polynom remainderPolynom = new Polynom();
	public DivisionPolynoms(Polynom quotientPolynom, Polynom remainderPolynom){
		this.setQuotientPolynom(quotientPolynom);
		this.setRemainderPolynom(remainderPolynom);
	}
	public Polynom getQuotientPolynom() {
		return quotientPolynom;
	}
	public void setQuotientPolynom(Polynom quotientPolynom) {
		this.quotientPolynom = quotientPolynom;
	}
	public Polynom getRemainderPolynom() {
		return remainderPolynom;
	}
	public void setRemainderPolynom(Polynom remainderPolynom) {
		this.remainderPolynom = remainderPolynom;
	}
	
}
