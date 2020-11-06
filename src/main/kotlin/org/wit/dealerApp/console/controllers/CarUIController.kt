package org.wit.dealerApp.console.controllers

import mu.KotlinLogging
import org.wit.dealerApp.console.models.CarJSONStore
import org.wit.dealerApp.console.models.CarModel
import org.wit.dealerApp.console.views.AddCarScreen
import org.wit.dealerApp.console.views.ListCarScreen
import org.wit.dealerApp.console.views.UpdateCarScreen
import org.wit.dealerApp.console.views.DeleteCarScreen
import org.wit.dealerApp.console.views.MenuScreen
import tornadofx.*

class CarUIController : Controller() {

    val cars = CarJSONStore()
    val logger = KotlinLogging.logger {}

    init {
        logger.info { "Launching BMM CARS TornadoFX UI App" }
    }
    fun add(_make : String, _model : String, _year : String){

        var aCar = CarModel(make = _make, model = _model, year = _year)
        cars.create(aCar)
        logger.info("Car Added")
    }

    fun loadAddScreen() {
        runLater {
            find(MenuScreen::class).replaceWith(AddCarScreen::class, sizeToScene = true, centerOnScreen = true)
        }
    }

    fun loadListScreen() {
        runLater {
            find(MenuScreen::class).replaceWith(ListCarScreen::class, sizeToScene = true, centerOnScreen = true)
        }
        cars.logAll()
    }

    fun loadUpdateScreen() {
        runLater {
            find(MenuScreen::class).replaceWith(UpdateCarScreen::class, sizeToScene = true, centerOnScreen = true)
        }
        cars.logAll()
    }

    fun loadDeleteScreen() {
        runLater {
            find(MenuScreen::class).replaceWith(DeleteCarScreen::class, sizeToScene = true, centerOnScreen = true)
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
    fun closeUpdate() {
        runLater {
            find(UpdateCarScreen::class).replaceWith(MenuScreen::class, sizeToScene = true, centerOnScreen = true)
        }
    }
    fun closeDelete() {
        runLater {
            find(DeleteCarScreen::class).replaceWith(MenuScreen::class, sizeToScene = true, centerOnScreen = true)
        }
    }

}