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
				throw new SCAFacadeException("Não há disciplinas cadastradas");
			}
			for(Disciplina disciplina: disciplinasLista){
				mostrar.append("Código: " + disciplina.getCodigo() + "|  Disciplina: " + disciplina.getNome()
						+ "\n");
			}
		}catch(SCAPersistenciaException erro){
			throw new SCAFacadeException(erro.getMessage());
		}catch(NullPointerException erro){
			throw new SCAFacadeException("Não há disciplinas cadastradas");
		}
		
		
		return mostrar.toString();
	}
	
	public String mostrarProfessores() throws SCAFacadeException, ClassNotFoundException{
		StringBuffer mostrar = new StringBuffer("PROFESSORES: \n\n");
				
		try{
			List<Professor> professoresLista = arq.recuperarProfessores();
			if(professoresLista.isEmpty() == true){
				throw new SCAFacadeException("Não há professores cadastrados");
			}
			for(Professor professor: professoresLista){
				mostrar.append("Código: " + professor.getCodigo() + "|  Professor: " + professor.getNome()
						+ "\n");
			}
		}catch(SCAPersistenciaException erro){
			throw new SCAFacadeException(erro.getMessage());
		}catch(NullPointerException erro){
			throw new SCAFacadeException("Não há professores cadastrados");
		}
		
		
		return mostrar.toString();
	}
	
	public String mostrarCursos() throws SCAFacadeException, ClassNotFoundException{
		StringBuffer mostrar = new StringBuffer("CURSOS: \n\n");
				
		try{
			List<Curso> cursosLista = arq.recuperarCursos();
			
			if(cursosLista.isEmpty() == true){
				throw new SCAFacadeException("Não há cursos cadastrados");
			}
			for(Curso curso: cursosLista){
				mostrar.append("Código: " + curso.getCodigo() + "|  Curso: " + curso.getNome()
						+ "\n");
			}
		}catch(SCAPersistenciaException erro){
			throw new SCAFacadeException(erro.getMessage());
		}catch(NullPointerException erro){
			throw new SCAFacadeException("Não há cursos cadastrados");
		}
		
		
		return mostrar.toString();
	}
	
	public String mostrarTurmas() throws SCAFacadeException, ClassNotFoundException{
		StringBuffer mostrar = new StringBuffer("TURMAS: \n\n");
				
		try{
			List<Turma> turmasLista = arq.recuperarTurmas();
			
			if(turmasLista.isEmpty() == true){
				throw new SCAFacadeException("Não há turmas cadastradas");
			}
			for(Turma turma: turmasLista){
				mostrar.append("Número: " + turma.getNumero() + "|  Periodo: " + turma.getPeriodo()
						+  "|  Disciplina: " + turma.getDisciplina().getNome() + 
						"|  Código da disciplina: "+ turma.getDisciplina().getCodigo() +"\n");
			}
		}catch(SCAPersistenciaException erro){
			throw new SCAFacadeException(erro.getMessage());
		}catch(NullPointerException erro){
			throw new SCAFacadeException("Não há turmas cadastradas!");
		}
		
		
		return mostrar.toString();
	}

}
