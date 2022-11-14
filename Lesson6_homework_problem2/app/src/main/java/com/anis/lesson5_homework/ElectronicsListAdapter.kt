package com.anis.lesson5_homework

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anis.lesson5_homework.databinding.ItemElectronicsBinding
import java.util.*

class ProductHolder(private val binding: ItemElectronicsBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(product:Product, onProductClicked: (title: String,
                                                 color:String,
                                                 price:Double,
                                                 id:String,
                                                 description:String,
                                                 image:Int) -> Unit ){
        binding.apply {
            title.text = product.title
            price.text = "Price: ${product.price} USD"
            color.text = "Color: ${product.color}"
            thumbnail.setImageResource(product.image)
            root.setOnClickListener {
                onProductClicked(product.title,product.color,product.price, product.id,product.description,product.image)
            }
        }
    }
}


class ElectronicsListAdapter(
    private val electronics: List<Product>,
    private val onProductClicked: (title: String,
                                   color:String,
                                   price:Double,
                                   id:String,
                                   description:String,
                                   image:Int) -> Unit) :RecyclerView.Adapter<ProductHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemElectronicsBinding.inflate(inflater, parent, false)
        return ProductHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        val product = electronics[position]
        holder.bind(product, onProductClicked)
    }

    override fun getItemCount() = electronics.size
}