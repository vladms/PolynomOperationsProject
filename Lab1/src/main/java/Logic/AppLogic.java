package Logic;

import GUI.UserInterface;
import Model.DivisionPolynoms;
import Model.Polynom;
import Model.Term;
import Utils.Operations;
import GUI.AppInterfaceButtonEvents;

/**  
* AppLogic.java - AppLogic class is the controller of the entire application. User interface and operations are called from here.
* @author  Vlad Bonta
*/

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
			userInterface.showResultPolynom(resultPolynom.polynomToString());
			break;
		case "Subtract polynoms":
			resultPolynom = Operations.subPolynoms(firstPolynom, secondPolynom);
			userInterface.showResultPolynom(resultPolynom.polynomToString());
			break;
		case "Multiply polynoms":
			resultPolynom = Operations.mulPolynoms(firstPolynom, secondPolynom);
			userInterface.showResultPolynom(resultPolynom.polynomToString());
			break;
		case "Divide polynoms":
			DivisionPolynoms divisionResult = Operations.divPolynoms(firstPolynom, secondPolynom);
			userInterface.showResultPolynom(divisionResult.getQuotientPolynom().polynomToString(), divisionResult.getRemainderPolynom().polynomToString());
			break;
		case "Derivate polynom":
			resultPolynom = Operations.derivatePolynom(firstPolynom);
			userInterface.showResultPolynom(resultPolynom.polynomToString());
			break;
		case "Integrate polynom":
			resultPolynom = Operations.integratePolynom(firstPolynom);
			userInterface.showResultPolynom(resultPolynom.polynomToString());
			break;
		default:
			break;
		}
	}

}
