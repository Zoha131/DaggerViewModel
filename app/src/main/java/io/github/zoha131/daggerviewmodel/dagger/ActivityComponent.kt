package io.github.zoha131.daggerviewmodel.dagger

import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import io.github.zoha131.daggerviewmodel.MainActivity
import io.github.zoha131.daggerviewmodel.Repository.CloudClient
import io.github.zoha131.daggerviewmodel.Repository.CloudClientImp
import io.github.zoha131.daggerviewmodel.Repository.CloudRepository
import io.github.zoha131.daggerviewmodel.fragment.OneFragment
import io.github.zoha131.daggerviewmodel.viewmodel.OneViewModelFactory


@Component(modules = [ActivityModule::class])
interface ActivityComponent {

    @Component.Factory
    interface Factory{

        fun create(
            @BindsInstance activity: MainActivity
        ): ActivityComponent
    }

    fun getOneFactory(): OneViewModelFactory

    fun injectFragment(oneFragment: OneFragment)
}

@Module
interface ActivityModule{

    @Binds
    fun getClient(clientImp: CloudClientImp): CloudClient
}