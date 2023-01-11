package leeson02

class RomanNumber {
    def number;

    RomanNumber(number) {
        this.number = number
    }

    static def numbers = ["I", 'II', 'III', 'IV', 'V']

    RomanNumber next() {
        if(number.toUpperCase() == 'V') {
            throw new UnsupportedOperationException("Sorry, we suppoort only number up to 5")
        }
        int index = numbers.indexOf(number.toUpperCase())
        if (index < 0) {
            throw new UnsupportedOperationException("Sorry, incorrect index")
        }
        number = numbers[++index]
        this

    }

    static void main(String[] args) {
       def romanNumber = new RomanNumber('I')
        5.plus()
        romanNumber = romanNumber.next()
        println (romanNumber.number)
    }
}
