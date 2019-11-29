package io.github.zoha131.daggerviewmodel.Repository

import javax.inject.Inject

class CloudRepository @Inject constructor(private val cloudClient: CloudClient){
    fun getName() = cloudClient.getDate()
}

interface CloudClient{
    fun getDate():String
}

class CloudClientImp @Inject constructor(): CloudClient{
    override fun getDate(): String {
        return "Awesome Dagger => Simple Dagger"
    }

}