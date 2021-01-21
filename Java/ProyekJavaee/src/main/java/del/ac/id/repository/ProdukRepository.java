package del.ac.id.repository;

import del.ac.id.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface ProdukRepository extends JpaRepository<Produk, Integer>{

}
