package com.example.myapplication

import BaseClasses.BaseLifecycleModel
import java.util.*
import kotlin.properties.ObservableProperty


class SampleViewModel : BaseLifecycleModel() {

    val list = listOf<Sample>()


    fun determineProviders( list: List<Sample>) {
        when(list.size) {
            1 -> showOneProvider()
            2 -> showTwoProviders()
        }
    }

    private fun showTwoProviders() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun showOneProvider() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun checkParticularStatus(list: List<Sample>, status: List<String>) {

        list.forEach { it -> {

        } }
    }

}

class Sample(var status:String, var provider:String )