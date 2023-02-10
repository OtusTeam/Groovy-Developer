package lesson11

import groovy.json.JsonSlurper
import groovy.transform.ToString

class Employee implements GroovyInterceptable {
    Integer id
    String userName
    String firstName
    String lastName
    String middleName
    String employeeNumber
    String email
    String dateOfBirth
    Integer positionId

//    def methodMissing(String name, def args) {
//        return "this is me"
//    }
//
//    def storage = [:]
//    def propertyMissing(String name, value) { storage[name]}
//    def propertyMissing(String name) { storage[name] }
//
//    def bar() {
//        println 'I was bar'
//    }
//
//    Object invokeMethod(String name, Object args) {
//        println 'I was invoked'
//    }
}

//def employee = new Employee()
//
//keys = ['userName', 'lastName']
//for (key in keys) {
//    employee[key] = 'abc'
//}
//
//employee.foo()
//employee.bar()


//
//Email.email {
//    from: 'user@user.com'
//    to: 'user@user.com'
//    subject: 'subject'
//    body: 'body'
//}
def parse1 = new JsonSlurper().parseText('[{"id ":1," name ":" Vasa "},{" id ":2," name ":" Petya "}]')
def parse2 = new JsonSlurper().parseText('[{"id":3,"name":"Misha"},{"id":4,"name":"Ilya"}]')
assert parse1 instanceof List


// DelegatingScript script
// sript.delegate = new Email()
// script.run()

