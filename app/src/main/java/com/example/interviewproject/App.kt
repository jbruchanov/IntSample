package com.example.interviewproject

import android.app.Application
import androidx.lifecycle.SavedStateHandle
import com.example.interviewproject.editor.EditorViewModel
import com.example.interviewproject.items.ItemsViewModel
import com.example.interviewproject.repo.AlarmsRepository
import com.jakewharton.threetenabp.AndroidThreeTen
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
        startKoin {
            androidContext(this@App)
            modules(listOf(koinAppModule))
        }
    }
}


val koinAppModule = module {
    factory { AlarmsRepository() }

    viewModel { (handle: SavedStateHandle) -> ItemsViewModel() }
    viewModel { (handle: SavedStateHandle) -> EditorViewModel() }
}
