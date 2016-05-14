package testJunit;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.IllegalFormatException;

import org.junit.Test;

import pipopipette.Partie;
import pipopipette.Poids;
import pipopipette.Pondere;
import pipopipette.Simplet;

public class PartieTest {

	@Test
	public void testFromPip() throws IllegalFormatException, NumberFormatException, FileNotFoundException {
		Simplet j1 = new Simplet();
		Pondere j2 = new Pondere(new Poids("./autre/C3x3.pip"));
		Partie pa = new Partie(3, 3, true,j1,j2);
		Partie pa2 = null;
		pa2 = Partie.fromPip(j1, j2, "1", "./autre/C3x3.pip");
		if (! pa.getRacine().equals(pa2.getRacine()) ){
			fail("erreur de lecture du .pip");
		}
	}

}
