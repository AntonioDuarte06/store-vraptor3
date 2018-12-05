package br.com.duxus.infra;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

@Component
public class CriadorDeSession implements ComponentFactory<Session> {

	private final SessionFactory factory;

	@SuppressWarnings("unused")
	private Session session;

	public CriadorDeSession(SessionFactory factory) {
		this.factory = factory;
	}

	@PostConstruct
	public void abre() {
		session = factory.openSession();
	}

	public Session getInstance() {

		return session;
	}

	@PreDestroy
	public void fecha() {
		session.close();
	}

}
