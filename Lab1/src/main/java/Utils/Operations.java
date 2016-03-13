package Utils;

import Model.DivisionPolynoms;
import Model.Polynom;
import Model.Term;
/**  
* Operations.java - Operations class implements the all operations on the polynoms.
* @author  Vlad Bonta
*/
public class Operations {
	public static Polynom addPolynoms(Polynom firstPolynom, Polynom secondPolynom) {
		Polynom resultPolynom = new Polynom();
		int firstPolynomNrOfTerms = firstPolynom.getNumberOfTerms();
		int secondPolynomNrOfTerms = secondPolynom.getNumberOfTerms();

		int firstPolynomIndex = 0;
		int secondPolynomIndex = 0;

		Term firstPolynomTerm = new Term(0, -1);
		Term secondPolynomTerm = new Term(0, -1);

		if (firstPolynomIndex < firstPolynomNrOfTerms) {
			firstPolynomTerm = firstPolynom.getTerms().get(firstPolynomIndex);
		}
		if (secondPolynomIndex < secondPolynomNrOfTerms) {
			secondPolynomTerm = secondPolynom.getTerms().get(secondPolynomIndex);
		}

		for (; firstPolynomIndex < firstPolynomNrOfTerms || secondPolynomIndex < secondPolynomNrOfTerms;) {
			if (firstPolynomIndex < firstPolynomNrOfTerms) {
				firstPolynomTerm = firstPolynom.getTerms().get(firstPolynomIndex);
			} else {
				firstPolynomTerm = new Term(0, -1);
			}

			if (secondPolynomIndex < secondPolynomNrOfTerms) {
				secondPolynomTerm = secondPolynom.getTerms().get(secondPolynomIndex);
			} else {
				secondPolynomTerm = new Term(0, -1);
			}

			if (firstPolynomTerm.getDegree() < secondPolynomTerm.getDegree()
					&& secondPolynomIndex < secondPolynom.getNumberOfTerms()) {
				resultPolynom.addTerm(secondPolynomTerm);
				secondPolynomIndex++;
			} else if (firstPolynomTerm.getDegree() > secondPolynomTerm.getDegree()
					&& firstPolynomIndex < firstPolynom.getNumberOfTerms()) {
				resultPolynom.addTerm(firstPolynomTerm);
				firstPolynomIndex++;
			} else if (firstPolynomTerm.getDegree() == secondPolynomTerm.getDegree()
					&& secondPolynomIndex < secondPolynom.getNumberOfTerms()
					&& firstPolynomIndex < firstPolynom.getNumberOfTerms()) {
				Term operationResultTerm = new Term(
						firstPolynomTerm.getCoefficient() + secondPolynomTerm.getCoefficient(),
						firstPolynomTerm.getDegree());
				resultPolynom.addTerm(operationResultTerm);
				firstPolynomIndex++;
				secondPolynomIndex++;
			}

		}
		return resultPolynom;
	}

	public static Polynom subPolynoms(Polynom firstPolynom, Polynom secondPolynom) {

		Polynom resultPolynom = new Polynom();
		int firstPolynomNrOfTerms = firstPolynom.getNumberOfTerms();
		int secondPolynomNrOfTerms = secondPolynom.getNumberOfTerms();

		int firstPolynomIndex = 0;
		int secondPolynomIndex = 0;

		Term firstPolynomTerm = new Term(0, -1);
		Term secondPolynomTerm = new Term(0, -1);

		if (firstPolynomIndex < firstPolynomNrOfTerms) {
			firstPolynomTerm = firstPolynom.getTerms().get(firstPolynomIndex);
		}
		if (secondPolynomIndex < secondPolynomNrOfTerms) {
			secondPolynomTerm = secondPolynom.getTerms().get(secondPolynomIndex);
		}

		for (; firstPolynomIndex < firstPolynomNrOfTerms || secondPolynomIndex < secondPolynomNrOfTerms;) {
			if (firstPolynomIndex < firstPolynomNrOfTerms) {
				firstPolynomTerm = firstPolynom.getTerms().get(firstPolynomIndex);
			} else {
				firstPolynomTerm = new Term(0, -1);
			}

			if (secondPolynomIndex < secondPolynomNrOfTerms) {
				secondPolynomTerm = secondPolynom.getTerms().get(secondPolynomIndex);
			} else {
				secondPolynomTerm = new Term(0, -1);
			}

			if (firstPolynomTerm.getDegree() < secondPolynomTerm.getDegree()
					&& secondPolynomIndex < secondPolynom.getNumberOfTerms()) {
				secondPolynomTerm.setCoefficient(-secondPolynomTerm.getCoefficient());
				resultPolynom.addTerm(secondPolynomTerm);
				secondPolynomIndex++;
			} else if (firstPolynomTerm.getDegree() > secondPolynomTerm.getDegree()
					&& firstPolynomIndex < firstPolynom.getNumberOfTerms()) {
				resultPolynom.addTerm(firstPolynomTerm);
				firstPolynomIndex++;
			} else if (firstPolynomTerm.getDegree() == secondPolynomTerm.getDegree()
					&& secondPolynomIndex < secondPolynom.getNumberOfTerms()
					&& firstPolynomIndex < firstPolynom.getNumberOfTerms()) {
				Term operationResultTerm = new Term(
						firstPolynomTerm.getCoefficient() - secondPolynomTerm.getCoefficient(),
						firstPolynomTerm.getDegree());
				resultPolynom.addTerm(operationResultTerm);
				firstPolynomIndex++;
				secondPolynomIndex++;
			}

		}
		return resultPolynom;
	}

