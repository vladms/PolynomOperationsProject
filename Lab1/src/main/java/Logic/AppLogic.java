package Logic;

import GUI.UserInterface;
import Model.DivisionPolynoms;
import Model.Polynom;
import Model.Term;
import Utils.Operations;
import GUI.AppInterfaceButtonEvents;

public class AppLogic implements AppInterfaceButtonEvents {
	private UserInterface userInterface;
	private Polynom firstPolynom;
	private Polynom secondPolynom;
	private Polynom resultPolynom;

	public AppLogic() {
		userInterface = new UserInterface(this);
	}

	public void buttonTouched(String operationString, String firstPolynomString, String secondPolynomString) {
		firstPolynom = new Polynom(firstPolynomString);
		secondPolynom = new Polynom(secondPolynomString);

		switch (operationString) {
		case "Add polynoms":
			resultPolynom = Operations.addPolynoms(firstPolynom, secondPolynom);
			userInterface.showResultPolynom(polynomToString(resultPolynom));
			break;
		case "Subtract polynoms":
			resultPolynom = Operations.subPolynoms(firstPolynom, secondPolynom);
			userInterface.showResultPolynom(polynomToString(resultPolynom));
			break;
		case "Multiply polynoms":
			resultPolynom = Operations.mulPolynoms(firstPolynom, secondPolynom);
			userInterface.showResultPolynom(polynomToString(resultPolynom));
			break;
		case "Divide polynoms":
			
			DivisionPolynoms divisionResult = Operations.divPolynoms(firstPolynom, secondPolynom);
			userInterface.showResultPolynom(polynomToString(divisionResult.getQuotientPolynom()), polynomToString(divisionResult.getRemainderPolynom()));
			break;
		case "Derivate polynom":
			resultPolynom = Operations.derivatePolynom(firstPolynom);
			userInterface.showResultPolynom(polynomToString(resultPolynom));

			break;

		case "Integrate polynom":
			resultPolynom = Operations.integratePolynom(firstPolynom);
			userInterface.showResultPolynom(polynomToString(resultPolynom));
			break;
		default:
			break;
		}
	}

	public String polynomToString(Polynom polynom) {
		int polynomDegree = polynom.getNumberOfTerms();
		String polynomString = "";
		for (int index = 0; index < polynomDegree;index++){
			Term term = polynom.getTerms().get(index);
			polynomString += term.termToString(index);
		}

		return polynomString;
	}

	

}
