package test;

import static org.junit.Assert.*;

import org.junit.Test;

import betaplusplus.Idiot;
import betaplusplus.Partie;
import betaplusplus.Prevoyant;
import betaplusplus.Simplet;
import betaplusplus.Simulation;

public class SimulationTest {

	@Test
	public void testSimulation() {
		//4 parties entre Prevoyant et Idiot (3x3)
		Prevoyant prev = new Prevoyant();
		Idiot id = new Idiot();
		float sim = Simulation.simulation(3,3,true,4,prev,id);
		if (sim != 9.0){
			fail("Prev n'a pas une moyenne de 9 carrés");
		}
		//4 parties entre Simplet et Simplet (2x2)
		Simplet s1 = new Simplet();
		Simplet s2 = new Simplet();
		float sim2 = Simulation.simulation(2,2,true,4,s1,s2);
		if (sim2 != 0.0){
			fail("S1 n'a pas une moyenne de 0 carré, mais de "+sim2);
		}
		//6 parties entre Prevoyant et Prevoyant (3x3)
		Prevoyant prev2 = new Prevoyant();
		float sim3 = Simulation.simulation(3,3,true,6,prev,prev2);
		if (sim3 != 8.0){
			fail("prev n'a pas une moyenne de 8 carrés");
		}
		//5 parties entre Idiot et Idiot (3x3)
		Idiot id2 = new Idiot();
		float sim4 = Simulation.simulation(3, 3, true, 5, id, id2);
		if (sim4 != 6.0){
			fail("id n'a pas une moyenne de 6 mais de "+sim4);
		}
	}

}
