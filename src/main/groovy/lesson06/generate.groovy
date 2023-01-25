package lesson06

import groovy.xml.MarkupBuilder
import lesson03.Marks

def builder = new MarkupBuilder()
builder.authors{
    author(name: 'test1') {
        book(title: 'test1', edition: 1)
    }

    author(name: 'test2') {
        book(title: 'test2', edition: 2)
    }
}

class Food {
    String name, mfr
    Map vitamins, minerals, serving, calories
    int totalFat, saturatedFat
}

Food food1 = new Food(name: 'vocado Dip', mfr: 'Sunnydale',
        serving: ['units': 'g', 'value': 29]
)

def nutritionBuilder = new MarkupBuilder(new FileWriter('result.xml'))

def foodBuilder(nutritionBuilder, food) {
    nutritionBuilder.'food' {
        name(food.name)
        mfr(food.mfr)
        serving(units: food.serving.units, food.serving.value)
    }
}

nutritionBuilder.nutrition {
    'dally-values' {

    }
    foodBuilder(nutritionBuilder, food1)
}

println nutritionBuilder.toString()



