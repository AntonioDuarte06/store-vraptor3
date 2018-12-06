package br.com.duxus.controller;

import java.util.List;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.duxus.dao.ProdutoDao;
import br.com.duxus.model.Produto;

@Resource
public class ProdutosController {

	private final ProdutoDao dao;
	private final Result result;
	private Validator validator;

	public ProdutosController(ProdutoDao dao, Result result, Validator validator) {
		this.dao = dao;
		this.result = result;
		this.validator = validator;
	}

	@Get 
	@Path("/produtos")
	public List<Produto> lista() {
		System.out.println("lista");
		return dao.listaTudo();
	}

	@Post 
	@Path("/produtos")
	public void adiciona(final Produto produto) {

		if (produto.getNome() == null || produto.getNome().length() < 3) {
			validator.add(new ValidationMessage("Nome é obrigatório e precisa ter mais de 3 letras", "Nome do Produto "));
		}

		if (produto.getDescricao() == null || produto.getDescricao().length() > 40) {
			validator.add(new ValidationMessage("Descrição é obrigatória e precisa ter menos de 40 letras",
					"Descricao do Produto "));
		}

		if (produto.getPreco() <= 0.0) {
			validator.add(new ValidationMessage("O preço precisa ser positivo", "Preço do produto "));
		}

		validator.onErrorUsePageOf(this).formulario();

		dao.salva(produto);
		result.redirectTo(this).lista();
	}

	@Put 
	@Path("/produtos/{produto.id}")
	public void altera(Produto produto) {
		dao.atualiza(produto);
		result.redirectTo(this).lista();
	}

	@Get 
	@Path("/produtos/{id}")
	public Produto edita(Long id) {
		return dao.carrega(id);
	}

	@Delete 
	@Path("/produtos/{id}")
	public void remover(Long id) {
		Produto produto = dao.carrega(id);
		dao.remover(produto);
		result.redirectTo(this).lista();
	}

	@Get 
	@Path("/produtos/novo")
	public void formulario() {

	}
}
