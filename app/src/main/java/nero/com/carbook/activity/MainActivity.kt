package nero.com.carbook.activity

import android.os.Bundle
import br.com.livroandroid.carros.extensions.setupToolbar
import nero.com.carbook.R

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupToolbar(R.id.toolbar)
    }
}
