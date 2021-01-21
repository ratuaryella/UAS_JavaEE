package del.ac.id.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="produk")
public class Produk{
	private int produk_id;
	private String nama_produk;
	private String jenis_produk;
	private String deskripsi_produk;
	private int harga;
	private int stok;
	
	public Produk() {
		
	}

	
	public Produk(int produk_id, String nama_produk, String jenis_produk, String deskripsi_produk, int harga, int stok) {
		
		this.produk_id = produk_id;
		this.nama_produk = nama_produk;
		this.jenis_produk = jenis_produk;
		this.deskripsi_produk = deskripsi_produk;
		this.harga = harga;
		this.stok = stok;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getProduk_id() {
		return produk_id;
	}


	public void setProduk_id(int produk_id) {
		this.produk_id = produk_id;
	}


	public String getNama_produk() {
		return nama_produk;
	}


	public void setNama_produk(String nama_produk) {
		this.nama_produk = nama_produk;
	}


	public String getJenis_produk() {
		return jenis_produk;
	}


	public void setJenis_produk(String jenis_produk) {
		this.jenis_produk = jenis_produk;
	}


	public String getDeskripsi_produk() {
		return deskripsi_produk;
	}


	public void setDeskripsi_produk(String deskripsi_produk) {
		this.deskripsi_produk = deskripsi_produk;
	}


	public int getHarga() {
		return harga;
	}


	public void setHarga(int harga) {
		this.harga = harga;
	}


	public int getStok() {
		return stok;
	}


	public void setStok(int stok) {
		this.stok = stok;
	}




	
	

	
	
	
	
}
