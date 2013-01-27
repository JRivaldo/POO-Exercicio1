package poo.sca;

import java.io.Serializable;

public class Disciplina implements Serializable{
	private int codigo;
	private String nome;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		if((codigo > 9999) || (codigo < 0)){
			throw new RuntimeSCAException("código inválido!");
		}
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome.equals("")){
			throw new RuntimeSCAException("Nome inválido!");
		}
		else if(nome.equals("null")){
			throw new RuntimeSCAException("Nome inválido:" + nome);
		}
		this.nome = nome;
	}
	
	

}
