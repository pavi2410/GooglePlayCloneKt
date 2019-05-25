package com.pavi2410.googleplayclone.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pavi2410.googleplayclone.R
import com.pavi2410.googleplayclone.models.AppReviewItemModel
import kotlinx.android.synthetic.main.item_app_review.view.*

class AppReviewsAdapter(private val appReviewsList: List<AppReviewItemModel>) : RecyclerView.Adapter<AppReviewsAdapter.AppViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            AppViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_app_review, parent, false))

    override fun onBindViewHolder(holder: AppViewHolder, position: Int) {
        holder.bind(appReviewsList[position])
    }

    override fun getItemCount() = appReviewsList.size

    inner class AppViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(model: AppReviewItemModel) = with(view) {
            tv_user_name.text = model.userName
            tv_user_review.text = model.userReview
            tv_user_review_date.text = model.userReviewDate
            rb_user_review.rating = model.userReviewRatings.toFloat()
            Glide.with(context)
                    .load(model.userPicture)
                    .into(iv_user_image)
        }
    }
}
