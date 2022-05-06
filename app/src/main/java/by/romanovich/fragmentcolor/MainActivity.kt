package by.romanovich.fragmentcolor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import by.romanovich.fragmentcolor.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val masterFragment: Fragment = ColorListFragment()
        //
        supportFragmentManager
            .beginTransaction()
            .add(binding.masterFragmentContainer.id, masterFragment)
            .commit()
    }
}