package com.example.discosapp.data

import android.content.Context

//Primero hay hacer Dao, Repoitory último AppContaniner
class AppContainer(context: Context) {
    private val appDatabase = AppDatabase.getDatabase(context)
    private val discoDao = appDatabase.discoDao()
    private val discoRepository = DiscoRepositoryImpl(discoDao)

    fun provideDiscoRepository(): DiscoRepository = discoRepository
}