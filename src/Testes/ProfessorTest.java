package Testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import poo.sca.Professor;

public class ProfessorTest {
		private Professor prof1;
		private Professor prof2;
		@Before
		public void setUp() throws Exception {
			prof1 = new Professor();
			prof2 = new Professor();
		}

		@After
		public void tearDown() throws Exception {
		}

		@Test
		public void testNome() {
			prof1.setNome("Gilvan");
			assertEquals("Gilvan",prof1.getNome());
			assertEquals(null,prof2.getNome());
		}
		@Test
		public void testMatricula(){
			prof1.setCodigo(10000);
			assertEquals(10000,prof1.getCodigo());
		}



}
