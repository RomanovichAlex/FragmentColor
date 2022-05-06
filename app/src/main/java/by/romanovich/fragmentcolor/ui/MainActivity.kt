package by.romanovich.fragmentcolor.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import by.romanovich.fragmentcolor.databinding.ActivityMainBinding
import by.romanovich.fragmentcolor.domain.ColorEntity
import by.romanovich.fragmentcolor.ui.colorViewer.ColorViewerFragment
import by.romanovich.fragmentcolor.ui.colorsList.ColorListFragment

class MainActivity : AppCompatActivity(), ColorListFragment.Controller {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            val masterFragment: Fragment = ColorListFragment()
            //для сохранения фрагмента и что бы не пересоздавался новый фрагмент(говорим что не нужно уничтожать фрагмент), вызовется онДестройвью но не вызовется онДестрой
            masterFragment.retainInstance = true
            supportFragmentManager
                .beginTransaction()
                .add(binding.masterFragmentContainer.id, masterFragment)
                .commit()
        }
    }

    override fun openColorScreen(color: ColorEntity) {
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(binding.detailFragmentContainer.id,
            ColorViewerFragment.newInstance(color))
            .commit()
    }
}