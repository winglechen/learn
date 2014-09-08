package main

import "fmt"

type Vertex struct {
    X, Y int
}

func (this *Vertex) ShowX() {
    fmt.Println(this.X)
}


func main () {
    v := Vertex{2,4}
    v.ShowX()
}

