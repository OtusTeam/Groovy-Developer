package lesson04

import groovy.transform.ToString

@ToString(includeFields = true)
class Placement {
    def wPrice
    def booked
    def creationDate
    def category

    def isBooked() {booked}
}
