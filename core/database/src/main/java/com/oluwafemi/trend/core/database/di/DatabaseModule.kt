package com.oluwafemi.trend.core.database.di

import android.content.Context
import androidx.room.Room
import com.oluwafemi.trend.core.database.TrendDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): TrendDatabase =
        Room.databaseBuilder(
            context = context,
            klass = TrendDatabase::class.java,
            name = "trend-db"
        ).build()

}