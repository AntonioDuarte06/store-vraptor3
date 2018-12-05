package br.com.duxus.controller;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.Resource;

@Resource
public class Mundo {
	public String boasVindas() {
		return "Olá mundo - return";
	}
	
	public List<String> paises(){
		List<String> result = new ArrayList<String>();

		result.add("Brasil");
		result.add("Portugal");
		result.add("Japão");
		result.add("Canadá");
		result.add("Paraguai");
		
		return result;
	}
}
