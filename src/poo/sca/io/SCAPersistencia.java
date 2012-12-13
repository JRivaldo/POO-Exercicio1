package poo.sca.io;

import java.util.List;

import poo.sca.Curso;
import poo.sca.Disciplina;
import poo.sca.Professor;
import poo.sca.Turma;

public interface SCAPersistencia {
	public abstract void salvarTurmas(List<Turma> turma) throws SCAPersistenciaException;
	public abstract List<Turma> recuperarTurmas() throws SCAPersistenciaException, ClassNotFoundException ;
	public abstract void salvarDisciplinas(List<Disciplina> disciplina) throws SCAPersistenciaException;
	public abstract List<Disciplina> recuperarDisciplinas() throws SCAPersistenciaException, ClassNotFoundException ;
	public abstract void salvarProfessores(List<Professor> professor) throws SCAPersistenciaException;
	public abstract List<Professor> recuperarProfessores() throws SCAPersistenciaException, ClassNotFoundException ;
	public abstract void salvarCursos(List<Curso> curso) throws SCAPersistenciaException;
	public abstract List<Curso> recuperarCursos() throws SCAPersistenciaException, ClassNotFoundException ;

}
