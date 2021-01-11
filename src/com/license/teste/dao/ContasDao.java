package com.license.teste.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.license.teste.model.Contas;

public class ContasDao {

	public static List<Contas> getListarTodos() {

		List<Contas> list = new ArrayList<Contas>();

		try {
			Connection con = ConnectionJDBCFactory.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from contas");
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
	
	public static int createAccount(Contas u) {
		int status = 0;
		status = save(u);
		//updateForegKey(u.getCliente(), status);
		
		return status;
	}

	public static int save(Contas u) {
		int status = 0;
		try {

			Connection con = ConnectionJDBCFactory.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"insert into contas (numero, saldo, idCliente) values(?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, u.getNumero());
			ps.setDouble(2, u.getSaldo());
			ps.setInt(3, u.getCliente());
			status = ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public static void updateForegKey(int idCliente, int idConta) {
		try {

			Connection con = ConnectionJDBCFactory.getConnection();
			PreparedStatement ps = con.prepareStatement("UPDATE contas SET idCliente = ? WHERE id = ?");
			ps.setInt(1, idCliente);
			ps.setInt(2, idConta);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
