package poo.sca.ui;

import javax.swing.JOptionPane;

import poo.sca.Disciplina;
import poo.sca.SCAFacade;

public class SCA {
	
	static SCAFacade facade = new SCAFacade();
	
	public static void exibeMenu() throws Exception{
		String entr = "";
		boolean fim = false;
		String cancel = "";
		while(fim == false){
			entr = JOptionPane.showInputDialog("MENU\n\n1- Criar disciplina;\n2- Criar turma;" +
					"\n3- Ver turma;\n4- Ver todas as turmas;\n5- Deletar turma; 6- Sair.\n\nDigite uma das opções acima:");
			cancel = entr;
			if(cancel == null){
				JOptionPane.showMessageDialog(null, "Programa cancelado!");
				fim = true;
			}
			else if(entr.equals("1")){
				entr = JOptionPane.showInputDialog("Informe o nome da disciplina:");
				String nome = entr;
				entr = JOptionPane.showInputDialog("Informe o código da disciplina:");
				
				if(entr == null){
					JOptionPane.showMessageDialog(null, "Opção cancelado!");
				}
				else{
					int numero = Integer.parseInt(entr);
					facade.criarDisciplina(numero, nome);
				}
			}
			else if(entr.equals("2")){
				entr = JOptionPane.showInputDialog("Informe o periodo:");
				String periodo = entr;
				entr = JOptionPane.showInputDialog("Informe o codigo da disciplina:");
				if(entr != null){
					
					int codigo = Integer.parseInt(entr);
					entr = JOptionPane.showInputDialog("Informe o numero da turma:");
					
					if(entr != null){
						int numero = Integer.parseInt(entr);
						Disciplina disciplina = facade.getDisciplina(numero);
						facade.criarTurma(periodo, disciplina, numero);
					}
					else{
						JOptionPane.showMessageDialog(null, "Opção cancelado!");
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Opção cancelado!");
				}
				
			}
		}
		
	}
	
	public static void main(String [] args) throws Exception{
		exibeMenu();
		
	}

}
