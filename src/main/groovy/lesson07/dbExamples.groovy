package lesson07

import com.zaxxer.hikari.HikariDataSource
import groovy.sql.DataSet
import groovy.sql.Sql
import groovy.xml.MarkupBuilder

class Employee {
    def firstName, secondName
}

connection = Sql.newInstance("\"jdbc:postgresql://localhost:5430/demoDB", "root", "root",
"org.postgresql.Driver"
)

connection = new Sql(new HikariDataSource())

connection.execute("""
    DROP TABLE IF EXISTS employees;
    CREATE TABLE employees(
        id SEQUENCE PRIMARY KEY,
        first_name VARCHAR(60),
        second_name  VARCHAR(60)
    );
""")

def empls = [firstName: 'Petr', secondName: 'Ivanov']

def empls2 = [['Petr', 'Ivanov']]

connection.execute("""
    INSERT INTO employees(first_name, second_name) VALUES($empls.firstName, $empls.secondName)
""")

connection.execute("""
    UPDATE employees SET second_name = 'Petrov' WHERE id = 1
""")

connection.rows("select fisrt_name, second_name from employees").each {
    println (it.first_name + " " + it.second_name)
}

connection.query("select fisrt_name, second_name from employees") {
    def metaData = it.metaData

    metaData.getTableName(1)
    metaData.columnCount
    metaData.getColumnLabel(1)
}

//language=SQL
String stm = "INSERT INTO employees(first_name, second_name) VALUES(?, ?)"

connection.execute stm, ['Petr', 'Ivanov']

empls.each {
    connection.execute(stm, it)
}

def html = new MarkupBuilder()
html.html {
    head {
        title "Employees report"
    }
    body {
        h1 "Employees"
        table {
            th('first name')
            th('second name')
            connection.eachRow('select fisrt_name, second_name from employees') {
                tr {
                    td (it.first_name)
                    td (it.second_name)
                }
            }
        }
    }
}

connection.execute("""
    DROP TABLE IF EXISTS departments;
    CREATE TABLE departments(
        id SEQUENCE PRIMARY KEY,
        name VARCHAR(60)
    );
""")

//language=SQL
String stm2 = "INSERT INTO departments(name) VALUES(?)"
connection.execute stm2, ['IT']

connection.execute("""
    ALTER TABLE employees
    ADD dpartment_id INTEGER
    ADD FOREIGN KEY  (department_id) REFERENCES departments(id)
""")

def dataSet = new DataSet(connection, 'employees')
dataSet.add(first_name: 'Vasya', second_name: 'Ivanov')
dataSet.each {
    println (it.first_name + " " + it.second_name)
}
dataSet.findAll{
    it.first_name == 'Petya'
}

