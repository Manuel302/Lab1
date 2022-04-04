package com.tec.lab1.services

interface IMaintenanceService {
    fun getColumns(): Array<String>
    fun getData(): Array<Array<String>>
}