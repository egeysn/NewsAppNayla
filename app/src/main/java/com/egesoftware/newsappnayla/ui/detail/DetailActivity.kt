package com.egesoftware.newsappnayla.ui.detail

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Context
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.egesoftware.newsappnayla.R
import com.egesoftware.newsappnayla.data.room.repository.FavoriteNewsRepository
import com.egesoftware.newsappnayla.databinding.ActivityDetailBinding
import com.egesoftware.newsappnayla.utils.Constant
import com.squareup.picasso.Picasso
import timber.log.Timber




class DetailActivity : AppCompatActivity() {


    private lateinit var viewModel: DetailViewModel
    private lateinit var binding: ActivityDetailBinding
    lateinit var context: Context

    private var title: String = ""
    private var category: String = ""
    private var description: String = ""
    private var img: String = ""
    private var date:String = ""
    private var share_url: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        context = this@DetailActivity
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_detail
        )
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        binding.setLifecycleOwner(this)


        setupAdapters()

        binding.addBookmark.setOnClickListener {
            Toast.makeText(context,"Başarıyla kaydedildi",Toast.LENGTH_LONG).show()
          insertData(context = context)
        }
        binding.shareDetail.setOnClickListener {
            onShare(share_url)
        }

        binding.detailBackButton.setOnClickListener { this.finish()  }
        binding.executePendingBindings()

    }

    private fun setupAdapters() {
        title = intent.getStringExtra(Constant.TITLE).toString()
        category = intent.getStringExtra(Constant.CATEGORY).toString()
        description = intent.getStringExtra(Constant.DESC).toString()
        img = intent.getStringExtra(Constant.IMAGE_URL).toString()
        date = intent.getStringExtra(Constant.DATE)
        share_url = intent.getStringExtra(Constant.WEB_URL).toString()


        Picasso.get().load(img).into(binding.detailImageView)
        binding.tvDescriptionDetail.setMovementMethod(ScrollingMovementMethod())
        binding.tvDescriptionDetail.text = description
        binding.tvDetailTitle.text = title
        binding.tvDetailCategory.text = category
        binding.tvDetailDate.text = date
    }

    fun insertData(context: Context) {
        FavoriteNewsRepository.insertData(context, title, category, description, img, date, share_url)
    }

    private fun onShare(url: String) {
        val shareIntent = ShareCompat.IntentBuilder.from(this)
            .setText(url.toString())
            .setType("text/plain")
            .intent
        try {
            startActivity(shareIntent)
        } catch (ex: ActivityNotFoundException) {
            Timber.e("Share Method- Bir şey ler ters gitti")
        }
    }
}