package lesson04

import java.time.LocalDate

def placements = [
        new Placement(booked: true, wPrice: 100, creationDate: LocalDate.of(2022, 10, 20), category: 'sport'),
        new Placement(booked: false, wPrice: 123, creationDate: LocalDate.of(2021, 10, 20), category: 'it'),
        new Placement(booked: true, wPrice: 12, creationDate: LocalDate.of(2019, 10, 20), category: 'it')
]

// Java way
List bookedPlacements = new ArrayList();
for (Placement placement : placements) {
    if (placement.isBooked()) {
        bookedPlacements.add(placement);
    }
}
Collections.sort(bookedPlacements, new Comparator<Placement>() {
    int compare(Placement p1, Placement p2) {
        int r = p1.getwPrice().compareTo(p2.getwPrice());
        if (r == 0) {
            r = p1.getCreationDate()
                    .compareTo(p2.getCreationDate());
        }
        return r;
    }
});

placements.findAll {it.booked}
    .sort {o1, o2 -> o2.wPrice<=> o1.wPrice ?: o1.creationDate <=> o2.creationDate}

println placements



