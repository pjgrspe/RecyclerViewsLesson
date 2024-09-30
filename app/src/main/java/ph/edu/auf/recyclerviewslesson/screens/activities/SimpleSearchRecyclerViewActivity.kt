package ph.edu.auf.recyclerviewslesson.screens.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ph.edu.auf.recyclerviewslesson.databinding.ActivitySimpleSearchRecyclerViewBinding
import ph.edu.auf.recyclerviewslesson.models.FruitsModel

class SimpleSearchRecyclerViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySimpleSearchRecyclerViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySimpleSearchRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fruitList = arrayListOf(
            FruitsModel("Mango","Mangifera indica"),
            FruitsModel("Apple","Pyrus malus"),
            FruitsModel("Pomegranate", "Punica granatum"),
            FruitsModel("Pineapple", "Ananus sativus"),
            FruitsModel("Orange", "Citrus aurantium"),
            FruitsModel("Strawberry", "Fragaria × ananassa"),
            FruitsModel("Sweet Potato", "Ipomoea batatas"),
            FruitsModel("Watermelon", "Citrullus lanatus")
        )

    }
}