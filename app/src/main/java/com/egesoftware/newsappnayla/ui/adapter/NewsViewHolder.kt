package com.egesoftware.newsappnayla.ui.adapter

import android.content.Intent
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.egesoftware.newsappnayla.BR
import com.egesoftware.newsappnayla.data.models.Result
import com.egesoftware.newsappnayla.ui.detail.DetailActivity
import com.egesoftware.newsappnayla.ui.news.NewsViewModel
import com.egesoftware.newsappnayla.utils.Constant
import com.egesoftware.newsappnayla.utils.getDateFormat
import kotlinx.android.synthetic.main.card_latest_new_item.view.*
import timber.log.Timber


class NewsViewHolder constructor(
    private val dataBinding: ViewDataBinding,
    private val newsListViewModel: NewsViewModel,
) : RecyclerView.ViewHolder(dataBinding.root) {
    //val avatarImage = itemView.item_avatar
    fun setup(itemData: Result) {
        dataBinding.setVariable(BR.itemData, itemData)

        val date: String = getDateFormat(itemData.webPublicationDate)
        itemView.article_date.text = date
        dataBinding.executePendingBindings()

        // Picasso.get().load(itemData.owner.avatar_url).into(avatarImage);
        // This code is used to get the screen dimensions of the user's device
        // This code is used to get the screen dimensions of the user's device
      /*  itemView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
        val width = itemView.measuredWidth
        val height = itemView.measuredHeight

        // Set the ViewHolder width to be a third of the screen size, and height to wrap content

        // Set the ViewHolder width to be a third of the screen size, and height to wrap content
        itemView.layoutParams =
            RecyclerView.LayoutParams(width / 3, RecyclerView.LayoutParams.WRAP_CONTENT)*/

        itemView.setOnClickListener() {

            Timber.i("Clicked Latest News ITEM")
            val intent = Intent(it.context, DetailActivity::class.java)
            intent.putExtra(Constant.TITLE, itemData.webTitle)
            intent.putExtra(Constant.DESC, itemData.fields.trailText)
            intent.putExtra(Constant.DATE, date)
            intent.putExtra(Constant.IMAGE_URL, itemData.fields.thumbnail)
            intent.putExtra(Constant.WEB_URL, itemData.webUrl)
            intent.putExtra(Constant.CATEGORY, itemData.sectionId)
            it.context.startActivity(intent)
            //val bundle = bundleOf("url" to itemData.html_url)
            //itemView.findNavController().navigate(R.id.action_repoListFragment_to_repoDetailFragment, bundle)
        }
    }
}