package io.github.zoha131.daggerviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.github.zoha131.daggerviewmodel.dagger.ActivityComponent
import io.github.zoha131.daggerviewmodel.dagger.DaggerActivityComponent
import io.github.zoha131.daggerviewmodel.fragment.OneFragment

class MainActivity : AppCompatActivity() {

    private lateinit var _component: ActivityComponent
    val component get() = _component

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        _component = DaggerActivityComponent.factory().create(this)

        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, OneFragment()).commit()
    }
}
