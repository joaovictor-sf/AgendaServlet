package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	private String url = "jdbc:postgresql://localhost:5432/postgres";
	private String usuario = "postgres";
	private String senha = "joao10dqda";
	private String driver = "org.postgresql.Driver";
	
	private Connection conectar() {
		Connection con = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, usuario, senha);
			return con;
		} catch (Exception e) {
			return null;
		}
	}
	
	//CRUD CREATE
	public void inserirContato(JavaBeans contato) {
		String create = "insert into contatos (nome, telefone, email) values (?, ?, ?)";
		
		try {
			//Abrir conexão
			Connection con = conectar();
			//Preparar query
			PreparedStatement pst = con.prepareStatement(create);
			//Substituir os parametros ?
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getTelefone());
			pst.setString(3, contato.getEmail());
			//Executa query
			pst.executeUpdate();
			//Encerrar conexão
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/** CRUD READ **/
	public ArrayList<JavaBeans> listarContatos(){
		ArrayList<JavaBeans> contatos = new ArrayList<>();
		String read = "select * from contatos order by nome";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			//ResultSet é usado para armazenar o retorno do banco temporariamente em um objeto
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String idcon = rs.getString(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);
				
				contatos.add(new JavaBeans(idcon, nome, fone, email));
			}
			con.close();
			return contatos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	/**
	 * CRUD UPDATE
	 */
	public void selecionarContato(JavaBeans contato) {
		String read2 = "select * from contatos where idcon = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, contato.getIdicon());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				contato.setIdicon(rs.getString(1));
				contato.setNome(rs.getString(2));
				contato.setTelefone(rs.getString(3));
				contato.setEmail(rs.getString(4));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
