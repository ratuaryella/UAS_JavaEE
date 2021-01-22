package main

import (
	"log"
	"net/http"

	_ "github.com/go-sql-driver/mysql"
	"github.com/gorilla/mux"
)

func main() {

	r := mux.NewRouter()

	//Route Handlers
	r.HandleFunc("/api/makanan", getMakanan).Methods("GET")
	// r.HandleFunc("/api/makanan/{id}", getMakanan).Methods("GET")
	log.Fatal(http.ListenAndServe(":8000", r))

}
