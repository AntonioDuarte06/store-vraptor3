package br.com.duxus.testes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.duxus.dao.ProdutoDao;
import br.com.duxus.infra.CriadorDeSession;
import br.com.duxus.infra.CriadorDeSessionFactory;

public class RemocaoDeProduto {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new CriadorDeSessionFactory().getInstance();
		
		Session session = new CriadorDeSession(factory).getInstance();
		
		new ProdutoDao(session).remover(null);
	}

}
