package ph.edu.auf.recyclerviewslesson.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ph.edu.auf.recyclerviewslesson.databinding.ContentSimpleRvBinding
import ph.edu.auf.recyclerviewslesson.models.UsersModel

class SimpleRVAdapter(private var nameList: ArrayList<UsersModel>) : RecyclerView.Adapter<SimpleRVAdapter.SimpleRVViewHolder>() {
    private var TAG = SimpleRVAdapter::class.java.simpleName

    inner class SimpleRVViewHolder(val binding: ContentSimpleRvBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(binding: ContentSimpleRvBinding){
            binding.llCardView.setOnClickListener{
                // Do something
                val user = nameList[adapterPosition]
                Log.d(TAG, user.username)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleRVViewHolder {
        val binding = ContentSimpleRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SimpleRVViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return nameList.size
    }

    override fun onBindViewHolder(holder: SimpleRVViewHolder, position: Int) {
        with(holder){
            holder.bind(holder.binding)
            with(nameList[position]){
                binding.txtAge.text = this.age.toString()
                binding.txtEmail.text = this.email
                binding.txtName.text = this.username
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }
}