package ma.ensao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import ma.ensao.dao.ProduitRepository;
import ma.ensao.entities.Produit;

@SpringBootApplication
public class CatMvc0Application {

	public static void main(String[] args) {
		SpringApplication.run(CatMvc0Application.class, args);
		ApplicationContext ctx= SpringApplication.run(CatMvc0Application.class, args);
		ProduitRepository produitRepositoty= ctx.getBean(ProduitRepository.class);
		produitRepositoty.save(new Produit("Table", 100, 5));
		produitRepositoty.save(new Produit("Cahier", 10, 50));
		produitRepositoty.save(new Produit("Chaise", 70, 17));
		produitRepositoty.save(new Produit("Tasse", 56, 32));
		produitRepositoty.save(new Produit("Nappe", 30, 27));	
		produitRepositoty.findAll().forEach(p->System.out.println(p.getId()+" "+ p.getDesignation() +" "+p.getPrix()+" "+p.getQuantite()));
	
	}

}
