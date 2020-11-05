package org.wit.dealerApp.console.controllers

import mu.KotlinLogging
import org.wit.dealerApp.console.models.CarJSONStore
import org.wit.dealerApp.console.models.CarModel
import org.wit.dealerApp.console.views.AddCarScreen
import org.wit.dealerApp.console.views.ListCarScreen
import org.wit.dealerApp.console.views.MenuScreen
import tornadofx.*

class CarUIController : Controller() {

    val cars = CarJSONStore()
    val logger = KotlinLogging.logger {}

    init {
        logger.info { "Launching BMM CARS TornadoFX UI App" }
    }
    fun add(_make : String, _model : String){

        var aCar = CarModel(make = _make, model = _model)
        cars.create(aCar)
        logger.info("Car Added")
    }

    fun loadListScreen() {
        runLater {
            find(MenuScreen::class).replaceWith(ListCarScreen::class, sizeToScene = true, centerOnScreen = true)
        }
        cars.logAll()
    }

    fun loadAddScreen() {
        runLater {
            find(MenuScreen::class).replaceWith(AddCarScreen::class, sizeToScene = true, centerOnScreen = true)
        }
    }

    fun closeAdd() {
        runLater {
            find(AddCarScreen::class).replaceWith(MenuScreen::class, sizeToScene = true, centerOnScreen = true)
        }
    }
    fun closeList() {
        runLater {
            find(ListCarScreen::class).replaceWith(MenuScreen::class, sizeToScene = true, centerOnScreen = true)
        }
    }

}