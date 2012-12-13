package poo.sca.ui;

import javax.swing.JOptionPane;

import poo.sca.Curso;
import poo.sca.Disciplina;
import poo.sca.Professor;
import poo.sca.SCAFacade;
import poo.sca.SCAFacadeException;
import poo.sca.Turma;

public class SCA {
	
	private SCAFacade facade = new SCAFacade();
	
	private MostrarInfo info = new MostrarInfo();
	
	public String lerEntrada(String msg){
		String entr = JOptionPane.showInputDialog(msg);
		return entr;
	}
	
	public void mostrarMensagem(String msg){
		JOptionPane.showMessageDialog(null, msg);
	}
	
	
	public void opcaoCriarTurma() throws ClassNotFoundException, SCAFacadeException{
		String periodo = this.lerEntrada("Informe o periodo da turma:");
		if(periodo == null){
			this.mostrarMensagem("Opção cancelado!");
			return;
		}
		
		try{
			String entr = this.lerEntrada(this.info.mostrarDisciplinas() + "\nInforme o código da disciplina:");
			if(entr == null){
				this.mostrarMensagem("Opção cancelado!");
				return;
			}
			else{
				int codigo = Integer.parseInt(entr);
				Disciplina disciplina = facade.getDisciplina(codigo);
				
				entr = this.lerEntrada("Informe o numero da turma:");
				if(entr == null){
					this.mostrarMensagem("Opção cancelado!");
					return;
				}
				else{
					int numero = Integer.parseInt(entr);
					facade.criarTurma(periodo, disciplina, numero);
				}
			}
				
		}catch(NumberFormatException erro){
			this.mostrarMensagem("Informe um valor inteiro para o código\ne o número da turma!");
		}catch(SCAFacadeException erro){
			this.mostrarMensagem(erro.getMessage());
		}
	}

	public void opcaoVerTurmas() throws SCAFacadeException, ClassNotFoundException{
		try{
			this.mostrarMensagem(this.info.mostrarTurmas());
		}catch(SCAFacadeException erro){
			this.mostrarMensagem(erro.getMessage());
		}
		
	}
	
	public void opcaoRemoverTurma() throws SCAFacadeException, ClassNotFoundException{
		int codDisciplina;
		String periodo;
		int numero;
		Turma removida;
		
		try{
			String entr = this.lerEntrada(this.info.mostrarTurmas() + "\n\nInforme o Periodo: ");
			if(entr == null){
				JOptionPane.showMessageDialog(null, "Opção cancelado!");
				return;
			}
			else{
				periodo = entr;
			}
			
			entr = this.lerEntrada(this.info.mostrarTurmas() + "\n\nInforme o Código da Disciplina: ");
			if(entr == null){
				JOptionPane.showMessageDialog(null, "Opção cancelado!");
				return;
			}
			else{
				codDisciplina = Integer.parseInt(entr);
			}
			
			entr = JOptionPane.showInputDialog("Informe o Número: ");
			if(entr == null){
				JOptionPane.showMessageDialog(null, "Opção cancelado!");
				return;
			}
			else{
				numero = Integer.parseInt(entr);
				removida = facade.removerTurma(periodo, codDisciplina, numero);
			}

			this.mostrarMensagem("Foi removida a turma " + removida.getPeriodo() +
					"| " + removida.getDisciplina().getCodigo() + "| " + removida.getNumero());
			
		}catch(NumberFormatException erro){
			this.mostrarMensagem("Informe um valor inteiro!");
		}catch(SCAFacadeException erro){
			this.mostrarMensagem(erro.getMessage());
		}
	}
	
	
	public void opcaoCriarDisciplina() throws SCAFacadeException, ClassNotFoundException{
		String entr = this.lerEntrada("Informe um codigo para a disciplina:");
		if(entr == null){
			this.mostrarMensagem("Opção cancelado!");
			return;
		}
		
		try{
			int codigo = Integer.parseInt(entr);
							
			entr = this.lerEntrada("Informe um nome para a disciplina:");
			
			if(entr == null){
				this.mostrarMensagem("Opção cancelado!");
				return;
			}
			
			facade.criarDisciplina(codigo, entr);
						
		}catch(NumberFormatException erro){
			this.mostrarMensagem("Informe um valor inteiro para o código!");
		}catch(SCAFacadeException erro){
			this.mostrarMensagem(erro.getMessage());
		}
	}
	
