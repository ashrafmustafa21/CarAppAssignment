package org.wit.dealerApp.console.controllers

import mu.KotlinLogging
import org.wit.dealerApp.console.models.CarJSONStore
import org.wit.dealerApp.console.models.CarModel
import org.wit.dealerApp.console.views.CarView

class CarController {

    val cars = CarJSONStore()
    val carView = CarView()
    val logger = KotlinLogging.logger {}

    init {
        logger.info { "Launching Car Console App" }
        println("Car Kotlin App Version 3.0")
    }

    fun start() {
        var input: Int

        do {
            input = menu()
            when (input) {
                1 -> add()
                2 -> update()
                3 -> list()
                4 -> search()
                5 -> delete()
                -1 -> println("Exiting App")
                else -> println("Invalid Option")
            }
            println()
        } while (input != -1)
        logger.info { "Shutting Down Car Console App" }
    }

    fun menu() :Int { return carView.menu() }

    fun add(){
        var aCar = CarModel()

        if (carView.addCarData(aCar))
            cars.create(aCar)
        else
            logger.info("Car Not Added")
    }


    fun list() {
        carView.listCars(cars)
    }

    fun update() {

        carView.listCars(cars)
        var searchId = carView.getId()
        val aCar = search(searchId)

        if(aCar != null) {
            if(carView.updateCarData(aCar)) {
                cars.update(aCar)
                carView.showCar(aCar)
                logger.info("Car Updated : [ $aCar ]")
            }
            else
                logger.info("Car Not Updated")
        }
        else
            println("Car Not Updated...")
    }

    fun search() {
        val aCar = search(carView.getId())!!
        carView.showCar(aCar)
    }


    fun search(id: Long) : CarModel? {
        var foundCar = cars.findOne(id)
        return foundCar
    }

    fun delete() {
        carView.listCars(cars)
        var searchId = carView.getId()
        val aCar = search(searchId)

        if(aCar != null) {
            cars.delete(aCar)
            println("Car Deleted...")
            carView.listCars(cars)
        }
        else
            println("Car Not Deleted...")
    }
}