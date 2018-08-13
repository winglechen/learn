class Person {
    String name

    String greet(String otherPerson) {
        "Hello ${otherPerson}"    
    }
}


def p1 = new Person(name: "张三")

println p1.greet("World");
    
