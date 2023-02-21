package model;

public class Pessoa {
	
	String nome;
	String email;
	String Tel;
	
	public Pessoa() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return Tel;
	}

	public void setTel(String tel) {
		Tel = tel;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", email=" + email + "]";
	}
	
	
	
}
