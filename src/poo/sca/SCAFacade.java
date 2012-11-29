package poo.sca;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import poo.sca.io.SCAPersistencia;
import poo.sca.io.SCAPersistenciaArquivo;

public class SCAFacade {
	
	SCAPersistencia persistencia = new SCAPersistenciaArquivo();
	SCAPersistenciaArquivo arq = new SCAPersistenciaArquivo();
	
	public Turma criarTurma(String periodo, Disciplina disciplina, int numero) throws Exception{
		Turma turma = new Turma(disciplina, numero, periodo);
		SCAPersistenciaArquivo arq = new SCAPersistenciaArquivo();
		try{
			List<Turma> turmasLista = new ArrayList();//persistencia.recuperarTurmas();
			turmasLista.add(turma);
			arq.salvarTurma(turmasLista);
			
		}catch(NullPointerException erro){
			
		}catch(IOException erro1){
			
		}finally{}
		
		return turma;
		
		
	}
	
	public Turma getTurma(String periodo, int codDisciplina, int numero) throws Exception{
		Turma turma1 = null;
		try{
			List<Turma> turmasLista = persistencia.recuperarTurmas();
			for(Turma turma: turmasLista){
				if((turma.getPeriodo().equals(periodo)) && (turma.getDisciplina().getCodigo() == codDisciplina)
						&& (turma.getNumero() == numero)){
					turma1 = turma;
				}

			}
			
		}catch(NullPointerException erro){
			
		}
		
		return turma1;
	}
	
	public Turma removerTurma(String periodo, int codDisciplina, int numero) throws Exception{
		Turma turma = null;
		try{
			List<Turma> turmaLista = persistencia.recuperarTurmas();

			for(Turma turmas : turmaLista){
				if((turmas.getPeriodo().equals(periodo)) && (turmas.getDisciplina().getCodigo() == codDisciplina)
						&& (turmas.getNumero() == numero)){
					turmaLista.remove(turmas);
			}
		}
		}catch(NullPointerException erro){
			
		}
		
		return turma;
	}
	
	public Iterator<Turma> getTurmasIterator() throws Exception{
		List<Turma> turmas = null;
		try{
			turmas = persistencia.recuperarTurmas();
			
		}catch(NullPointerException erro){
			
		}
		
		return turmas.iterator();
	}
	
	public  Disciplina criarDisciplina(int codigo, String nome) throws Exception{
		Disciplina disciplina = new Disciplina();
		disciplina.setCodigo(codigo);
		disciplina.setNome(nome);
		
		try{
			List<Disciplina> disciplinasLista = persistencia.recuperarDisciplinas();
			if(disciplinasLista != null){
				disciplinasLista.add(disciplina);
				persistencia.salvarDisciplina(disciplinasLista);
			}
			else{
				disciplinasLista = new ArrayList<Disciplina>();
				disciplinasLista.add(disciplina);
				persistencia.salvarDisciplina(disciplinasLista);
			}
			
		}catch(NullPointerException erro){
			
		}catch(IOException erro1){
			
		}
		
		return disciplina;
	}
	
	public Disciplina getDisciplina(int codDisciplina) throws Exception{
		Disciplina disciplina = null;
		try{
			List<Turma> turmasLista = persistencia.recuperarTurmas();
			for(Turma turma: turmasLista){
				if(turma.getDisciplina().getCodigo() == codDisciplina){
					disciplina = turma.getDisciplina();
				}

			}
			
		}catch(NullPointerException erro){
			
		}
		
		return disciplina;
	}
	
	

}
