package com.license.teste.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.license.teste.model.Endereco;

public class EnderecoDao {

	public static List<Endereco> getListarTodos() {

		List<Endereco> list = new ArrayList<Endereco>();

		try {
			Connection con = ConnectionJDBCFactory.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from endereco");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Endereco u = new Endereco();
				u.setId(rs.getInt("id"));
				u.setEnderecoCompleto(rs.getString("enderecoCompleto"));
				u.setCodCliente(rs.getInt("codCliente"));
				// Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				// String s = formatter.format(rs.getDate("data"));
				list.add(u);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return list;
	}

	public static int save(Endereco u) {
		int status = 0;
		try {

			Connection con = ConnectionJDBCFactory.getConnection();
			PreparedStatement ps = con.prepareStatement("INSERT INTO endereco (enderecoCompleto) values(?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, u.getEnderecoCompleto());
			// ps.setInt(2, u.getCodCliente());
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
			PreparedStatement ps = con.prepareStatement("UPDATE endereco SET codCliente = ? WHERE id = ?");
			ps.setInt(1, idCliente);
			ps.setInt(2, idEndereco);
			status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

}
