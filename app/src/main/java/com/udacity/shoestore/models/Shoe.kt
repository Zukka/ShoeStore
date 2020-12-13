package com.udacity.shoestore.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(var name: String = "", var size: String = "", var company: String = "", var description: String = "", val images: List<Int> = mutableListOf()
) : Parcelable {
    override fun toString(): String {
        return "Shoe(name='$name', size=$size, company='$company', description='$description', images=$images)"
    }
}