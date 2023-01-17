package lesson04

def test(String a, String b) {
    "a=$a, b=$b"
}
def test(Map m) {
    test m*.value
    //test(["aa", "bb"])
}

assert test(a: "aa", b:"bb") == "a=aa, b=bb"
assert test(b: "aa", a:"bb") != "a=aa, b=bb" // should be false :-(
assert test(b: "ccc", a:"ddd") == "a=ddd, b=ccc" // should have worked :-(
