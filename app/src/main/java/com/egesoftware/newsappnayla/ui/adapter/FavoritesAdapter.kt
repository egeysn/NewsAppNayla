package com.egesoftware.newsappnayla.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.egesoftware.newsappnayla.R
import com.egesoftware.newsappnayla.data.room.model.NewTableModel
import com.egesoftware.newsappnayla.ui.detail.DetailActivity
import com.egesoftware.newsappnayla.utils.Constant
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.favorite_card_item_card.view.*
import timber.log.Timber

class FavoritesAdapter(private val newList: LiveData<List<NewTableModel>>?, val context: Context) :
    RecyclerView.Adapter<FavoritesAdapter.ViewHolder>() {
    var favList: List<NewTableModel> = emptyList()
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.favorite_card_item_card,
                p0,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        Timber.i("Favorites adapter item size :" + favList.size)
        return favList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, DetailActivity::class.java)
            intent.putExtra(Constant.TITLE, favList[position].title)
            intent.putExtra(Constant.DESC, favList[position].description)
            intent.putExtra(Constant.DATE, favList[position].date)
            intent.putExtra(Constant.IMAGE_URL, favList[position].test)
            intent.putExtra(Constant.WEB_URL, favList[position].webURL)
            intent.putExtra(Constant.CATEGORY, favList[position].category)
            it.context.startActivity(intent)
        }

        holder.tvTitle?.setText(favList[position].title)
        holder.tvDescription?.setText(favList[position].description)

        //TODO "test" name will change "imgURL"
        Picasso.get().load(favList[position].test).into(holder.img);

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        val tvTitle = view.favorite_card_title
        val img = view.favorite_card_img
        val tvDescription = view.favorite_card_description


    }

    fun updateList(newList: List<NewTableModel>) {
        Timber.i("Updated list FavoritesAdapter")
        this.favList = newList
        notifyDataSetChanged()
    }


}
