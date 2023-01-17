package lesson04

class Payee {}

class Agency {
    def payees
}

class Period {
    def payee
}

//Java way
Payee findPayee(Payee payee){
    if (payee != null) {
        return payee;
    }
    if (getPrevInYear() != null
            && getPrevInYear().getPayee() != null) {
        return prevInYear.getPayee();
    }
    return getAgency().getPayees().iterator().next();
}

Period getPrevInYear() {
    return new Period();
}

Agency getAgency() {
    return new Agency();
}

// Groovy way
def agency
def payee


