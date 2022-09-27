package com.test.empowerment.labs.infrastructure.recipe.dimodule

import android.content.Context
import androidx.room.Room
import com.test.empowerment.labs.infrastructure.common.database.DatabaseConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): DatabaseConfig =
        Room.databaseBuilder(context, DatabaseConfig::class.java, "recipe_book")
            .fallbackToDestructiveMigration().build()
}