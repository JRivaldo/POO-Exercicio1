package poo.sca.ui;

import java.util.List;

import poo.sca.Curso;
import poo.sca.Disciplina;
import poo.sca.Professor;
import poo.sca.SCAFacadeException;
import poo.sca.Turma;
import poo.sca.io.SCAPersistencia;
import poo.sca.io.SCAPersistenciaArquivo;
import poo.sca.io.SCAPersistenciaException;

public class MostrarInfo {
	private SCAPersistencia arq = new SCAPersistenciaArquivo();
	
	public String mostrarDisciplinas() throws SCAFacadeException, ClassNotFoundException{
		StringBuffer mostrar = new StringBuffer("DISCIPLINAS:\n\n");
				
		try{
			List<Disciplina> disciplinasLista = arq.recuperarDisciplinas();
			
			if(disciplinasLista.isEmpty() == true){
				throw new SCAFacadeException("N�o h� disciplinas cadastradas");
			}
			for(Disciplina disciplina: disciplinasLista){
				mostrar.append("C�digo: " + disciplina.getCodigo() + "|  Disciplina: " + disciplina.getNome()
						+ "\n");
			}
		}catch(SCAPersistenciaException erro){
			throw new SCAFacadeException(erro.getMessage());
		}catch(NullPointerException erro){
			throw new SCAFacadeException("N�o h� disciplinas cadastradas");
		}
		
		
		return mostrar.toString();
	}
	
	public String mostrarProfessores() throws SCAFacadeException, ClassNotFoundException{
		StringBuffer mostrar = new StringBuffer("PROFESSORES: \n\n");
				
		try{
			List<Professor> professoresLista = arq.recuperarProfessores();
			if(professoresLista.isEmpty() == true){
				throw new SCAFacadeException("N�o h� professores cadastrados");
			}
			for(Professor professor: professoresLista){
				mostrar.append("C�digo: " + professor.getCodigo() + "|  Professor: " + professor.getNome()
						+ "\n");
			}
		}catch(SCAPersistenciaException erro){
			throw new SCAFacadeException(erro.getMessage());
		}catch(NullPointerException erro){
			throw new SCAFacadeException("N�o h� professores cadastrados");
		}
		
		
		return mostrar.toString();
	}
	
	public String mostrarCursos() throws SCAFacadeException, ClassNotFoundException{
		StringBuffer mostrar = new StringBuffer("CURSOS: \n\n");
				
		try{
			List<Curso> cursosLista = arq.recuperarCursos();
			
			if(cursosLista.isEmpty() == true){
				throw new SCAFacadeException("N�o h� cursos cadastrados");
			}
			for(Curso curso: cursosLista){
				mostrar.append("C�digo: " + curso.getCodigo() + "|  Curso: " + curso.getNome()
						+ "\n");
			}
		}catch(SCAPersistenciaException erro){
			throw new SCAFacadeException(erro.getMessage());
		}catch(NullPointerException erro){
			throw new SCAFacadeException("N�o h� cursos cadastrados");
		}
		
		
		return mostrar.toString();
	}
	
	public String mostrarTurmas() throws SCAFacadeException, ClassNotFoundException{
		StringBuffer mostrar = new StringBuffer("TURMAS: \n\n");
				
		try{
			List<Turma> turmasLista = arq.recuperarTurmas();
			
			if(turmasLista.isEmpty() == true){
				throw new SCAFacadeException("N�o h� turmas cadastradas");
			}
			for(Turma turma: turmasLista){
				mostrar.append("N�mero: " + turma.getNumero() + "|  Periodo: " + turma.getPeriodo()
						+  "|  Disciplina: " + turma.getDisciplina().getNome() + 
						"|  C�digo da disciplina: "+ turma.getDisciplina().getCodigo() +"\n");
			}
		}catch(SCAPersistenciaException erro){
			throw new SCAFacadeException(erro.getMessage());
		}catch(NullPointerException erro){
			throw new SCAFacadeException("N�o h� turmas cadastradas!");
		}
		
		
		return mostrar.toString();
	}

}
