package com.tec.lab1.services

class CoursesService: IMaintenanceService {
    override fun getColumns(): Array<String> {
        return arrayOf("id", "name","credits")
    }

    override fun getData(): Array<Array<String>> {
        return arrayOf(
            arrayOf("01", "Intro", "4"),
            arrayOf("02", "Taller", "2"),
            arrayOf("03", "Bases", "3"),
        )
    }
}