	public static Polynom mulPolynoms(Polynom firstPolynom, Polynom secondPolynom) {
		Polynom resultPolynom = new Polynom();
		Polynom auxPolynom = new Polynom();

		int firstPolynomNrOfTerms = firstPolynom.getNumberOfTerms();
		int secondPolynomNrOfTerms = secondPolynom.getNumberOfTerms();

		int firstPolynomIndex = 0;
		int secondPolynomIndex = 0;

		Term firstPolynomTerm = new Term(0, 0);
		Term secondPolynomTerm = new Term(0, 0);

		
		for (;firstPolynomIndex < firstPolynomNrOfTerms;){
			firstPolynomTerm = firstPolynom.getTerms().get(firstPolynomIndex);
			auxPolynom = new Polynom();
			for (secondPolynomIndex = 0;secondPolynomIndex < secondPolynomNrOfTerms;secondPolynomIndex++){
				secondPolynomTerm = secondPolynom.getTerms().get(secondPolynomIndex);
				Term newTerm = new Term(
						firstPolynomTerm.getCoefficient()*secondPolynomTerm.getCoefficient(),
						firstPolynomTerm.getDegree() + secondPolynomTerm.getDegree());
				auxPolynom.addTerm(newTerm);
			}
			resultPolynom = addPolynoms(resultPolynom, auxPolynom);
			firstPolynomIndex++;
		}
		return resultPolynom;
	}

	public static DivisionPolynoms divPolynoms(Polynom firstPolynom, Polynom secondPolynom) {
		Polynom quotientPolynom = new Polynom();
		Polynom remainderPolynom = new Polynom();

		int firstPolynomIndex = 0;
		int secondPolynomIndex = 0;
		while(firstPolynom.getTerms().get(0).getDegree() >= secondPolynom.getTerms().get(0).getDegree()){
			Term firstPolynomTerm = firstPolynom.getTerms().get(firstPolynomIndex);
			Term secondPolynomTerm = secondPolynom.getTerms().get(secondPolynomIndex);
			
			Term multiplyingTerm = new Term(firstPolynomTerm.getCoefficient()/secondPolynomTerm.getCoefficient()
					,firstPolynomTerm.getDegree()-secondPolynomTerm.getDegree()
					);
			quotientPolynom.addTerm(multiplyingTerm);
			Polynom multyplingPolynom = new Polynom();
			multyplingPolynom.addTerm(multiplyingTerm);
			Polynom tmpPolynom = mulPolynoms(secondPolynom, multyplingPolynom);
			firstPolynom = subPolynoms(firstPolynom, tmpPolynom);
			firstPolynom.clearZeros();
		}
		remainderPolynom = firstPolynom;
		return new DivisionPolynoms(quotientPolynom, remainderPolynom);
	}

	public static Polynom derivatePolynom(Polynom firstPolynom) {
		Polynom resultPolynom = new Polynom();
		int firstPolynomNrOfTerms = firstPolynom.getNumberOfTerms();

		int firstPolynomIndex = 0;
		
		Term firstPolynomTerm = new Term(0, 0);

		for (firstPolynomIndex = 0; firstPolynomIndex < firstPolynomNrOfTerms;firstPolynomIndex++) {
			firstPolynomTerm = firstPolynom.getTerms().get(firstPolynomIndex);
			firstPolynomTerm.setCoefficient(firstPolynomTerm.getCoefficient()*firstPolynomTerm.getDegree());
			firstPolynomTerm.setDegree(firstPolynomTerm.getDegree()-1);

			resultPolynom.addTerm(firstPolynomTerm);
		}
		

		return resultPolynom;
	}

	public static Polynom integratePolynom(Polynom firstPolynom) {
		Polynom resultPolynom = new Polynom();
		int firstPolynomNrOfTerms = firstPolynom.getNumberOfTerms();

		int firstPolynomIndex = 0;
		
		Term firstPolynomTerm = new Term(0, 0);

		for (firstPolynomIndex = 0; firstPolynomIndex < firstPolynomNrOfTerms;firstPolynomIndex++) {
			firstPolynomTerm = firstPolynom.getTerms().get(firstPolynomIndex);
			firstPolynomTerm.setDegree(firstPolynomTerm.getDegree()+1);
			firstPolynomTerm.setCoefficient(firstPolynomTerm.getCoefficient()/firstPolynomTerm.getDegree());

			resultPolynom.addTerm(firstPolynomTerm);
		}
		
		return resultPolynom;
	}
}