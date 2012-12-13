package poo.sca;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import poo.sca.io.SCAPersistencia;
import poo.sca.io.SCAPersistenciaArquivo;
import poo.sca.io.SCAPersistenciaException;

public class SCAFacade {
	
	SCAPersistencia persistencia = new SCAPersistenciaArquivo();
		
	public Turma criarTurma(String periodo, Disciplina disciplina, int numero) throws SCAFacadeException, ClassNotFoundException{
		Turma turma = new Turma(disciplina, numero, periodo);
		boolean verifica = false;
		
		try{
			List<Turma> turmasLista = persistencia.recuperarTurmas();
			if(!(turmasLista == null)){
				for(Turma turmas: turmasLista){
					if(((turmas.getPeriodo().equals(periodo)) || (turmas.getNumero()== numero)) 
							&& (turmas.getDisciplina().getCodigo() == disciplina.getCodigo())){
						verifica = true;
						throw new SCAFacadeException("Não é possível criar duas turmas com o mesmo número, no mesmo " +
								"período para a mesma disciplina.");
					}
				}
			}
			else if(turmasLista == null){
				turmasLista = new ArrayList<Turma>();
			}
			if(verifica == false){
				turmasLista.add(turma);
				persistencia.salvarTurmas(turmasLista);
				
			}
			
		}catch(SCAPersistenciaException erro){
			erro.getMessage();
		}
		return turma;
		
		
	}
	
	public Turma getTurma(String periodo, int codDisciplina, int numero) throws SCAFacadeException, ClassNotFoundException{
		Turma turma1 = null;
		boolean verifica = false;
		try{
			List<Turma> turmasLista = persistencia.recuperarTurmas();
			for(Turma turma: turmasLista){
				if((turma.getPeriodo().equals(periodo)) && (turma.getDisciplina().getCodigo() == codDisciplina)
						&& (turma.getNumero() == numero)){
					turma1 = turma;
					verifica = true;
				}

			}
			if(verifica == false){
				throw new SCAFacadeException("Nenhuma turma encontrada!");
			}
			
		}catch(SCAPersistenciaException erro){
			erro.getMessage();
		}
		
		return turma1;
	}
	
	public Turma removerTurma(String periodo, int codDisciplina, int numero) throws SCAFacadeException, ClassNotFoundException{
		Turma turma = null;
		boolean verifica = false;
		
		try{
			List<Turma> turmaLista = persistencia.recuperarTurmas();

			for(Turma turmas : turmaLista){
				if((turmas.getPeriodo().equals(periodo)) && (turmas.getDisciplina().getCodigo() == codDisciplina)
						&& (turmas.getNumero() == numero)){
					turma = turmas;
					verifica = true;
				}
				
			}
			if(turma != null){
				turmaLista.remove(turma);
				persistencia.salvarTurmas(turmaLista);
			}
			
			if(verifica == false){
				throw new SCAFacadeException("A turma informada não existe!");
			}
			
		}catch(SCAPersistenciaException erro){
			erro.getMessage();
		}
		return turma;
	}
	
	public Iterator<Turma> getTurmasIterator() throws SCAFacadeException, ClassNotFoundException{
		List<Turma> turmas = null;
		try{
			turmas = persistencia.recuperarTurmas();
			
		}catch(SCAPersistenciaException erro){
			erro.getMessage();
		}
		
		return turmas.iterator();
	}
	
	
	public Curso criarCurso(String nome, int codigo) throws SCAFacadeException, ClassNotFoundException{
		Curso curso = new Curso();
		curso.setNome(nome);
		curso.setCodigo(codigo);
		boolean verifica = false;
		
		try{
			List<Curso> cursosLista = persistencia.recuperarCursos();
			if(!(cursosLista == null)){
				for(Curso cursos: cursosLista){
					if(cursos.getCodigo() == codigo){
						verifica = true;
						throw new SCAFacadeException("Não é possível criar dois cursos com o mesmo código!");
					}
				}
			}
			else if(cursosLista == null){
				cursosLista = new ArrayList<Curso>();
			}
			
			if(verifica == false){
				cursosLista.add(curso);
				persistencia.salvarCursos(cursosLista);
			}

		}catch(SCAPersistenciaException erro){
			erro.getMessage();
		}
		return curso;
	}

	public Iterator<Curso> getCursosIterator() throws SCAFacadeException, ClassNotFoundException{
		List<Curso> cursos = null;
		
		try{
			cursos = persistencia.recuperarCursos();
			
		}catch(SCAPersistenciaException erro){
			erro.getMessage();
		}
		return cursos.iterator();
	}
	
