package model;

public class JavaBeans {
	private String idicon;
	private String nome;
	private String telefone;
	private String email;

	public JavaBeans() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JavaBeans(String idicon, String nome, String telefone, String email) {
		super();
		this.idicon = idicon;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
	}

	public String getIdicon() {
		return idicon;
	}

	public void setIdicon(String idicon) {
		this.idicon = idicon;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
