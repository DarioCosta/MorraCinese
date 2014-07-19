package org.dario.morracinese.games.spocklizard;

import org.dario.morracinese.games.classic.RPSStrategy;
import org.dario.morracinese.platform.IllegalElementException;

import junit.framework.TestCase;

public class SpockLizardStrategyTest extends TestCase {

	   public void testFightSameElement() {
		   SpockLizardStrategy strategy = new SpockLizardStrategy();
		      try {
		         assertEquals(0, strategy.fight(SpockLizardStrategy.CARTA, SpockLizardStrategy.CARTA));
		         assertEquals(0, strategy.fight(SpockLizardStrategy.FORBICI, SpockLizardStrategy.FORBICI));
		         assertEquals(0, strategy.fight(SpockLizardStrategy.PIETRA, SpockLizardStrategy.PIETRA));
		         assertEquals(0, strategy.fight(SpockLizardStrategy.LUCERTOLA, SpockLizardStrategy.LUCERTOLA));
		         assertEquals(0, strategy.fight(SpockLizardStrategy.SPOCK, SpockLizardStrategy.SPOCK));
		      } catch (IllegalElementException e) {
		         fail(e.getMessage());
		         e.printStackTrace();
		      }
		   }

		   public void testFightCartaForbici() {
			   SpockLizardStrategy strategy = new SpockLizardStrategy();
		      try {
		         assertEquals(1, strategy.fight(SpockLizardStrategy.CARTA, SpockLizardStrategy.FORBICI));
		         assertEquals(-1, strategy.fight(SpockLizardStrategy.FORBICI, SpockLizardStrategy.CARTA));
		      } catch (IllegalElementException e) {
		         fail(e.getMessage());
		         e.printStackTrace();
		      }
		   }
		   public void testFightCartaLucertola() {
			   SpockLizardStrategy strategy = new SpockLizardStrategy();
		      try {
		         assertEquals(1, strategy.fight(SpockLizardStrategy.CARTA, SpockLizardStrategy.LUCERTOLA));
		         assertEquals(-1, strategy.fight(SpockLizardStrategy.LUCERTOLA, SpockLizardStrategy.CARTA));
		      } catch (IllegalElementException e) {
		         fail(e.getMessage());
		         e.printStackTrace();
		      }
		   }

		   public void testFightCartaPietra() {
			   SpockLizardStrategy strategy = new SpockLizardStrategy();
		      try {
		         assertEquals(-1, strategy.fight(SpockLizardStrategy.CARTA, SpockLizardStrategy.PIETRA));
		         assertEquals(1, strategy.fight(SpockLizardStrategy.PIETRA, SpockLizardStrategy.CARTA));
		      } catch (IllegalElementException e) {
		         fail(e.getMessage());
		         e.printStackTrace();
		      }
		   }

		   public void testFightCartaSpock() {
			   SpockLizardStrategy strategy = new SpockLizardStrategy();
		      try {
		         assertEquals(-1, strategy.fight(SpockLizardStrategy.CARTA, SpockLizardStrategy.SPOCK));
		         assertEquals(1, strategy.fight(SpockLizardStrategy.SPOCK, SpockLizardStrategy.CARTA));
		      } catch (IllegalElementException e) {
		         fail(e.getMessage());
		         e.printStackTrace();
		      }
		   }

		   public void testFightForbiciPietra() {
			   SpockLizardStrategy strategy = new SpockLizardStrategy();
		      try {
		         assertEquals(1, strategy.fight(SpockLizardStrategy.FORBICI, SpockLizardStrategy.PIETRA));
		         assertEquals(-1, strategy.fight(SpockLizardStrategy.PIETRA, SpockLizardStrategy.FORBICI));
		      } catch (IllegalElementException e) {
		         fail(e.getMessage());
		         e.printStackTrace();
		      }
		   }

		   public void testFightForbiciSpock() {
			   SpockLizardStrategy strategy = new SpockLizardStrategy();
		      try {
		         assertEquals(1, strategy.fight(SpockLizardStrategy.FORBICI, SpockLizardStrategy.SPOCK));
		         assertEquals(-1, strategy.fight(SpockLizardStrategy.SPOCK, SpockLizardStrategy.FORBICI));
		      } catch (IllegalElementException e) {
		         fail(e.getMessage());
		         e.printStackTrace();
		      }
		   }

		   public void testFightForbiciLucertola() {
			   SpockLizardStrategy strategy = new SpockLizardStrategy();
		      try {
		         assertEquals(-1, strategy.fight(SpockLizardStrategy.FORBICI, SpockLizardStrategy.LUCERTOLA));
		         assertEquals(1, strategy.fight(SpockLizardStrategy.LUCERTOLA, SpockLizardStrategy.FORBICI));
		      } catch (IllegalElementException e) {
		         fail(e.getMessage());
		         e.printStackTrace();
		      }
		   }

		   public void testFightPietraLucertola() {
			   SpockLizardStrategy strategy = new SpockLizardStrategy();
		      try {
		         assertEquals(-1, strategy.fight(SpockLizardStrategy.PIETRA, SpockLizardStrategy.LUCERTOLA));
		         assertEquals(1, strategy.fight(SpockLizardStrategy.LUCERTOLA, SpockLizardStrategy.PIETRA));
		      } catch (IllegalElementException e) {
		         fail(e.getMessage());
		         e.printStackTrace();
		      }
		   }

		   public void testFightPietraSpock() {
			   SpockLizardStrategy strategy = new SpockLizardStrategy();
		      try {
		         assertEquals(1, strategy.fight(SpockLizardStrategy.PIETRA, SpockLizardStrategy.SPOCK));
		         assertEquals(-1, strategy.fight(SpockLizardStrategy.SPOCK, SpockLizardStrategy.PIETRA));
		      } catch (IllegalElementException e) {
		         fail(e.getMessage());
		         e.printStackTrace();
		      }
		   }

		   public void testFightLucertolaSpock() {
			   SpockLizardStrategy strategy = new SpockLizardStrategy();
		      try {
		         assertEquals(-1, strategy.fight(SpockLizardStrategy.LUCERTOLA, SpockLizardStrategy.SPOCK));
		         assertEquals(1, strategy.fight(SpockLizardStrategy.SPOCK, SpockLizardStrategy.LUCERTOLA));
		      } catch (IllegalElementException e) {
		         fail(e.getMessage());
		         e.printStackTrace();
		      }
		   }

		   public void testFightNull() {
			   SpockLizardStrategy strategy = new SpockLizardStrategy();
		      int result = 100;
		      try {
		         result = strategy.fight(null, RPSStrategy.PIETRA);
		      } catch (IllegalElementException e) {
		         result = 200;
		      }
		      assertEquals(result, 200);

		      result = 100;
		      try {
		         result = strategy.fight(RPSStrategy.PIETRA, null);
		      } catch (IllegalElementException e) {
		         result = 200;
		      }
		      assertEquals(result, 200);

		      result = 100;
		      try {
		         result = strategy.fight(null, null);
		      } catch (IllegalElementException e) {
		         result = 200;
		      }
		      assertEquals(result, 200);
		   }

}
