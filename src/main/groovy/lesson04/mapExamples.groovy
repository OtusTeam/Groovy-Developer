package lesson04

def lst = ['foo', 'bar', 'baz']

// for each entry return a list containing [key, value]
lst.collectEntries { [it, it.toUpperCase()] } // [foo: FOO, bar: BAR, baz: BAZ]

// another option, return a map containing the single entry
lst.collectEntries { [(it): it.toUpperCase()] } // [foo: FOO, bar: BAR, baz: BAZ]

def map = [foo: 'FOO', bar: 'BAR', baz: 'BAZ']

map.collectEntries { [it.key*2, it.value*2] } // [foofoo: FOOFOO, barbar: BARBAR, bazbaz: BAZBAZ]

// using explicit arguments k and v
map.collectEntries { k, v -> [k*2, v*2] } // [foofoo: FOOFOO, barbar: BARBAR, bazbaz: BAZBAZ]
