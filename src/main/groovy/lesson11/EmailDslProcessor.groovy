package lesson11

import org.codehaus.groovy.control.CompilerConfiguration

CompilerConfiguration configuration = new CompilerConfiguration()
configuration.setScriptBaseClass(DelegatingScript.class.getName())
GroovyShell sh = new GroovyShell(this.class.getClassLoader(), new Binding(), configuration)
DelegatingScript script = sh.parse(new File('C:\\workspace\\Groovy-Developer\\src\\main\\groovy\\lesson11\\email.dsl'))
def e = new Email()
script.delegate = e
script.run()
// do something with e
