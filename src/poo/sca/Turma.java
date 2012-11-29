package poo.sca;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Turma implements Serializable{
	private Disciplina disciplina = new Disciplina();
	private List<Professor> professores = new ArrayList<Professor>();
	private String horario;
	private List<Curso> cursos = new ArrayList<Curso>();
	private int numero;
	private String periodo;
	
	public Turma(Disciplina disciplina, int numero, String periodo){
		this.setDisciplina(disciplina);
		this.setNumero(numero);
		this.setPeriodo(periodo);
	}
	
	public void addProfessor(Professor professor){
		this.professores.add(professor);
	}
	
	public Iterator<Professor> getProfessoresIterator(){
		return this.professores.iterator();
	}
	
	public Iterator<Curso> getCursosIterator(){
		return this.cursos.iterator();
	}

	
	
	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	
	

}
