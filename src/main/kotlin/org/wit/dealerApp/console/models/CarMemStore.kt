package org.wit.dealerApp.console.models

import mu.KotlinLogging

private val logger = KotlinLogging.logger {}
var lastId = 0L

internal fun getId(): Long {
    return lastId++
}

class CarMemStore : CarStore {

    val cars = ArrayList<CarModel>()

    override fun findAll(): List<CarModel> {
        return cars
    }

    override fun findOne(id: Long) : CarModel? {
        var foundCar: CarModel? = cars.find { p -> p.id == id }
        return foundCar
    }

    override fun create(car: CarModel) {
        car.id = getId()
        cars.add(car)
        logAll()
    }

    override fun update(car: CarModel) {
        var foundCar = findOne(car.id!!)
        if (foundCar != null) {
            foundCar.make = car.make
            foundCar.model = car.model
            foundCar.year = car.year
        }
    }

    override fun delete(car: CarModel) {
        cars.remove(car)
    }

    internal fun logAll() {
        cars.forEach { logger.info("${it}") }
    }
}