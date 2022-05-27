package ma.ensao.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.ensao.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit,Long>{

}
