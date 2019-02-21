package nero.com.carbook.activity

import android.os.Bundle
import nero.com.carbook.R
import nero.com.carbook.domain.CarType
import nero.com.carbook.extensions.addFragment
import nero.com.carbook.extensions.setupToolbar
import nero.com.carbook.fragments.CarsFragment

class CarsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cars)

        val type = intent.getSerializableExtra("type") as CarType
        val title = getString(type.string)

        setupToolbar(R.id.toolbar, title, true)

        if (savedInstanceState == null) {
            addFragment(R.id.container, CarsFragment())
        }

    }
}
