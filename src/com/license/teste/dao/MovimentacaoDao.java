package com.license.teste.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.license.teste.model.Movimentacao;
import com.license.teste.model.Relatorio;

public class MovimentacaoDao {

	public static List<Movimentacao> getListarTodos() {

		List<Movimentacao> list = new ArrayList<Movimentacao>();

		try {
			Connection con = ConnectionJDBCFactory.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from movimentacoes");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Movimentacao u = new Movimentacao();
				u.setId(rs.getInt("id"));
				u.setTipo(rs.getString("tipo"));
				u.setIdCliente(rs.getInt("idCliente"));
				u.setContaOrigem(rs.getInt("contaOrigem"));
				u.setValor(rs.getDouble("valor"));
				// Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				// String s = formatter.format(rs.getDate("data"));
				list.add(u);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return list;
	}

	public static int createMov(Movimentacao u) {
		int status = 0;
		status = save(u);
		updateConta(u.getContaOrigem(), u.getValor(), u.getTipo());
		return status;
	}

	public static int save(Movimentacao u) {
		int status = 0;
		try {

			Connection con = ConnectionJDBCFactory.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"insert into movimentacoes (tipo, idCliente, contaOrigem, valor) values(?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, u.getTipo());
			ps.setInt(2, u.getIdCliente());
			ps.setInt(3, u.getContaOrigem());
			ps.setDouble(4, u.getValor());
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

	public static int updateConta(int conta, double valor, String tipo) {
		int status = 0;
		try {

			String debito = "UPDATE contas SET saldo = saldo - ? WHERE numero = ?";
			String credito = "UPDATE contas SET saldo = saldo + ? WHERE numero = ?";
			Connection con = ConnectionJDBCFactory.getConnection();
			PreparedStatement ps;
			if (tipo.equals("debito"))
				ps = con.prepareStatement(debito);
			else
				ps = con.prepareStatement(credito);

			ps.setDouble(1, valor);
			ps.setInt(2, conta);
			status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public static List<Relatorio> getMovimentacoes(int id) {

		List<Relatorio> list = new ArrayList<Relatorio>();

		Relatorio u = new Relatorio();
		try {
			Connection con = ConnectionJDBCFactory.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from movimentacoes where idCliente = " + id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				if (rs.getString("tipo").equals("debito"))
					u.setDebito(1);
				else
					u.setCredito(1);

				u.setValor(rs.getDouble("valor"));
				// Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				// String s = formatter.format(rs.getDate("data"));
			}

			PreparedStatement ts = con.prepareStatement("select * from contas where idCliente = " + id);
			ResultSet rst = ts.executeQuery();

			while (rst.next()) {				
				u.setSaldoatual(rst.getDouble("saldo"));
				// Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				// String s = formatter.format(rs.getDate("data"));
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		list.add(u);
		return list;
	}

	public static String getEnderecoCliente(int id) {
		String endereco = "";
		try {
			Connection con = ConnectionJDBCFactory.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from endereco where codCliente = " + id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				endereco += rs.getString("enderecoCompleto");
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return endereco;
	}
	
	public static String getCliente(int id) {
		String nome = "";
		try {
			Connection con = ConnectionJDBCFactory.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from clientes where id = " + id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				nome += rs.getString("nome");
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return nome;
	}
}
