package main

import "fmt"

type Vertex struct {
    X int
    Y int
}

func main() {
    v := Vertex{1,2}
    p := &v
    p.X = 888
    fmt.Println(v)
    fmt.Println(v.X)
    fmt.Println(p.X)
}