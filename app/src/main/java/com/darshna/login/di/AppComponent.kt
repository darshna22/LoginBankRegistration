package com.darshna.login.di

import android.content.Context
import com.darshna.login.ui.login.RegistrationLoginFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

// Definition of a Dagger component that adds info from the StorageModule to the graph
@Singleton
@Component(modules = [NetworkModule::class])
interface AppComponent {

  // Factory to create instances of the AppComponent
  @Component.Factory
  interface Factory {
    // With @BindsInstance, the Context passed in will be available in the graph
    fun create(@BindsInstance context: Context): AppComponent
  }

  fun inject(registrationLoginFragment: RegistrationLoginFragment)

}