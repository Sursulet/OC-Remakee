package com.sursulet.realestatemanager.di

import android.content.Context
import androidx.room.Room
import com.sursulet.realestatemanager.data.AppDatabase
import com.sursulet.realestatemanager.utils.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context) =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            DATABASE_NAME
        ).build()

    @Provides
    fun provideEstateDao(db: AppDatabase) = db.estateDao()

    @Provides
    fun providePhotoDao(db: AppDatabase) = db.photoDao()
}