package main

import (
	"fmt"
	"runtime"
)

func countElements(size int) int {
	// Membuat slice besar
	arr := make([]int, size)
	for i := 0; i < size; i++ {
		arr[i] = i + 1
	}

	// Menghitung jumlah elemen
	count := len(arr)

	// Mendapatkan statistik memori
	var m runtime.MemStats
	runtime.ReadMemStats(&m)

	// Menampilkan penggunaan memori
	fmt.Printf("Penggunaan Memori: %v bytes\n", m.Alloc)

	return count
}

func main() {
	// Tentukan ukuran array
	size := 1000000
	fmt.Printf("Jumlah elemen: %d\n", countElements(size))
}
