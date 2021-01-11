package com.license.teste.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.license.teste.model.Cliente;
import com.license.teste.model.Contas;

public class ClienteDao {

	public static List<Cliente> getListarTodos() {

		List<Cliente> list = new ArrayList<Cliente>();

		try {
			Connection con = ConnectionJDBCFactory.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from clientes");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Cliente u = new Cliente();
				u.setId(rs.getInt("id"));
				u.setNome(rs.getString("nome"));
				u.setDocumento(rs.getString("documento"));
				u.setTipo(rs.getString("tipo"));
				u.setTelefone(rs.getString("telefone"));
				u.setCodEndereco(rs.getInt("codEndereco"));
				// Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				// String s = formatter.format(rs.getDate("data"));
				list.add(u);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return list;
	}

	public static int save(Cliente u) {
		int status = 0;
		try {

			Connection con = ConnectionJDBCFactory.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"insert into clientes(nome,documento,tipo,telefone) values(?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, u.getNome());
			ps.setString(2, u.getDocumento());
			ps.setString(3, u.getTipo());
			ps.setString(4, u.getTelefone());
			status = ps.executeUpdate();

			final ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				final int lastId = rs.getInt(1);
				status = lastId;
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public static int updateForegKey(int idCliente, int idEndereco) {
		int status = 0;
		try {

			Connection con = ConnectionJDBCFactory.getConnection();
			PreparedStatement ps = con.prepareStatement("UPDATE clientes SET codEndereco = ? WHERE id = ?");
			ps.setInt(1, idEndereco);
			ps.setInt(2, idCliente);
			status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	public static List<Contas> getContas(int id) {

		List<Contas> list = new ArrayList<Contas>();

		try {
			Connection con = ConnectionJDBCFactory.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from contas where idCliente = "+id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Contas u = new Contas();
				u.setId(rs.getInt("id"));
				u.setNumero(rs.getInt("numero"));
				u.setCliente(rs.getInt("idCliente"));
				u.setSaldo(rs.getDouble("saldo"));
				// Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				// String s = formatter.format(rs.getDate("data"));
				list.add(u);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return list;
	}

}
