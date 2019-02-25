package nero.com.carbook.activity

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import android.support.v7.widget.Toolbar
import nero.com.carbook.extensions.setupToolbar
import nero.com.carbook.R
import nero.com.carbook.domain.CarType
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupToolbar(R.id.toolbar)
        setupNavigationDrawer()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_item_carros_todos -> {
                toast("Carros clicked")
            }
            R.id.nav_item_carros_classicos -> {
//              navigationItem(context, CarType.classics)  = Old way
                startActivity<CarsActivity>("type" to CarType.classics) // Using lib Anko
            }
            R.id.nav_item_carros_esportivos -> {
//                navigationItem(context, CarType.sportive)
                startActivity<CarsActivity>("type" to CarType.sportive) // Using lib Anko
            }
            R.id.nav_item_carros_luxo -> {
//                navigationItem(context, CarType.luxuries)
                startActivity<CarsActivity>("type" to CarType.luxuries) // Using lib Anko
            }
            R.id.nav_item_site_livro -> {
                startActivity<AboutActivity>()
            }
        }

        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        drawer.closeDrawer(GravityCompat.START)

        return true
    }

    private fun setupNavigationDrawer() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        val toggle = ActionBarDrawerToggle(
            this,
            drawer,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)
    }

//    old way
//    private fun navigationItem(context: Context, carType: CarType) {
//        val intent = Intent(context, CarsActivity::class.java)
//        intent.putExtra("type", carType)
//        startActivity(intent)
//    }
}
