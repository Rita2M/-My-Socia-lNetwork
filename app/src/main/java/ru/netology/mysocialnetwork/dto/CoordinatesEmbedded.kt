package ru.netology.mysocialnetwork.dto


data class CoordinatesEmbedded(
    var lat: Double,
    var long: Double,

){

    constructor() : this(0.0, 0.0)


}
