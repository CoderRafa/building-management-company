package com.gmail.rafengimprove.building.management.company.model.example

import com.gmail.rafengimprove.building.management.company.model.ParkingPlaceType
import com.gmail.rafengimprove.building.management.company.model.example.FilterType.COVERED
import com.gmail.rafengimprove.building.management.company.model.example.FilterType.LENGTH
import com.gmail.rafengimprove.building.management.company.model.example.FilterType.SECURED
import com.gmail.rafengimprove.building.management.company.model.example.FilterType.TYPE
import com.gmail.rafengimprove.building.management.company.model.example.FilterType.WIDTH
import java.util.*


fun test() {
    val apps = listOf<Apartment>()
    val requirements = RequiredParkingPlaceParameter(length = 10.0, width = 4.0, security = true)
    val apartmentList = apps.filter { it.requiredParkingPlace(requirements) }
    apartmentList.isNotEmpty()
}

fun Apartment.requiredParkingPlace(requiredParkingPlaceParameters: RequiredParkingPlaceParameter) =
    with(requiredParkingPlaceParameters) {
        val conditions = listOf(
            ConditionValue(LENGTH, length, parkingPlace.parkingPlaceLength),
            ConditionValue(WIDTH, width, parkingPlace.parkingPlaceWidth),
            ConditionValue(TYPE, type, parkingPlace.parkingPlaceType),
            ConditionValue(COVERED, covered, parkingPlace.covered),
            ConditionValue(SECURED, security, parkingPlace.security),
        )
        condition(
            conditions,
            prepareParkingPlaceFilters()
        )
    }

data class ConditionValue(val filterType: FilterType, val require: Any, val value: Any)

class ParkingPlaceFilter(
    val comparators: EnumMap<FilterType, ParkingParametersComparator>
) {
    fun compareAny(type: FilterType, require: Any, value: Any): Boolean {
        return comparators[type]?.compare(require, value) ?: false
    }
}

data class RequiredParkingPlaceParameter(
    val length: Double = 0.0,
    val width: Double = 0.0,
    val type: ParkingPlaceType = ParkingPlaceType.DEFAULT,
    val covered: Boolean = false,
    val security: Boolean = false,
    val condition: (
        List<ConditionValue>,
        ParkingPlaceFilter
    ) -> Boolean = defaultCondition
)

private val defaultCondition = { conditions: List<ConditionValue>,
                                 filter: ParkingPlaceFilter
    ->
    conditions.all { filter.compareAny(it.filterType, it.require, it.value) }
}

enum class FilterType {
    LENGTH, WIDTH, TYPE, COVERED, SECURED, TEST
}

fun prepareParkingPlaceFilters() =
    ParkingPlaceFilter(EnumMap<FilterType, ParkingParametersComparator>(FilterType::class.java)).apply {
        this.comparators[LENGTH] = LengthParkingParametersComparator()
        this.comparators[WIDTH] = WidthParkingParametersComparator()
        this.comparators[TYPE] = ParkingTypeParkingParametersComparator()
        this.comparators[COVERED] = CoveredParkingParametersComparator()
        this.comparators[SECURED] = SecuredParkingParametersComparator()
    }

/**
 * This interface needs for compare to properties.
 */
interface ParkingParametersComparator {
    fun compare(one: Any, two: Any): Boolean
}

/**
 * This class
 */
class LengthParkingParametersComparator : ParkingParametersComparator {
    override fun compare(one: Any, two: Any): Boolean = when {
        one as Double == 0.0 -> true
        two as Double == 0.0 -> false
        else -> one <= two && two <= one + (one * 0.2)
    }
}

class WidthParkingParametersComparator : ParkingParametersComparator {
    override fun compare(one: Any, two: Any): Boolean {
        return one as Double <= two as Double && two <= one + (one * 0.2)
    }
}

class ParkingTypeParkingParametersComparator : ParkingParametersComparator {
    override fun compare(one: Any, two: Any): Boolean {
        if (one as ParkingPlaceType == ParkingPlaceType.DEFAULT) return true
        return one == two as ParkingPlaceType
    }
}

class CoveredParkingParametersComparator : ParkingParametersComparator {
    override fun compare(one: Any, two: Any): Boolean {
        return one as Boolean == two as Boolean
    }
}

class SecuredParkingParametersComparator : ParkingParametersComparator {
    override fun compare(one: Any, two: Any): Boolean {
        return one as Boolean == two as Boolean
    }
}