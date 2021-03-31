package com.msc.picproapp.searchresultimage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.msc.picproapp.R
import com.msc.picproapp.data.http.Photo
import com.bumptech.glide.Glide
import com.msc.picproapp.Constants

class SearchResultAdapter(
    private val photos: List<Photo>,
    private val fragment: Fragment,
    private val onClick: (Photo) -> Unit
) : RecyclerView.Adapter<SearchResultAdapter.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.iv_search_result)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.search_result_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = photos.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val photo = photos[position].urls.thumb
        Glide.with(fragment).load(photo)
            .override(Constants.IMAGE_WIDTH_PIXELS, Constants.IMAGE_HEIGHT_PIXELS)
            .into(holder.imageView)
    }
}