package controller;

import java.util.ArrayList;

import model.Pessoa;

public class MinhaListaPessoa {
	
	private static ArrayList<Pessoa> TablePessoa;
	
	private static MinhaListaPessoa instancia;
	
	public static MinhaListaPessoa getInstancia() {
		if(instancia == null) {
			instancia = new MinhaListaPessoa();
			TablePessoa = new ArrayList<>();
		}
		return instancia;
	}
	
	// cadastrar
	public Boolean inserir(Pessoa p) {
		if(p != null) {
			this.TablePessoa.add(p);
			return true;
		}
		return false;
	}
	
	//Deletar
	public Boolean deletar(Pessoa p, String nome) {
		for (Pessoa mp : TablePessoa) {
			if (mp.getNome().equals(nome) ){
				TablePessoa.remove(mp);
				return true;
			}
		}
		return false;
	}
	
	//listar
	public ArrayList<Pessoa> listaPessoa(){
		return TablePessoa;
	}
	
	

}
