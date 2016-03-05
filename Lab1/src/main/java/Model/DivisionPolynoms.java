package Model;

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
