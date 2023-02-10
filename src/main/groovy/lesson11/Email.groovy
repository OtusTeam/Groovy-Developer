package lesson11

import groovy.transform.ToString

@ToString(includeFields = true)
class Email {
    String from, to, subject, body

    def methodMissing(String name, def args) {
        Closure cl = ((Object[])args)[0]
        cl.setDelegate(this)
        cl.call()
    }

//    static def email (Closure cl) {
//        def delegate = new Email()
//        cl.setDelegate(delegate)
//        cl.setResolveStrategy(Closure.DELEGATE_FIRST)
//        cl.call()
//    }
}
