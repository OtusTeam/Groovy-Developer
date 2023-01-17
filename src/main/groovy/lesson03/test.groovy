package lesson03

import groovy.transform.CompileStatic

class Person {
    String name
    BigDecimal height
}

@CompileStatic
class Spread {
    def method(Person p) {
        "Name: ${p.name}, height: ${p.height}"
    }

    def method(Map m) {
        method m as Person
    }

    static void main(String[] args) {
        assert new Spread().method(name: "John", height: 1.80) ==
                "Name: John, height: 1.80"
    }
}
