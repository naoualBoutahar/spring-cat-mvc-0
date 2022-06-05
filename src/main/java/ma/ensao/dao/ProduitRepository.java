package ma.ensao.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.ensao.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit,Long>{
//Pageable necessair puisquon a pagination
	//HQL
	@Query("select p from Produit p where p.designation like :x")
	public Page<Produit> chercher(@Param("x")String mc,Pageable pageable);
}
