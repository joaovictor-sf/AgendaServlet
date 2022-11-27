package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DAO {
	private String url = "jdbc:postgresql://localhost:5432/postgres";
	private String usuario = "postgres";
	private String senha = "postgres";
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
	
	/*
	public void testeCocexao() {
		try {
			Connection con = conectar();
			System.out.println(con);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}*/
}
