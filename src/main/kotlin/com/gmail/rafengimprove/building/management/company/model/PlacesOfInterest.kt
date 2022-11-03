package com.gmail.rafengimprove.building.management.company.model

import javax.xml.stream.Location

data class PlacesOfInterest(
    val placeOfInterestType: List<PlaceOfInterestType>,
    val publicTransport: List<PublicTransport>,
    val name: String,
    val location: Location,
    val distance: Double
) {}

enum class PlaceOfInterestType {
    SUPERMARKET,
    MALL,
    RESTAURANT,
    COFFEE_SHOP,
    PUB,
    PARK,
    PLAYGROUND,
    KINDERGARTEN,
    SCHOOL
}
