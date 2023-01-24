package lesson05

class Employee {
    String name
    int hourlyRate
    int numHoursWorkedPerWeek
    int numOfSalesPerYear
}

// our system script
def totalSalary = {salaryCl, bonusesCl, employee ->
    salaryCl(employee) + bonusesCl(employee)
}

def salaryCl = {
    it.hourlyRate * it.numHoursWorkedPerWeek
}

def  bonusesCl = {
    it.numOfSalesPerYear * 100
}
totalSalary = totalSalary.curry(salaryCl, bonusesCl)

// customer's script
def employee = new Employee(name: 'Vasya', hourlyRate: 25, numHoursWorkedPerWeek: 40, numOfSalesPerYear: 100)
println totalSalary(employee)