	public void opcaoRemoverDisciplina() throws SCAFacadeException, ClassNotFoundException{
		int codigo;
		Disciplina removida;
				
		try{
			String entr = this.lerEntrada(this.info.mostrarDisciplinas() + "\n\nInforme o código: ");
			if(entr == null){
				this.mostrarMensagem("Opção cancelado!");
				return;
			}
			
			else{
				codigo = Integer.parseInt(entr);
				removida = facade.removerDisciplina(codigo);
			}
			this.mostrarMensagem("Foi removida a disciplina " + removida.getCodigo() +
					"| " + removida.getNome());
			
		}catch(NumberFormatException erro){
			this.mostrarMensagem("Informe um valor inteiro para código!");
		}catch(SCAFacadeException erro){
			this.mostrarMensagem(erro.getMessage());
		}
	}

	public void opcaoVerDisciplinas() throws SCAFacadeException, ClassNotFoundException{
		try{
			this.mostrarMensagem(this.info.mostrarDisciplinas());
		}catch(SCAFacadeException erro){
			this.mostrarMensagem(erro.getMessage());
		}
	}
	
	
	public void opcaoCriarCurso() throws SCAFacadeException, ClassNotFoundException{
		String entr = this.lerEntrada("Informe um codigo para o curso:");
		if(entr == null){
			this.mostrarMensagem("Opção cancelado!");
			return;
		}
		
		try{
			int codigo = Integer.parseInt(entr);
							
			entr = this.lerEntrada("Informe um nome para o curso:");
			
			if(entr == null){
				this.mostrarMensagem("Opção cancelado!");
				return;
			}
			
			facade.criarCurso(entr, codigo);
						
		}catch(NumberFormatException erro){
			this.mostrarMensagem("Informe um valor inteiro para o código!");
		}catch(SCAFacadeException erro){
			this.mostrarMensagem(erro.getMessage());
		}
	}
	
	public void opcaoRemoverCurso() throws SCAFacadeException, ClassNotFoundException{
		int codigo;
		Curso removida;
		
		try{

			String entr = this.lerEntrada(this.info.mostrarCursos() + "\n\nInforme o código: ");
			if(entr == null){
				this.mostrarMensagem("Opção cancelado!");
				return;
			}
			
			else{
				codigo = Integer.parseInt(entr);
				removida = facade.removerCurso(codigo);
			}
			this.mostrarMensagem("Foi removido o curso " + removida.getCodigo() +
					"| " + removida.getNome());
			
		}catch(NumberFormatException erro){
			this.mostrarMensagem("Informe um valor inteiro para código!");
		}catch(SCAFacadeException erro){
			this.mostrarMensagem(erro.getMessage());
		}
	}

	public void opcaoVerCursos() throws SCAFacadeException, ClassNotFoundException{
		try{
			this.mostrarMensagem(this.info.mostrarCursos());
		}catch(SCAFacadeException erro){
			this.mostrarMensagem(erro.getMessage());
		}
		
	}

	
	public void opcaoCriarProfessor()throws SCAFacadeException, ClassNotFoundException{
		String entr = this.lerEntrada("Informe um codigo para o professor:");
		if(entr == null){
			this.mostrarMensagem("Opção cancelado!");
			return;
		}
		
		try{
			int codigo = Integer.parseInt(entr);
							
			entr = this.lerEntrada("Informe um nome para o professor:");
			
			if(entr == null){
				this.mostrarMensagem("Opção cancelado!");
				return;
			}
			
			facade.criarProfessor(entr, codigo);
						
		}catch(NumberFormatException erro){
			this.mostrarMensagem("Informe um valor inteiro para o código!");
		}catch(SCAFacadeException erro){
			this.mostrarMensagem(erro.getMessage());
		}
	}
	
	public void opcaoRemoverProfessor() throws SCAFacadeException, ClassNotFoundException{
		int codigo;
		Professor removida;
				
		try{
			String entr = JOptionPane.showInputDialog(this.info.mostrarProfessores() + "\n\nInforme o código: ");
			if(entr == null){
				this.mostrarMensagem("Opção cancelado!");
				return;
			}
			
			else{
				codigo = Integer.parseInt(entr);
				removida = facade.removerProfessor(codigo);
			}
			this.mostrarMensagem("Foi removido o professor " + removida.getCodigo() +
					"| " + removida.getNome());
			
		}catch(NumberFormatException erro){
			this.mostrarMensagem("Informe um valor inteiro para código!");
		}catch(SCAFacadeException erro){
			this.mostrarMensagem(erro.getMessage());
		}
	}
	
