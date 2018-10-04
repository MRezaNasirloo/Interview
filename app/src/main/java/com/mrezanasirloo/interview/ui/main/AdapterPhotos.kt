package com.mrezanasirloo.interview.ui.main

import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.mrezanasirloo.interview.R
import com.mrezanasirloo.interview.domain.model.PhotoItemDomain
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation
import kotlinx.android.synthetic.main.row_photo.view.*

/**
 * @author : M.Reza.Nasirloo@gmail.com
 *         Created on: 2018-10-04
 */
class AdapterPhotos : RecyclerView.Adapter<AdapterPhotos.ViewHolderPhoto>() {

    private var items: List<PhotoItemDomain> = emptyList()

    fun update(newItems: List<PhotoItemDomain>) {
        DiffUtil.calculateDiff(object : DiffUtil.Callback() {
            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return items[oldItemPosition] === newItems[newItemPosition]
            }

            override fun getOldListSize(): Int {
                return items.size
            }

            override fun getNewListSize(): Int {
                return newItems.size
            }

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return items[oldItemPosition] == newItems[newItemPosition]
            }

        }).dispatchUpdatesTo(this)
        this.items = newItems
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPhoto {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_photo, parent, false)
        return ViewHolderPhoto(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolderPhoto, position: Int) {
        holder.bind(items[position])
    }


    inner class ViewHolderPhoto(view: View) : RecyclerView.ViewHolder(view) {
        private val imageViewProfile: ImageView = view.imageView_profile
        private val imageViewPhoto: ImageView = view.imageView
        private val textViewProfileName: TextView = view.textView_profile_name
        private val container: ConstraintLayout = view.container
        private val set: ConstraintSet = ConstraintSet()

        fun bind(photoItem: PhotoItemDomain) {
            Picasso.get().load(photoItem.imgSrcM)
                    .placeholder(R.color.grayBright)
                    .error(R.drawable.ic_error_red_24dp)
                    .into(imageViewPhoto)

            set.clone(container)
            set.setDimensionRatio(imageViewPhoto.id, photoItem.size)
            set.applyTo(container)

            Picasso.get().load(photoItem.senderImgSrc)
                    .transform(CropCircleTransformation())
                    .placeholder(R.drawable.placeholder)
                    .error(R.drawable.ic_error_red_24dp)
                    .into(imageViewProfile)

            textViewProfileName.text = photoItem.senderName
        }
    }
}