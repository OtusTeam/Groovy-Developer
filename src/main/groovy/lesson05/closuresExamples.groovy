package lesson05

//['123', 12, new Date()].each { it -> print it}
def a = 'hello'

Closure<String> closure1 = { it ->
    a += 1
    print a
}

//closure1()
//a = 1
//closure1()

class Example {
    def limit
    def lambda = (a) -> {print(a)}
//    def cl = {
//        println(limit * 2)
//        limit * 2
//    }
}

def example = new Example(limit: 10)
//example.lambda()
example.limit = 20
//example.cl()

//assert example.cl in Closure
//assert example.cl() == 40
//closure1 "1"
//closure1.call("1")
//closure1.doCall("1")

def testCl = { String t ->
    'hello'
}
assert testCl.getMaximumNumberOfParameters() == 1
def params = testCl.getParameterTypes()
assert  params[0] in String
//if(testCl(12)) {
//    print("True")
//}
//switch (12) {
//    case testCl: println("TestCl")
//    default: println("Default")
//}
directory2 = new File("C:\\temp\\temp3")
directory2.mkdir()
directory = new File("C:\\temp\\")
//directory.eachFile {println it}
//directory.eachFileRecurse {
//    println "Name ${it}"
//    if (it.isFile()) {
//        it.eachLine {line -> println line}
//    }
//}

def key = {
    println 'hello'
}
def value = {
    println 'hello'
    5
}
def mapEx = [key: value, b: 3]
def x = "b"
println mapEx.key



