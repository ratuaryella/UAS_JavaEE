package del.ac.id.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import del.ac.id.service.*;
import del.ac.id.model.Produk;

@RestController
@RequestMapping("/produks")
public class ProdukController {

	@Autowired
	ProdukService produkService;
	
	@GetMapping("")    
	public List<Produk> list() {         
		return produkService.listAllProduk();     
	} 
	
	@GetMapping("/{produk_id}")
	public ResponseEntity<Produk> get(@PathVariable Integer produk_id) {
		try {
			Produk produk = produkService.getProduks(produk_id);
			return new ResponseEntity<Produk>(produk, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Produk>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/")
	public void add(@RequestBody Produk produk) {
		produkService.saveProduk(produk);
	}

	@PutMapping("/{produk_id}")
	public ResponseEntity<?> update(@RequestBody Produk produk, @PathVariable Integer produk_id) {
		try {
			Produk existProduk = produkService.getProduks(produk_id);
			produk.setProduk_id(produk_id);
			produkService.saveProduk(produk);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{produk_id}")
	public ResponseEntity<String> delete(@PathVariable Integer produk_id) {
		produkService.deleteProduks(produk_id);;
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}
