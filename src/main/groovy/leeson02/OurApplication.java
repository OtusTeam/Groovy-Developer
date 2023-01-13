package leeson02;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import groovy.lang.GroovyShell;

import java.io.File;
import java.io.IOException;

public class OurApplication {
    public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException {
        GroovyClassLoader loader = new GroovyClassLoader();
        Class aClass = loader.parseClass(new File("RomanNumber.groovy"));
        // ...
        GroovyObject groovyObject = (GroovyObject) aClass.newInstance();
    }
}
