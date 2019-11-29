package io.github.zoha131.daggerviewmodel.fragment


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import io.github.zoha131.daggerviewmodel.MainActivity
import io.github.zoha131.daggerviewmodel.R
import io.github.zoha131.daggerviewmodel.viewmodel.OneViewModel
import io.github.zoha131.daggerviewmodel.viewmodel.OneViewModelFactory
import kotlinx.android.synthetic.main.fragment_one.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class OneFragment : Fragment() {

    // you can get the factory using kotlin lazy delegate.
    // by this you can use val and private
    private val factory: OneViewModelFactory by lazy { (requireActivity() as MainActivity).component.getOneFactory() }

    // also you can use @Inject annotation but then you have to use var and public
    @Inject
    lateinit var iFactory: OneViewModelFactory

    private val viewModel:OneViewModel by viewModels { iFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textTrial.text = viewModel.getName()

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (requireActivity() as MainActivity).component.injectFragment(this)
    }
}
