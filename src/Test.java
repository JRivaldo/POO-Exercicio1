import java.util.Iterator;

import poo.sca.Disciplina;
import poo.sca.SCAFacade;
import poo.sca.io.SCAPersistencia;
import poo.sca.io.SCAPersistenciaArquivo;
import poo.sca.ui.MostrarInfo;


public class Test {
	public static void main(String args[]) throws Exception{
		SCAPersistencia arq1 = new SCAPersistenciaArquivo();
		MostrarInfo arq2 = new MostrarInfo();
		SCAFacade arq = new SCAFacade();
		//List<Disciplina> disci2 = arq.recuperarDisciplinas();
		
		
		
		
		//List<Disciplina> disci2 = new ArrayList<Disciplina>();
		Disciplina disci =  arq.getDisciplinasIterator().next();
		//disci2.add(disci);
		//Disciplina disci2 =  arq.getDisciplinasIterator().next();
		
		//arq.criarDisciplina(1237, "POO");
		System.out.println(disci.getNome());
		
		
		/*for(Disciplina dis : disci1){
			System.out.println(dis.getNome());
		}
		*/
		
		/*String entr = JOptionPane.showInputDialog("Infome um valor: ");
		int lol = Integer.parseInt(entr);*/
		
		//System.out.println(arq2.mostrarDisciplinas());
		//System.out.println(arq2.mostrarTurmas());
	}

}
