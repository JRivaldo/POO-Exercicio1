package poo.sca;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SCAFacadeTest {
	private SCAFacade facade;
	
	@Before
	public void setUp() throws Exception {
		facade = new SCAFacade();
	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void testCriarTurma() {
		Disciplina disc = new Disciplina();
		disc.setCodigo(999);
		disc.setNome("LP");
		try {
			facade.criarTurma("2012.1", disc, 3);
		} catch (SCAFacadeException e) {
			Assert.assertEquals("N�o � poss�vel criar duas turmas com o mesmo n�mero, no mesmo per�odo para a mesma disciplina.", e.getMessage());
		}
	}

	@Test
	public void testCriarCurso() {
		try {
			facade.criarCurso("SI", 1000);
		} catch (SCAFacadeException e) {
			Assert.assertEquals("N�o � poss�vel criar dois cursos com esse o c�digo 1000", e.getLocalizedMessage());
		}
	}


	@Test
	public void testCriarDisciplina() {
		try {
			facade.criarDisciplina(1234, "Probabilidade");
		} catch (SCAFacadeException e) {
			Assert.assertEquals("J� existe uma disciplina com o c�digo 1234", e.getLocalizedMessage());
		}
	}

	@Test
	public void testCriarProfessor() {
		try {
			facade.criarProfessor("Rivaldo", 12345);
		} catch (SCAFacadeException e) {
			Assert.assertEquals("N�o � poss�vel criar dois professores com a matr�cula 12345", e.getLocalizedMessage());
		}
	}

}
