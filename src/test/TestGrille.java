package test;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import prototype.Grille;

public class TestGrille {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test() {
	Grille g = new Grille(3);
	g.placer(0, 1);
	g.placer(1, 0);
	g.placer(2, 1);
	System.out.println(g);
	System.out.println(g.nombreCarreComplets(1, 2));
	g.placer(0, 3);
	g.placer(1, 4);
	g.placer(2, 3);
	System.out.println(g);
	System.out.println(g.nombreCarreComplets(1, 2));
	g.placer(3, 0);
	g.placer(3, 2);
	System.out.println(g);
	System.out.println(g.nombreCarreComplets(4, 1));
	g.placer(5, 0);
	g.placer(6, 1);
	g.placer(5, 2);
	System.out.println(g);
	System.out.println(g.nombreCarreComplets(4, 1));
    }

}
