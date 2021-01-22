package main

import (
	"log"
	"net/http"
)

func getMakanan(w http.ResponseWriter, r *http.Request) {
	var makanan Makanan
	var arrmakanan []Makanan

	db := connect()
	defer db.Close()

	rows, err := db.Query("Select * from makanan")
	if err != nil {
		log.Print(err)
	}

	for rows.Next() {
		if err := rows.Scan(&makanan.ID, &makanan.Makanan, &makanan.Harga, &makanan.Gambar); err != nil {
			log.Fatal(err.Error())
		} else {
			arrmakanan = append(arrmakanan, makanan)
		}
	}

	w.Header().Set("Content-Type", "application/json")
}
