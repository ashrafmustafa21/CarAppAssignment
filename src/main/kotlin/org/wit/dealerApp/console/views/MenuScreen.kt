package org.wit.dealerApp.console.views

import javafx.application.Platform
import javafx.geometry.Orientation
import javafx.scene.text.FontWeight
import org.wit.dealerApp.console.controllers.CarUIController
import tornadofx.*

class MenuScreen : View("BMM cars Main Menu") {

    val carUIController: CarUIController by inject()

    override val root = form {
        setPrefSize(400.0, 200.0)
        fieldset(labelPosition = Orientation.VERTICAL) {
            label("Welcome to BMM cars") {
                style {
                    fontWeight = FontWeight.BOLD
                    fontSize = 20.px
                }
            }

            text("")
            button("Add Car") {

                isDefaultButton = true
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        carUIController.loadAddScreen()
                    }
                }
            }

            text("")
            button("List Cars") {

                isDefaultButton = true
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        carUIController.loadListScreen()
                    }
                }
            }

            text("")
            button("Updat a Car informations") {

                isDefaultButton = true
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        carUIController.loadUpdateScreen()
                    }
                }
            }

            text("")
            button("Delete Car") {

                isDefaultButton = true
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        carUIController.loadDeleteScreen()
                    }
                }
            }
            text("")
            button("Exit") {

                isDefaultButton = true
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        Platform.exit();
                        System.exit(0);
                    }
                }
            }
        }

    }
}