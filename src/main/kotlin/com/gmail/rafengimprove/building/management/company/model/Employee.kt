package com.gmail.rafengimprove.building.management.company.model

data class Employee(
    val position: PositionType,
    val salary: Int,
    val employmentType: EmploymentType,
    val onProbation: Boolean,
    val level: LevelType,
    val onHoliday: Boolean,
    val onSickLeave: Boolean
) : Person() {}

enum class PositionType {
    REAL_ESTATE_AGENT,
    ELECTRICIAN,
    PLUMBER,
    RENOVATOR,
    MAINTENANCE_MAN,
    CLEANER,
    SALES_MANAGER,
    BUILDING_MANAGER
}

enum class EmploymentType {
    PERMANENT,
    TEMPORARY,
    FIXED_TERM,
    SEASONAL,
    FULL_TIME,
    PART_TIME,
    INDEPENDENT_CONTRACTOR,
    FREELANCER,
}

enum class LevelType {
    INTERN,
    APPRENTICE,
    JUNIOR,
    MIDDLE,
    SENIOR,
    TEAM_LEAD,
    MANAGER
}
