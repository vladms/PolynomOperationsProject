package Test;

import Model.DivisionPolynoms;
import Model.Polynom;
import Model.Term;
import Utils.Operations;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OperationsTests {
	private Polynom firstPolynom, secondPolynom, resultPolynom;
	private DivisionPolynoms divisionPolynomResult;
	
	@Before
	public void setUp() {
		firstPolynom = new Polynom();
		for(int i = 10; i >= 2;i=i-2){
			Term term = new Term(i, i*i);
			firstPolynom.addTerm(term);	
		}
		secondPolynom = new Polynom();
		for(int i = 5; i >= 1;i--){
			Term term = new Term(i, i*i);
			secondPolynom.addTerm(term);	
		}
	}

	@Test
	public void testAddPolynoms() {
		resultPolynom = Operations.addPolynoms(firstPolynom, secondPolynom);
		assertEquals(resultPolynom.polynomToString(),"10.0X^¹⁰⁰ +8.0X^⁶⁴ +6.0X^³⁶ +5.0X^²⁵ +8.0X^¹⁶ +3.0X^⁹ +4.0X^⁴ +1.0X".replace(" ", ""));
	}

	@Test
	public void testSubPolynoms() {
		resultPolynom = Operations.subPolynoms(firstPolynom, secondPolynom);
		assertEquals(resultPolynom.polynomToString(),"10.0X^¹⁰⁰ +8.0X^⁶⁴ +6.0X^³⁶ -5.0X^²⁵ 0 -3.0X^⁹ 0 -1.0X".replace(" ", ""));
	}

	@Test
	public void testMulPolynoms() {
		resultPolynom = Operations.mulPolynoms(firstPolynom, secondPolynom);
		assertEquals(resultPolynom.polynomToString(),"50.0X^¹²⁵ +40.0X^¹¹⁶ +30.0X^¹⁰⁹ +20.0X^¹⁰⁴ +10.0X^¹⁰¹ +40.0X^⁸⁹ +32.0X^⁸⁰ +24.0X^⁷³ +16.0X^⁶⁸ +8.0X^⁶⁵ +30.0X^⁶¹ +24.0X^⁵² +18.0X^⁴⁵ +20.0X^⁴¹ +12.0X^⁴⁰ +6.0X^³⁷ +16.0X^³² +10.0X^²⁹ +12.0X^²⁵ +16.0X^²⁰ +4.0X^¹⁷ +6.0X^¹³ +4.0X^⁸ +2.0X^⁵ ".replace(" ", ""));
	}

	@Test
	public void testDivPolynoms() {
		firstPolynom = new Polynom();
		Term term = new Term(1, 2);
		firstPolynom.addTerm(term);
		term = new Term(4, 1);
		firstPolynom.addTerm(term);
		term = new Term(-8, 0);
		firstPolynom.addTerm(term);
		
		secondPolynom = new Polynom();
		term = new Term(1,1);
		secondPolynom.addTerm(term);
		term = new Term(-2,0);
		secondPolynom.addTerm(term);	
		divisionPolynomResult = Operations.divPolynoms(firstPolynom, secondPolynom);
		

		assertEquals(divisionPolynomResult.getQuotientPolynom().polynomToString(), "1.0X+6.0".replace(" ", ""));
		assertEquals(divisionPolynomResult.getRemainderPolynom().polynomToString(), "4.0".replace(" ", ""));

	}

	@Test
	public void testDerivation() {
		resultPolynom = Operations.derivatePolynom(firstPolynom);
		resultPolynom.polynomToString().replace(" ", "");
		assertEquals(resultPolynom.polynomToString(),"1000.0X^⁹⁹ +512.0X^⁶³ +216.0X^³⁵ +64.0X^¹⁵ +8.0X^³".replace(" ", ""));
	}

	@Test
	public void testIntegration() {
		resultPolynom = Operations.integratePolynom(firstPolynom);
		assertEquals(resultPolynom.polynomToString(),"0.0990099X^¹⁰¹ +0.12307692X^⁶⁵ +0.16216215X^³⁷ +0.23529412X^¹⁷ +0.4X^⁵".replace(" ", ""));
	}

}
