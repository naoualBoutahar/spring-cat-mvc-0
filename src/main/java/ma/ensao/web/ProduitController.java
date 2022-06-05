package ma.ensao.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	//@RequestParam demande au dispatcher servlet dutiliser la meth getParam pour trouver parametre  page et laffecter a p
	public String index(Model model,
			@RequestParam(name="page",defaultValue="0")int p,
			@RequestParam(name="size",defaultValue="5")int s,
			@RequestParam(name="mc",defaultValue="")String mc
			){
		Page <Produit> pageProduits=produitRepository.chercher("%"+mc+"%",PageRequest.of(p,s));
		model.addAttribute("listProduits",pageProduits.getContent());
		int[] pages=new int[pageProduits.getTotalPages()];
		model.addAttribute("pages",pages);
		model.addAttribute("size",s);
		model.addAttribute("pageCourante",p);
		model.addAttribute("motCle",mc);		
		return "produits";
	}
}
