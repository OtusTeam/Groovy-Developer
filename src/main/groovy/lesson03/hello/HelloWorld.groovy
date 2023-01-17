package lesson03.hello

class HelloWorld {
    private def firstName
    private def secondName

    void hello() {
        println 'hello'
        println (firstName + " " + secondName)
    }

    def doSomething(Map m) {
        doSomething m*.value
    }

    def doSomething(int one, int two) {
        firstName = one
        secondName = two
        true
    }
}
