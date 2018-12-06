package br.com.duxus.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.ioc.Component;
import br.com.duxus.model.Produto;

@Component
public class ProdutoDao {

	private final Session session;

	public ProdutoDao(Session session) {
		this.session = session;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Produto> listaTudo() {
		return this.session.createCriteria(Produto.class).list();
	}
	
	public Produto criaProduto() {
		Produto produto = new Produto();
		produto.setNome("Prateleira");
		produto.setDescricao("Uma prateleira para livros");
		produto.setPreco(35.90);
		return produto;
	}
	
	public void salva(Produto produto) {
		Transaction tx = session.beginTransaction();
		session.save(produto);
		tx.commit();
	}
	
	public void remover(Produto produto) {
		Transaction tx = session.beginTransaction();
		session.delete(produto);
		tx.commit();
	}
	
	public void atualiza(Produto produto) {
		Transaction tx = session.beginTransaction();
		session.update(produto);
		tx.commit();
	}

	public Produto carrega(Long id) {
		
		return (Produto) this.session.load(Produto.class, id);
	}

}