package org.wit.dealerApp.console.views

import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Orientation
import org.wit.dealerApp.console.controllers.CarUIController
import tornadofx.*
import kotlin.reflect.KClass

class AddCarScreen : View("Add car") {
    val model = ViewModel()
    val _make = model.bind { SimpleStringProperty() }
    val _model = model.bind { SimpleStringProperty() }
    val carUIController: CarUIController by inject()

    override val root = form {
        setPrefSize(600.0, 200.0)
        fieldset(labelPosition = Orientation.VERTICAL) {
            field("Make") {
                textfield(_make).required()
            }
            field("Model") {
                textfield(_model).required()
            }
            button("Add") {
                enableWhen(model.valid)
                isDefaultButton = true
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        carUIController.add(_make.toString(),_model.toString())

                    }
                }
            }
            button("Close") {
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        carUIController.closeAdd()
                    }
                }
            }
        }
    }

    override fun onDock() {
        _make.value = ""
        _model.value = ""
        model.clearDecorators()
    }
}