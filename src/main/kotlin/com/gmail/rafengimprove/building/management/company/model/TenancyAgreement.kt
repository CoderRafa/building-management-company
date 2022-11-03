package com.gmail.rafengimprove.building.management.company.model

import java.time.LocalDate

data class TenancyAgreement(
    val landlord: Person,
    val tenant: Person,
    val apartment: Apartment,
    val rentAmount: Double,
    val rentalTerm: RentalTermType,
    val rentedFrom: LocalDate,
    val rentedTo: LocalDate,
    val paymentDate: String,
    val numberOfOccupants: Int,
    val rulesOfTenancy: String
){}

enum class RentalTermType {
    DAILY,
    SHORT_TERM,
    LONG_TERM
}