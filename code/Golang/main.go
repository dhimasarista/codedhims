package main

import (
	"fmt"
	"runtime"
	"sync"
	"time"
)

func main() {
	n := 40
	loops := 10

	fmt.Println("===== Goroutines =====")
	runMultipleFibWithGoroutines(loops, n)
}

// Fibonacci recursive (CPU-bound)
func fib(n int) int {
	if n <= 1 {
		return n
	}
	return fib(n-1) + fib(n-2)
}

func runMultipleFibWithGoroutines(loops, n int) {
	var wg sync.WaitGroup
	startTime := time.Now()

	runtime.GC()
	beforeMemory := getUsedMemory()
	fmt.Printf("Before memory (Goroutines): %.2f MB\n", float64(beforeMemory)/1024/1024)

	for i := 0; i < loops; i++ {
		wg.Add(1)
		go func(index int) {
			defer wg.Done()
			start := time.Now()
			result := fib(n)
			duration := time.Since(start)
			fmt.Printf("Goroutine %d: Result: %d, Time: %d ms\n", index, result, duration.Milliseconds())
		}(i)
	}

	wg.Wait()

	runtime.GC()
	afterMemory := getUsedMemory()
	totalTime := time.Since(startTime)

	fmt.Printf("After memory (Goroutines): %.2f MB\n", float64(afterMemory)/1024/1024)
	fmt.Printf("Goroutines total time: %d ms\n", totalTime.Milliseconds())
	fmt.Printf("Memory used by Goroutines: %.2f MB\n", float64(afterMemory-beforeMemory)/1024/1024)
}

// Get used heap memory
func getUsedMemory() uint64 {
	var memStats runtime.MemStats
	runtime.ReadMemStats(&memStats)
	return memStats.Alloc
}
