package lesson03

import lesson03.hello.HelloWorld

//import lesson03.hello.HelloWorld as HelloWorldEn

//class HelloWorld extends HelloWorldEn {
//    void hello() {
//        println 'holla'
//    }
//}

class Lesson4 {
    static void main(String[] args) {
//        def str = "hello"
//        println(str.center(7, '*' ))
//        println str.padLeft(7, '*')
//       println  str.padRight(7, '*')
//       def arr = new  int[5]
//        println arr.size()


//        def back = 'back'
//        def quotes = ["I’ll be $back",
//                      "I’ll be ${-> back}",
//                      "I’ll be ${back}",
//                      "Ill be " + back]
//
//        println quotes
//        back = "bach"
//        println quotes

        //def beast = '6' * Math.PI
        //def beast = '6' * '3'
        // abc - b = ac
        //def beast = '667' - 1
//        def beast = '6' + '6' + 0 + 6
//        def m(Map args=[:], String s, int n, int x=1)

        HelloWorld helloWorld = new HelloWorld(firstName: 'Vasya', secondName: 'Vasya')
        helloWorld.hello()
        println helloWorld.doSomething(two: 1l, one: 2l)
    }
}

trait EatableTrait {
    def weight

    def eat() {
        print("eat")
    }
}

Cat cat = new Cat();
def cat2 = cat.withTraits(EatableTrait)
cat2.eat()
