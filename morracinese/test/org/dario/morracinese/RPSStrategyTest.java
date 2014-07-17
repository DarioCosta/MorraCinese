package org.dario.morracinese;

import junit.framework.TestCase;

public class RPSStrategyTest extends TestCase {

	public void testFightSameElement() {
		RPSStrategy strategy=new RPSStrategy();
		try {
			assertEquals(0, strategy.fight(Element.CARTA, Element.CARTA));
			assertEquals(0, strategy.fight(Element.FORBICI, Element.FORBICI));
			assertEquals(0, strategy.fight(Element.PIETRA, Element.PIETRA));
		} catch (IllegalElementException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
	}
	public void testFightCartaForbici() {
		RPSStrategy strategy=new RPSStrategy();
		try {
			assertEquals(1, strategy.fight(Element.CARTA, Element.FORBICI));
			assertEquals(-1, strategy.fight(Element.FORBICI, Element.CARTA));
		} catch (IllegalElementException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
	}
	public void testFightCartaPietra() {
		RPSStrategy strategy=new RPSStrategy();
		try {
			assertEquals(-1, strategy.fight(Element.CARTA, Element.PIETRA));
			assertEquals(1, strategy.fight(Element.PIETRA, Element.CARTA));
		} catch (IllegalElementException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
	}
	public void testFightForbiciPietra() {
		RPSStrategy strategy=new RPSStrategy();
		try {
			assertEquals(1, strategy.fight(Element.FORBICI, Element.PIETRA));
			assertEquals(-1, strategy.fight(Element.PIETRA, Element.FORBICI));
		} catch (IllegalElementException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
	}

}
