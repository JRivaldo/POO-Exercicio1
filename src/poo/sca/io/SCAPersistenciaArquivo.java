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
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import poo.sca.Disciplina;
import poo.sca.Professor;
import poo.sca.Turma;

public class SCAPersistenciaArquivo implements SCAPersistencia{
	static String caminhoT = "Arquivos/Turmas/turmas.ser";
	static String caminhoD = "Arquivos/Disciplinas/disciplinas.ser";
	static String caminhoP = "Arquivos/Professores/professores.ser";

	public void salvarTurma(List<Turma> turma) throws Exception {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		boolean file = new File("Arquivos/Turmas").mkdirs();
		try{
			fos = new FileOutputStream(caminhoT);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(turma);
		}catch(FileNotFoundException erro1){
			erro1.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}finally{
			fos.close();
			oos.close();
		}		
		
	}


	public ArrayList<Turma> recuperarTurmas() throws Exception {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		ArrayList<Turma> turmas = null;
		boolean file = new File("Arquivos/Turmas").mkdirs();
		try{
			fis = new FileInputStream(caminhoT);
			ois = new ObjectInputStream(fis);
			turmas = (ArrayList<Turma>) ois.readObject();
		}catch(StreamCorruptedException erro){
			erro.printStackTrace();
		}catch(InvalidClassException erro){
			erro.printStackTrace();
		}catch(FileNotFoundException erro1){
			erro1.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}finally{
			fis.close();
			ois.close();
		}
		return turmas;
		

	}


	public void salvarDisciplina(List<Disciplina> disciplina) throws Exception {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		boolean file = new File("Arquivos/Disciplinas").mkdirs();
		try{
			fos = new FileOutputStream(caminhoD);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(disciplina);
		}catch(FileNotFoundException erro1){
			erro1.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}finally{
			fos.close();
			oos.close();
		}		
		
	}


	@Override
	public ArrayList<Disciplina> recuperarDisciplinas() throws Exception {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
		boolean file = new File("Arquivos/Disciplinas").mkdirs();
		try{
			fis = new FileInputStream(caminhoT);
			ois = new ObjectInputStream(fis);
			disciplinas = (ArrayList<Disciplina>) ois.readObject();
		}catch(StreamCorruptedException erro){
			erro.printStackTrace();
		}catch(InvalidClassException erro){
			erro.printStackTrace();
		}catch(FileNotFoundException erro1){
			erro1.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}finally{
			fis.close();
			ois.close();
		}
		
		return disciplinas;
		

	}

	@Override
	public void salvarProfessores(List<Professor> professor) throws Exception {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		boolean file = new File("Arquivos/Professores").mkdirs();
		try{
			fos = new FileOutputStream(caminhoP);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(professor);
		}catch(FileNotFoundException erro1){
			erro1.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}finally{
			fos.close();
			oos.close();
		}		
		
	}
		



	public List<Professor> recuperarProfessores() throws Exception {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		List<Professor> professores = null;
		boolean file = new File("Arquivos/Professores").mkdirs();
		try{
			fis = new FileInputStream(caminhoP);
			ois = new ObjectInputStream(fis);
			professores = (ArrayList<Professor>) ois.readObject();
		}catch(StreamCorruptedException erro){
			erro.printStackTrace();
		}catch(InvalidClassException erro){
			erro.printStackTrace();
		}catch(FileNotFoundException erro1){
			erro1.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}finally{
			fis.close();
			ois.close();
		}
		
		return professores;
		

	}




}
