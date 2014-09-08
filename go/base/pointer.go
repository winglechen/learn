package main

import "fmt"

func main() {
    var i,j int = 42,2701

    p := &i
    fmt.Println(*p)
    fmt.Println(p)
    fmt.Println(j)
}