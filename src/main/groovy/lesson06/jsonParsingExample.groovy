package lesson06
import groovy.xml.XmlParser
import groovy.json.JsonSlurper
import groovy.yaml.YamlSlurper

def jsonSlurper = new JsonSlurper()

assert jsonSlurper.parseText("""
[]
""") instanceof  List

assert jsonSlurper.parseText("""
1
""") instanceof  Integer

def object = jsonSlurper.parse(new File("test.json"))

assert object instanceof Map

println object.address.company.phoneNumbers[0]

println new YamlSlurper().parse(new File("test.yml")).application
