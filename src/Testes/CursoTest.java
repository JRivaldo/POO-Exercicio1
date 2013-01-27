package Testes;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import poo.sca.Curso;

public class CursoTest {
	private Curso curso1;
	private Curso curso2;
	@Before
	public void setUp() throws Exception {
		curso1 = new Curso();
		curso2 = new Curso();
		curso1.setNome("Karsh");
		curso1.setCodigo(999);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetNome() {
		Assert.assertEquals("Karsh",curso1.getNome());	
		}

	@Test
	public void testSetNome() {
		curso2.setNome("Damon");
		Assert.assertEquals("Damon",curso2.getNome());
	}

	@Test
	public void testGetCodigo() {
		Assert.assertEquals(999,curso1.getCodigo());
	}

	@Test
	public void testSetCodigo() {
		curso2.setCodigo(666);
		Assert.assertEquals(666,curso2.getCodigo());
	}

}
