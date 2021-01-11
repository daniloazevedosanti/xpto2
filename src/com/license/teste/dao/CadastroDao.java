package com.license.teste.dao;

import com.license.teste.model.Cadastro;
import com.license.teste.model.Cliente;
import com.license.teste.model.Endereco;

public class CadastroDao {

	public static int save(Cadastro u) {
		int status = 0;
		try {
			//insert client
			Cliente cliente = new Cliente(u.getNome(), u.getDocumento(), u.getTipo(), u.getTelefone());
			int idCliente = ClienteDao.save(cliente);
			
			//insert address
			Endereco endCad = new Endereco(u.getEnderecoCompleto(), idCliente);
			int idEndereco = EnderecoDao.save(endCad);
			
			//update keys
			int update = EnderecoDao.updateForegKey(idCliente, idEndereco);
			int update2 = ClienteDao.updateForegKey(idCliente, idEndereco);
			
			status = update2 + update;
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
}
