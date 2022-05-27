package ma.ensao.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import ma.ensao.dao.ProduitRepository;
import ma.ensao.entities.Produit;

@Controller
public class ProduitController {
	
	@Autowired
	/*cette annotation pour demander au IOC dinjecter un obj de type produitRepository :
	cherche moi une classe que tu a s deja instancie 
	et qui implemente linterface ProduitRepository +injecte la */
	private ProduitRepository produitRepository;
	
	//quand je tape http://localhost/index ->executer la meth index
	@RequestMapping(value = "/index")
	//meth qui retourne le nom d la vue qui sera envoyee
	public String index(Model model) {
		List<Produit> produits=produitRepository.findAll();
		model.addAttribute("listProduits",produits);
		return "produits";
	}
}
