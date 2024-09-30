package ph.edu.auf.recyclerviewslesson.screens.activities

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import ph.edu.auf.recyclerviewslesson.adapters.SimpleRVAdapter
import ph.edu.auf.recyclerviewslesson.databinding.ActivitySimpleRecyclerViewBinding
import ph.edu.auf.recyclerviewslesson.models.UsersModel

class SimpleRecyclerViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySimpleRecyclerViewBinding
    private lateinit var nameList: ArrayList<UsersModel>
    private lateinit var simpleAdapter: SimpleRVAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySimpleRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        nameList = arrayListOf(
            UsersModel("John Doe", 20, "johndoe@email.com",0, "Manila"),
            UsersModel("Patrick", 21, "patrick@gmail.com",0, "Pampanga"),
            UsersModel("Jasmin", 21, "Jasmin@gmail.com",0, "Bulacan"),
            UsersModel("Larry", 20, "larry@email.com",0, "Tarlac"),
            UsersModel("Manny", 21, "manny@email.com",0, "Pampanga"),
        )

        val layoutManager = LinearLayoutManager(this)
        simpleAdapter = SimpleRVAdapter(nameList)
        binding.rvSimpleName.layoutManager = layoutManager
        binding.rvSimpleName.adapter = simpleAdapter

        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val user = nameList[position]
                nameList.removeAt(position)
                simpleAdapter.notifyItemRemoved(position)
                //Toast.makeText(this@SimpleRecyclerViewActivity, "${user.username} has been removed", Toast.LENGTH_SHORT).show()
                //snackbar with undo button
                Snackbar.make(binding.root, "${user.username} has been removed", Snackbar.LENGTH_LONG)
                    .setAction("Undo") {
                        nameList.add(position, user)
                        simpleAdapter.notifyItemInserted(position)
                    }.show()
            }
        }).attachToRecyclerView(binding.rvSimpleName)
    }
}