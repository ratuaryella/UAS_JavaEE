package main

//Makanan define
type Makanan struct {
	ID      int    `json:"id"`
	Makanan string `json:"makanan"`
	Harga   int    `json:"harga"`
	Gambar  string `json:"gambar"`
}
