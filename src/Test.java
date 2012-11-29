import java.util.ArrayList;
import java.util.List;

import poo.sca.Disciplina;
import poo.sca.io.SCAPersistenciaArquivo;


public class Test {
	public static void main(String args[]) throws Exception{
		SCAPersistenciaArquivo arq = new SCAPersistenciaArquivo();
		
		List<Disciplina> disci1 = new ArrayList<Disciplina>();
		Disciplina disci =  new Disciplina();
		disci.setCodigo(1234);
		disci.setNome("lol");
		disci1.add(disci);
		arq.salvarDisciplina(disci1);
		
		
	}

}
