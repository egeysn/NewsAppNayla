package com.egesoftware.newsappnayla.ui.adapter


import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.egesoftware.newsappnayla.BR
import com.egesoftware.newsappnayla.data.models.Result
import com.egesoftware.newsappnayla.ui.detail.DetailActivity
import com.egesoftware.newsappnayla.ui.news.NewsViewModel
import com.egesoftware.newsappnayla.utils.Constant
import com.google.android.material.internal.ContextUtils.getActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.card_item_around_the_world.view.*
import timber.log.Timber

class NewsAroundTheWorldViewHolder constructor(
    private val dataBinding: ViewDataBinding,
    private val newsListViewModel: NewsViewModel
) : RecyclerView.ViewHolder(dataBinding.root) {

    val new_image = itemView.media_image
    fun setup(itemData: Result) {
        dataBinding.setVariable(BR.itemAroundWorld, itemData)
        dataBinding.executePendingBindings()

        Picasso.get().load(itemData.fields.thumbnail).into(new_image);

        itemView.setOnClickListener() {
            Timber.i("Clicked NewsAround ITEM")
            val intent = Intent (it.context, DetailActivity::class.java)
            intent.putExtra(Constant.TITLE,itemData.webTitle)
            intent.putExtra(Constant.DESC,itemData.fields.trailText)
            intent.putExtra(Constant.DATE,itemData.webPublicationDate)
            intent.putExtra(Constant.IMAGE_URL,itemData.fields.thumbnail)
            intent.putExtra(Constant.WEB_URL, itemData.webUrl)
            intent.putExtra(Constant.CATEGORY,itemData.sectionId)
            it.context.startActivity(intent)
           // getActivity().startActivity(intent)
            //val bundle = bundleOf("url" to itemData.html_url)
            //itemView.findNavController().navigate(R.id.action_repoListFragment_to_repoDetailFragment, bundle)
        }
    }
}