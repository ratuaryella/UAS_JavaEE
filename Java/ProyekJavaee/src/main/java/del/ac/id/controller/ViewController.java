package del.ac.id.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;
import del.ac.id.model.Produk;

@Controller
public class ViewController {
	@RequestMapping("/view-produk")
	public String viewUsers() {
		return "view-produk";
	}
	
	@RequestMapping("/add-produk")
	public String addUsers() {
		return "add-produk";
	}
	
	@RequestMapping("/add-pulsa")
	public String addPulsa() {
		return "pesan-pulsa";
	}
	
	@RequestMapping("/delete-produk/{produk_id}")
	public RedirectView deleteProduk(@PathVariable Integer produk_id) {
		final String uri = "http://localhost:8080/produks/"+produk_id;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri);
		return new RedirectView("/view-produk");
	}
	
	@GetMapping("/update-produk/{produk_id}")
	public String updateProduk(@PathVariable("produk_id") Integer produk_id ,Model model) {
		final String uri = "http://localhost:8080/produks/"+produk_id;
		RestTemplate restTemplate = new RestTemplate();
		Produk result = restTemplate.getForObject(uri, Produk.class);
		model.addAttribute("message", "Baeldung");
		model.addAttribute("Produk", result);
		
		return "update-produk";
	}
	
	@PostMapping("/update-produk")
	public String updateProdukSubmit(@ModelAttribute Produk produk, Model model) {
		final String uri = "http://localhost:8080/produks/"+produk.getProduk_id();
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(uri, produk);		
		model.addAttribute("bla", produk);
		return "/view-produk";
	}
	
}
