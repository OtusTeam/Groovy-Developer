package lesson03.hello

class HelloWorld {
    private def firstName
    private def secondName

    void hello() {
        println 'hello'
        println (firstName + " " + secondName)
    }

    def doSomething(long one, long two) {
        firstName = one
        secondName = two
        true
    }
}
