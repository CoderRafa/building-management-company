package com.gmail.rafengimprove.building.management.company.model

import javax.xml.stream.Location

data class PublicTransport(
    val publicTransportType: PublicTransportType,
    val distance: Double,
    val location: Location
) {}

enum class PublicTransportType {
    BUS,
    TRAM,
    COMMUTER_RAIL,
    UNDERGROUND_TRAIN,
    TRAIN,
    MONORAIL,
    CABLE_CAR,
    FERRY,
    AIRPORT
}
