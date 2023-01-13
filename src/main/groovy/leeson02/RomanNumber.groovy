package leeson02

class RomanNumber {
    def number;

    RomanNumber(number) {
        this.number = number
    }

    static def numbers = ["I", 'II', 'III', 'IV', 'V']

    RomanNumber plus(RomanNumber other) {
        Integer res = numbers.indexOf(other.number.toUpperCase()) + numbers.indexOf(number.toUpperCase())
        if (res > 5) {
            throw new UnsupportedOperationException("Sorry sum of the numbers can't be more than 5")
        }
        number = numbers[res]
        new RomanNumber(number)
    }

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
        def romanNumber2 = new RomanNumber('II')
        romanNumber++
        romanNumber = romanNumber + romanNumber2
        println (romanNumber.number)
    }
}
