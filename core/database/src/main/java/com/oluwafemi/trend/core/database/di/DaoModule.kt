package com.oluwafemi.trend.core.database.di

import com.oluwafemi.trend.core.database.TrendDatabase
import com.oluwafemi.trend.core.database.dao.NoteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {

    @Provides
    fun provideNoteDao(
        trendDatabase: TrendDatabase
    ): NoteDao = trendDatabase.noteDao()

}