package org.wit.dealerApp.console.views

import org.wit.dealerApp.console.controllers.CarUIController
import org.wit.dealerApp.console.models.CarModel
import tornadofx.*

class ListCarScreen : View("List cars") {

    val carUIController: CarUIController by inject()
    val tableContent = carUIController.cars.findAll()
    val data = tableContent.observable()


    override val root = vbox {
        setPrefSize(600.0, 200.0)
        tableview(data) {
            readonlyColumn("ID", CarModel::id)
            readonlyColumn("MAKE", CarModel::make)
            readonlyColumn("MODEL", CarModel::model)
        }
        button("Close") {
            useMaxWidth = true
            action {
                runAsyncWithProgress {
                    carUIController.closeList()
                }
            }
        }
    }

}