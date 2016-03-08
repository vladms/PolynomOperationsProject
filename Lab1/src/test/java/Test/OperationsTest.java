package Test;

import Logic.AppLogic;
import Model.DivisionPolynoms;
import Model.Polynom;
import Model.Term;
import Utils.Operations;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OperationsTest {
	protected Polynom firstPolynom, secondPolynom, resultPolynom;
	protected DivisionPolynoms divisionPolynomResult;

	@Before
	protected void setUp() {
		int n = 100;
		for (int i = 1; i < n; i++) {
			Term newTerm = new Term(i, i);
			firstPolynom.addTerm(newTerm);
			newTerm = new Term(i * i, i * i);
			secondPolynom.addTerm(newTerm);
			
		}
	}

	@Test
	public void testAddPolynoms() {
		assertEquals(1,1);



	}

	@Test
	public void testSubPolynoms() {
		resultPolynom = Operations.subPolynoms(firstPolynom, secondPolynom);
		System.err.println("Sub " + AppLogic.polynomToString(resultPolynom));
	}

	@Test
	public void testMulPolynoms() {
		resultPolynom = Operations.mulPolynoms(firstPolynom, secondPolynom);
		System.err.println("Mul " + AppLogic.polynomToString(resultPolynom));
	}

	@Test
	public void testDivPolynoms() {
		divisionPolynomResult = Operations.divPolynoms(firstPolynom, secondPolynom);
		DivisionPolynoms divisionResult = Operations.divPolynoms(firstPolynom, secondPolynom);
		System.err.println("Div: " + AppLogic.polynomToString(divisionResult.getQuotientPolynom()));
		System.err.println(AppLogic.polynomToString(divisionResult.getRemainderPolynom()));
	}

	@Test
	public void testDerivation() {
		resultPolynom = Operations.derivatePolynom(firstPolynom);
		System.err.println("Derivation " + AppLogic.polynomToString(resultPolynom));

	}

	@Test
	public void testIntegration() {
		resultPolynom = Operations.integratePolynom(firstPolynom);
		System.err.println("Integration " + AppLogic.polynomToString(resultPolynom));
	}

}
