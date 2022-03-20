package ru.tinkoff.shmeleva

class ServiceCats {
    private val dollarRate = 105

    //Метод, который преобразует поля нашего класса в описание на английском,
    // а цену преобразует в валюту (курс, можно создать константой) и возвращает новую коллекцию
    // отсортированную по возрастанию цены.
    fun catsTransformation(cats: List<Cat>) =
        cats.asSequence()
            .map {
                Cat(
                    name = Transliteration.cyr2lat(it.name),
                    breed = Transliteration.cyr2lat(it.breed),
                    furType = it.furType,
                    kittyPrice = it.kittyPrice / dollarRate,
                    age = it.age
                )
            }
            .sortedBy { it.kittyPrice }
            .toList()


    //Метод, группирующий элементы списка по типу кузова или по какому-либо заранее выбранному полю
    fun catsGroupBy(cats: Collection<Cat>) = cats.groupBy { it.furType }


    //Метод, возвращающий первые 3 элемента из списка соответствующих переданному условию
    // (переписала задание исходя из комментов лектора в телеге)
    fun catsFind(cats: Collection<Cat>) =
        cats.asSequence()
            .filter { it.kittyPrice > 24000 }
            .take(3)
            .toList()
}