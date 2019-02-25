package nero.com.carbook.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import nero.com.carbook.R
import nero.com.carbook.domain.CarType

class CarsFragment : BaseFragment() {

    private var type: CarType = CarType.classics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        type = arguments?.getSerializable("type") as CarType
    }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_cars, container, false)
        val textView = view?.findViewById<TextView>(R.id.textFragment)

        val typeString = getString(type.string)
        textView?.text = "Carros $typeString"

        return view
    }
}