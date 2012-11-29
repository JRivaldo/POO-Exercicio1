package poo.sca.io;

import java.util.ArrayList;
import java.util.List;

import poo.sca.Disciplina;
import poo.sca.Professor;
import poo.sca.Turma;

public interface SCAPersistencia {
	public abstract void salvarTurma(List<Turma> turma) throws Exception;
	public abstract List<Turma> recuperarTurmas() throws Exception;
	public abstract void salvarDisciplina(List<Disciplina> disciplina) throws Exception;
	public abstract List<Disciplina> recuperarDisciplinas() throws Exception;
	public abstract void salvarProfessores(List<Professor> professor) throws Exception;
	public abstract List<Professor> recuperarProfessores() throws Exception;

}
