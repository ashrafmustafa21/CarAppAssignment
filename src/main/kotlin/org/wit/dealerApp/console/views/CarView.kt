package org.wit.dealerApp.console.views

import org.wit.dealerApp.console.models.CarJSONStore
import org.wit.dealerApp.console.models.CarModel

class CarView {

    fun menu() : Int {

        var option : Int
        var input: String?

        println("BMM CARS")
        println("MAIN MENU")
        println(" 1. Add a car")
        println(" 2. Update car details")
        println(" 3. List All cars")
        println(" 4. Search for a cars")
        println(" 5. Delete a car")
        println("-1. Exit")
        println()
        print("Enter your Option : ")
        input = readLine()!!
        option = if (input.toIntOrNull() != null && !input.isEmpty())
            input.toInt()
        else
            -9
        return option
    }

    fun listCars(cars : CarJSONStore) {
        println("List All cars")
        println()
        cars.logAll()
        println()
    }

    fun showCar(car : CarModel) {
        if(car != null)
            println("car Details [ $car ]")
        else
            println("car Not Found...")
    }

    fun addCarData(car : CarModel) : Boolean {

        println()
        print("Enter a make : ")
        car.make = readLine()!!
        print("Enter a model : ")
        car.model = readLine()!!

        return car.make.isNotEmpty() && car.model.isNotEmpty()
    }

    fun updateCarData(car : CarModel) : Boolean {

        var tempMake: String?
        var tempModel: String?

        if (car != null) {
            print("Enter a new make for [ " + car.make + " ] : ")
            tempMake = readLine()!!
            print("Enter a new model for [ " + car.model + " ] : ")
            tempModel = readLine()!!

            if (!tempMake.isNullOrEmpty() && !tempModel.isNullOrEmpty()) {
                car.make = tempMake
                car.model = tempModel
                return true
            }
        }
        return false
    }

    fun getId() : Long {
        var strId : String?
        var searchId : Long
        print("Enter id to Search/Update : ")
        strId = readLine()!!
        searchId = if (strId.toLongOrNull() != null && !strId.isEmpty())
            strId.toLong()
        else
            -9
        return searchId
    }
}