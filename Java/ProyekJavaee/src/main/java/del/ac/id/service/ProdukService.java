package del.ac.id.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import del.ac.id.repository.*;
import del.ac.id.model.*;

@Service
@Transactional
public class ProdukService {
	@Autowired
	ProdukRepository produksrepository;
	public List<Produk> listAllProduk() {
		return produksrepository.findAll();
	}
	public void saveProduk(Produk produks) {
		produksrepository.save(produks);
	}
	public Produk getProduks(Integer id) {
		return produksrepository.findById(id).get();
	}
	public void deleteProduks(Integer id) {
		produksrepository.deleteById(id);
	}
}
