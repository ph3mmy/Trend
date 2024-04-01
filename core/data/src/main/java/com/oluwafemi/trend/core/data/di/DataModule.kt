package com.oluwafemi.trend.core.data.di

import com.oluwafemi.trend.core.data.repository.DefaultNoteRepository
import com.oluwafemi.trend.core.domain.repository.NoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindsNoteRepository(noteRepository: DefaultNoteRepository): NoteRepository

}