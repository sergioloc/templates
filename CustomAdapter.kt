import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val list: ArrayList<String>, private val listener: OnCustomClickListener): RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return CustomViewHolder(LayoutInflater.from(parent.context), parent)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.name?.text = list[position]
        holder.root?.setOnClickListener { listener.onClickElement() }
    }

    class CustomViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_element, parent, false)) {

        var root: ConstraintLayout? = null
        var name: TextView? = null

        init {
            root = itemView.findViewById(R.id.root)
            name = itemView.findViewById(R.id.tv_name)
        }
    }

    interface OnCustomClickListener {
        fun onClickElement(id: String)
    }

}