	public Curso removerCurso(int codigo) throws SCAFacadeException, ClassNotFoundException{
		Curso curso = null;
		boolean verifica = false;
		
		try{
			List<Curso> cursosLista = persistencia.recuperarCursos();

			for(Curso cursos : cursosLista){
				if(cursos.getCodigo() == codigo){
					curso = cursos;
					verifica = true;
				}
			}
			if(curso != null){
				cursosLista.remove(curso);
				persistencia.salvarCursos(cursosLista);
			}
			
			if(verifica == false){
				throw new SCAFacadeException("O curso informado não existe!");
			}
			
		}catch(SCAPersistenciaException erro){
			erro.getMessage();
		}
		return curso;
	}
	
	
	public  Disciplina criarDisciplina(int codigo, String nome) throws SCAFacadeException, ClassNotFoundException{
		Disciplina disciplina = new Disciplina();
		disciplina.setCodigo(codigo);
		disciplina.setNome(nome);
		boolean verifica = false;
		
		try{
			List<Disciplina> disciplinasLista = persistencia.recuperarDisciplinas();
			
			if(!(disciplinasLista == null)){
				for(Disciplina disciplinas: disciplinasLista){
					if(disciplinas.getCodigo() == codigo){
						verifica = true;
						throw new SCAFacadeException("Não é possível criar duas disciplinas com o mesmo código!");
					}
				}
			}
			else if(disciplinasLista == null){
				disciplinasLista = new ArrayList<Disciplina>();
			}
			
			if(verifica == false){
				disciplinasLista.add(disciplina);
				persistencia.salvarDisciplinas(disciplinasLista);
			}
			
		}catch(SCAPersistenciaException erro){
				erro.getMessage();
		}
		return disciplina;
	}
	
	public Disciplina getDisciplina(int codDisciplina) throws SCAFacadeException, ClassNotFoundException{
		Disciplina disciplina = null;
		boolean verifica = false;
		try{
			List<Disciplina> disciplinasLista = persistencia.recuperarDisciplinas();
			for(Disciplina disciplinas: disciplinasLista){
				if(disciplinas.getCodigo() == codDisciplina){
					disciplina = disciplinas;
					verifica = true;
				}
			}
			if(verifica == false){
				throw new SCAFacadeException("Disciplina não encontrada!");
			}
			
		}catch(SCAPersistenciaException erro){
			erro.getMessage();
		}catch(NullPointerException erro){
			throw new SCAFacadeException("Não há disciplinas cadastradas!");
		}
		
		return disciplina;
	}
	
	public Disciplina removerDisciplina(int codigo) throws SCAFacadeException, ClassNotFoundException{
		Disciplina disciplina = null;
		boolean verifica = false;
		
		try{
			List<Disciplina> disciplinasLista = persistencia.recuperarDisciplinas();

			for(Disciplina disciplinas : disciplinasLista){
				if(disciplinas.getCodigo() == codigo){
					disciplina = disciplinas;
					verifica = true;
				}
			}
			if(disciplina != null){
				disciplinasLista.remove(disciplina);
				persistencia.salvarDisciplinas(disciplinasLista);
			}
			if(verifica == false){
				throw new SCAFacadeException("A disciplina informada não existe!");
			}
			
		}catch(SCAPersistenciaException erro){
			erro.getMessage();
		}
		return disciplina;
	}
	
	public Iterator<Disciplina> getDisciplinasIterator() throws SCAFacadeException, ClassNotFoundException{
		List<Disciplina> disciplinas = null;
		
		try{
			disciplinas = persistencia.recuperarDisciplinas();
			
		}catch(SCAPersistenciaException erro){
			erro.getMessage();
		}
		return disciplinas.iterator();
	}
	
	
	public Professor criarProfessor(String nome, int matricula) throws SCAFacadeException, ClassNotFoundException{
		Professor professor = new Professor();
		professor.setNome(nome);
		professor.setCodigo(matricula);
		boolean verifica = false;
		
		try{
			List<Professor> professoresLista = persistencia.recuperarProfessores();
			if(!(professoresLista == null)){
				for(Professor professores: professoresLista){
					if(professores.getCodigo() == matricula){
						verifica = true;
						throw new SCAFacadeException("Não é possível criar dois professores com a mesma matrícula!");
					}
				}
			}
			else if(professoresLista == null){
				professoresLista = new ArrayList<Professor>();
			}
			if(verifica == false){
				professoresLista.add(professor);
				persistencia.salvarProfessores(professoresLista);
			}

		}catch(SCAPersistenciaException erro){
			erro.getMessage();
		}		
		
		return null;
	}
	
	public Iterator<Professor> getProfessoresIterator() throws SCAFacadeException, ClassNotFoundException{
		List<Professor> professores = null;
		
		try{
			professores = persistencia.recuperarProfessores();
			
		}catch(SCAPersistenciaException erro){
			erro.getMessage();
		}

		return professores.iterator();
	}

	public Professor removerProfessor(int codigo) throws SCAFacadeException, ClassNotFoundException{
		Professor professor = null;
		boolean verifica = false;
		
		try{
			List<Professor> professoresLista = persistencia.recuperarProfessores();

			for(Professor professores : professoresLista){
				if(professores.getCodigo() == codigo){
					professor = professores;
					verifica = true;
				}
			}
			if(professor != null){
				professoresLista.remove(professor);
				persistencia.salvarProfessores(professoresLista);
			}
			if(verifica == false){
				throw new SCAFacadeException("O professor informado não existe!");
			}
			
		}catch(SCAPersistenciaException erro){
			erro.getMessage();
		}
		return professor;
	}

}