	public void opcaoVerProfessores() throws SCAFacadeException, ClassNotFoundException{
		try{
			this.mostrarMensagem(this.info.mostrarProfessores());
		}catch(SCAFacadeException erro){
			this.mostrarMensagem(erro.getMessage());
		}
	}

	
	public void exibeMenu() throws SCAFacadeException, ClassNotFoundException{
		String entr = "";
		boolean fim = false;
		String cancel = "";
		while(fim == false){
			boolean fimT = false;
			boolean fimC = false;
			boolean fimD = false;
			boolean fimP = false;
			
			entr = this.lerEntrada("MENU\n\n1- Turmas; \n2- Cursos;" +
			"\n3- Disciplinas;\n4- Professores.\n5- Sair.\n\nInforme um numero referente as opções acima: ");
			
			cancel = entr;
			if(cancel == null){
				this.mostrarMensagem("Programa cancelado!");
				fim = true;
			}
			
			else if(entr.equals("1")){
							
				while(fimT == false){
					entr = this.lerEntrada("MENU TURMAS\n\n1- Criar Turmas; \n2- Ver Turmas;" +
							"\n3- Remover Turmas;\n4- Sair.\n\nInforme um numero referente as opções acima: ");
					cancel = entr;
					if(cancel == null){
						this.mostrarMensagem("Opção cancelada!");
						fimT = true;
					}
					else if(entr.equals("1")){
						this.opcaoCriarTurma();
					}
					else if(entr.equals("2")){
						this.opcaoVerTurmas();
					}
					else if(entr.equals("3")){
						this.opcaoRemoverTurma();
					}
					else if(entr.equals("4")){
						this.mostrarMensagem("Opção Finalizada!");
						fimT = true;
					}
					else{
						this.mostrarMensagem("Número de opção inválido!");
					}
				}
			}
			else if(entr.equals("2")){
				
				while(fimC == false){
					entr = this.lerEntrada("MENU CURSOS\n\n1- Criar Cursos; \n2- Ver Cursos;" +
							"\n3- Remover Cursos;\n4- Sair.\n\nInforme um numero referente as opções acima: ");
					cancel = entr;
					if(cancel == null){
						this.mostrarMensagem("Opção cancelada!");
						fimC = true;
					}
					else if(entr.equals("1")){
						this.opcaoCriarCurso();
					}
					else if(entr.equals("2")){
						this.opcaoVerCursos();
					}
					else if(entr.equals("3")){
						this.opcaoRemoverCurso();
					}
					else if(entr.equals("4")){
						this.mostrarMensagem("Opção Finalizada!");
						fimC = true;
					}
					else{
						this.mostrarMensagem("Número de opção inválido!");
					}
				}
			}
			else if(entr.equals("3")){
				
				while(fimD == false){
					entr = this.lerEntrada("MENU DISCIPLINAS\n\n1- Criar Disciplinas; \n2- Ver Disciplinas;" +
							"\n3- Remover Disciplinas;\n4- Sair.\n\nInforme um numero referente as opções acima: ");
					cancel = entr;
					if(cancel == null){
						this.mostrarMensagem("Opção cancelada!");
						fimD = true;
					}
					else if(entr.equals("1")){
						this.opcaoCriarDisciplina();
					}
					else if(entr.equals("2")){
						this.opcaoVerDisciplinas();
					}
					else if(entr.equals("3")){
						this.opcaoRemoverDisciplina();
					}
					else if(entr.equals("4")){
						this.mostrarMensagem("Opção Finalizada!");
						fimD = true;
					}
					else{
						this.mostrarMensagem("Número de opção inválido!");
					}
				}
			}
			else if(entr.equals("4")){
				
				while(fimP == false){
					entr = this.lerEntrada("MENU PROFESSORES\n\n1- Criar Professores; \n2- Ver Professores;" +
							"\n3- Remover Professores;\n4- Sair.\n\nInforme um numero referente as opções acima: ");
					cancel = entr;
					if(cancel == null){
						this.mostrarMensagem("Opção cancelada!");
						fimP = true;
					}
					else if(entr.equals("1")){
						this.opcaoCriarProfessor();
					}
					else if(entr.equals("2")){
						this.opcaoVerProfessores();
					}
					else if(entr.equals("3")){
						this.opcaoRemoverProfessor();
					}
					else if(entr.equals("4")){
						this.mostrarMensagem("Opção Finalizada!");
						fimP = true;
					}
					else{
						this.mostrarMensagem("Número de opção inválido!");
					}
				}
			}
			else if(entr.equals("5")){
				this.mostrarMensagem("Programa Finalizado!");
				fim = true;
			}
			else{
				this.mostrarMensagem("Número de opção inválido!");
			}
			
		}

	}

	
	public static void main(String [] args) throws Exception{
		SCA sca = new SCA();
		sca.exibeMenu();
		
	}

}
