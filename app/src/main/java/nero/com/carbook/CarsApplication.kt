package nero.com.carbook

import android.annotation.SuppressLint
import android.app.Application
import android.util.Log
import java.lang.IllegalStateException

@SuppressLint("Registered")
class CarsApplication : Application() {
    private val TAG = "CarsApplication"

    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }

    companion object {
        // The singleton of Application class
        private var appInstance: CarsApplication? = null

        fun getInstace(): CarsApplication {
            if (appInstance == null) {
                throw IllegalStateException("Configure the Application class on Manifest")
            }
            return appInstance!!
        }
    }

    override fun onTerminate() {
        super.onTerminate()
        Log.d(TAG, "CarsApplication.onTerminate()")
    }
}