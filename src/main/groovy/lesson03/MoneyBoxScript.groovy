package lesson03

interface MoneyBox
{
    def getDenomination()
    def put(banknotes) // BanknoteDto {Currency, count, Nominal}
}

enum Currency {
    RUB, USD
}

enum Nominal {
    FIFTY(50),
    HUNDRED(100)

    private final int value;

    private Nominal(int value) {
        this.value = value
    }
}

class BanknoteDto {
    Nominal nominal
    Currency currency
}

def lst = []

lst << 'Vasya'
lst.leftShift()
println(lst)



