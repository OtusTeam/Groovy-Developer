package lesson12

import groovy.transform.ToString

@ToString(cache = true, includeFields = true)
class Foo {
  String bar;

  @Loggable
  @Override
  def doSomething() {
    this.println('Starting doSomething')
    print "do something"
    this.println('Starting doSomething')
  }
}

new Foo().doSomething()

@Newify([Foo])
@ToString(cache = true, includeFields = true)
class FooBuilder {
  Foo foo1 = Foo(bar: "hello")
  Foo foo2= Foo(bar: "hello")
  Foo foo3 = Foo(bar: "hello2")
}

print(new FooBuilder())
//Foo foo1 = Foo(bar: "hello")
//Foo foo2= Foo(bar: "hello")
//Foo foo3 = Foo(bar: "hello2")
//
//def result1 = foo1.toString()
//def result2 = foo2.toString()
//
//println(result1.hashCode())
//print(result2.hashCode())
//
//assert  result1 == result2
//assert  result1.is(result2)
