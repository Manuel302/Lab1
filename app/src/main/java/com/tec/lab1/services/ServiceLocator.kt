package com.tec.lab1.services

object ServiceLocator {
    fun getMaintenanceService(): IMaintenanceService = CoursesService()
}
