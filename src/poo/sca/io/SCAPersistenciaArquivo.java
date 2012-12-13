package poo.sca.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.List;

import poo.sca.Curso;
import poo.sca.Disciplina;
import poo.sca.Professor;
import poo.sca.Turma;

public class SCAPersistenciaArquivo implements SCAPersistencia{
	static String caminhoT = "Arquivos/Turmas/turmas.ser";
	static String caminhoD = "Arquivos/Disciplinas/disciplinas.ser";
	static String caminhoP = "Arquivos/Professores/professores.ser";
	static String caminhoC = "Arquivos/Cursos/cursos.ser";

	public void salvarTurmas(List<Turma> turma) throws SCAPersistenciaException {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		boolean file = new File("Arquivos/Turmas").mkdirs();
		try{
			fos = new FileOutputStream(caminhoT);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(turma);
			fos.close();
			oos.close();
		}catch(FileNotFoundException erro1){
			throw new SCAPersistenciaException("Arquivo Não Encontrado");
		}catch (IOException e){
			throw new SCAPersistenciaException("IO Error!");
		}
	}

	public List<Turma> recuperarTurmas() throws SCAPersistenciaException, ClassNotFoundException {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		List<Turma> turmas = null;
		boolean file = new File("Arquivos/Turmas").mkdirs();
		try{
			fis = new FileInputStream(caminhoT);
			ois = new ObjectInputStream(fis);
			turmas = (List<Turma>) ois.readObject();
			fis.close();
			ois.close();
		}catch(StreamCorruptedException erro){
			throw new SCAPersistenciaException("StreamCorruptedException Error!");
		}catch(InvalidClassException erro){
			throw new SCAPersistenciaException("InvalidClass Error!");
		}catch(FileNotFoundException erro1){
			this.salvarTurmas(turmas);
			throw new SCAPersistenciaException("Arquivo Não Encontrado");
		}catch (IOException e){
			throw new SCAPersistenciaException("Erro de Arquivo!");
		}
		return turmas;
		

	}

	public void salvarDisciplinas(List<Disciplina> disciplina) throws SCAPersistenciaException {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		boolean file = new File("Arquivos/Disciplinas").mkdirs();
		try{
			fos = new FileOutputStream(caminhoD);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(disciplina);
			fos.close();
			oos.close();
		}catch(FileNotFoundException erro1){
			throw new SCAPersistenciaException("Arquivo Não Encontrado");
		}catch (IOException e){
			throw new SCAPersistenciaException("IO Error!");
		}		
		
	}

	
	public List<Disciplina> recuperarDisciplinas() throws SCAPersistenciaException, ClassNotFoundException  {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		List<Disciplina> disciplinas = null;
		boolean file = new File("Arquivos/Disciplinas").mkdirs();
		try{
			fis = new FileInputStream(caminhoD);
			ois = new ObjectInputStream(fis);
			disciplinas = (List<Disciplina>) ois.readObject();
			fis.close();
			ois.close();
		}catch(StreamCorruptedException erro){
			throw new SCAPersistenciaException("StreamCorruptedException Error!");
		}catch(InvalidClassException erro){
			throw new SCAPersistenciaException("InvalidClass Error!");
		}catch(FileNotFoundException erro1){
			this.salvarDisciplinas(disciplinas);
			throw new SCAPersistenciaException("Arquivo Não Encontrado");
		}catch (IOException e){
			throw new SCAPersistenciaException("Erro de Arquivo!");
		}
		
		return disciplinas;
		

	}

	public void salvarProfessores(List<Professor> professor) throws SCAPersistenciaException {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		boolean file = new File("Arquivos/Professores").mkdirs();
		try{
			fos = new FileOutputStream(caminhoP);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(professor);
			fos.close();
			oos.close();
		}catch(FileNotFoundException erro1){
			throw new SCAPersistenciaException("Arquivo Não Encontrado");
		}catch (IOException e){
			throw new SCAPersistenciaException("IO Error!");
		}		
		
	}

	public List<Professor> recuperarProfessores() throws SCAPersistenciaException, ClassNotFoundException  {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		List<Professor> professores = null;
		boolean file = new File("Arquivos/Professores").mkdirs();
		try{
			fis = new FileInputStream(caminhoP);
			ois = new ObjectInputStream(fis);
			professores = (List<Professor>) ois.readObject();
			fis.close();
			ois.close();
		}catch(StreamCorruptedException erro){
			throw new SCAPersistenciaException("StreamCorruptedException Error!");
		}catch(InvalidClassException erro){
			throw new SCAPersistenciaException("InvalidClass Error!");
		}catch(FileNotFoundException erro1){
			this.salvarProfessores(professores);
			throw new SCAPersistenciaException("Arquivo Não Encontrado");
		}catch (IOException e){
			throw new SCAPersistenciaException("Erro de Arquivo!");
		}
		
		return professores;
		

	}

	public void salvarCursos(List<Curso> curso) throws SCAPersistenciaException {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		boolean file = new File("Arquivos/Cursos").mkdirs();
		try{
			fos = new FileOutputStream(caminhoC);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(curso);
			fos.close();
			oos.close();
		}catch(FileNotFoundException erro1){
			throw new SCAPersistenciaException("Arquivo Não Encontrado");
		}catch (IOException e){
			throw new SCAPersistenciaException("IO Error!");
		}		
		
	}

	public List<Curso> recuperarCursos() throws SCAPersistenciaException, ClassNotFoundException  {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		List<Curso> cursos = null;
		boolean file = new File("Arquivos/Cursos").mkdirs();
		try{
			fis = new FileInputStream(caminhoC);
			ois = new ObjectInputStream(fis);
			cursos = (List<Curso>) ois.readObject();
			fis.close();
			ois.close();
		}catch(StreamCorruptedException erro){
			throw new SCAPersistenciaException("StreamCorruptedException Error!");
		}catch(InvalidClassException erro){
			throw new SCAPersistenciaException("InvalidClass Error!");
		}catch(FileNotFoundException erro1){
			this.salvarCursos(cursos);
			throw new SCAPersistenciaException("Arquivo Não Encontrado");
		}catch (IOException e){
			throw new SCAPersistenciaException("Erro de Arquivo!");
		}
		return cursos;
		

	}




}
