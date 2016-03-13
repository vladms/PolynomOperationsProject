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
		assertEquals(resultPolynom.polynomToString(),"10X^¹⁰⁰ +8X^⁶⁴ +6X^³⁶ +5X^²⁵ +8X^¹⁶ +3X^⁹ +4X^⁴ +1X".replace(" ", ""));
	}

	@Test
	public void testSubPolynoms() {
		resultPolynom = Operations.subPolynoms(firstPolynom, secondPolynom);
		System.out.println(firstPolynom.polynomToString());
		System.out.println(secondPolynom.polynomToString());
		System.out.println(resultPolynom.polynomToString());

		assertEquals(resultPolynom.polynomToString(),"10X^¹⁰⁰ +8X^⁶⁴ +6X^³⁶ -5X^²⁵-3X^⁹-1X".replace(" ", ""));

	}

	@Test
	public void testMulPolynoms() {
		resultPolynom = Operations.mulPolynoms(firstPolynom, secondPolynom);
		assertEquals(resultPolynom.polynomToString(),"50X^¹²⁵ +40X^¹¹⁶ +30X^¹⁰⁹ +20X^¹⁰⁴ +10X^¹⁰¹ +40X^⁸⁹ +32X^⁸⁰ +24X^⁷³ +16X^⁶⁸ +8X^⁶⁵ +30X^⁶¹ +24X^⁵² +18X^⁴⁵ +20X^⁴¹ +12X^⁴⁰ +6X^³⁷ +16X^³² +10X^²⁹ +12X^²⁵ +16X^²⁰ +4X^¹⁷ +6X^¹³ +4X^⁸ +2X^⁵ ".replace(" ", ""));
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
		

		assertEquals(divisionPolynomResult.getQuotientPolynom().polynomToString(), "1X+6".replace(" ", ""));
		assertEquals(divisionPolynomResult.getRemainderPolynom().polynomToString(), "4".replace(" ", ""));

	}

	@Test
	public void testDerivation() {
		resultPolynom = Operations.derivatePolynom(firstPolynom);
		resultPolynom.polynomToString().replace(" ", "");
		assertEquals(resultPolynom.polynomToString(),"1000X^⁹⁹ +512X^⁶³ +216X^³⁵ +64X^¹⁵ +8X^³".replace(" ", ""));
	}

	@Test
	public void testIntegration() {
		resultPolynom = Operations.integratePolynom(firstPolynom);
		assertEquals(resultPolynom.polynomToString(),"0.0990099X^¹⁰¹ +0.12307692X^⁶⁵ +0.16216215X^³⁷ +0.23529412X^¹⁷ +0.4X^⁵".replace(" ", ""));
	}

}
