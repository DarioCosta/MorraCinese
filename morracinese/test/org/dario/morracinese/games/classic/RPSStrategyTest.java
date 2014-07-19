package org.dario.morracinese.games.classic;

import org.dario.morracinese.games.classic.RPSStrategy;
import org.dario.morracinese.platform.IllegalElementException;

import junit.framework.TestCase;

public class RPSStrategyTest extends TestCase {

   public void testFightSameElement() {
      RPSStrategy strategy = new RPSStrategy();
      try {
         assertEquals(0, strategy.fight(RPSStrategy.CARTA, RPSStrategy.CARTA));
         assertEquals(0, strategy.fight(RPSStrategy.FORBICI, RPSStrategy.FORBICI));
         assertEquals(0, strategy.fight(RPSStrategy.PIETRA, RPSStrategy.PIETRA));
      } catch (IllegalElementException e) {
         fail(e.getMessage());
         e.printStackTrace();
      }
   }

   public void testFightCartaForbici() {
      RPSStrategy strategy = new RPSStrategy();
      try {
         assertEquals(1, strategy.fight(RPSStrategy.CARTA, RPSStrategy.FORBICI));
         assertEquals(-1, strategy.fight(RPSStrategy.FORBICI, RPSStrategy.CARTA));
      } catch (IllegalElementException e) {
         fail(e.getMessage());
         e.printStackTrace();
      }
   }

   public void testFightCartaPietra() {
      RPSStrategy strategy = new RPSStrategy();
      try {
         assertEquals(-1, strategy.fight(RPSStrategy.CARTA, RPSStrategy.PIETRA));
         assertEquals(1, strategy.fight(RPSStrategy.PIETRA, RPSStrategy.CARTA));
      } catch (IllegalElementException e) {
         fail(e.getMessage());
         e.printStackTrace();
      }
   }

   public void testFightForbiciPietra() {
      RPSStrategy strategy = new RPSStrategy();
      try {
         assertEquals(1, strategy.fight(RPSStrategy.FORBICI, RPSStrategy.PIETRA));
         assertEquals(-1, strategy.fight(RPSStrategy.PIETRA, RPSStrategy.FORBICI));
      } catch (IllegalElementException e) {
         fail(e.getMessage());
         e.printStackTrace();
      }
   }

   public void testFightNull() {
      RPSStrategy strategy = new RPSStrategy();
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
