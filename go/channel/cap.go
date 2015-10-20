package main

import "fmt"

func main() {
    cq := make(chan int,100)
    cq <- 1
    cq <- 2
    fmt.Println(len(cq))
    fmt.Println(cap(cq))
}