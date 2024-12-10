package com.example.plantapplication.ui

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.plantapplication.R
import com.example.plantapplication.databinding.SearchBarItemBinding

class CustomSearchBar@JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var binding: SearchBarItemBinding =
        SearchBarItemBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        val typedArray : TypedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomSearchBar,0 ,0)
        setHint(typedArray.getString(R.styleable.CustomSearchBar_hint))
        setHeaderImage(typedArray.getResourceId(R.styleable.CustomSearchBar_header_image,0))    }

    fun setHint(value : String?){
        binding.searchBarEditText.hint = value
    }

    fun setHeaderImage(headerImage : Int){
        binding.headerImage.setImageResource(headerImage)
    }

    fun setOnEditorActionListener(setOnEditorActionListener: TextView.OnEditorActionListener){
        binding.searchBarEditText.setOnEditorActionListener(setOnEditorActionListener)
    }

    fun getSearchedText(): String{
        return binding.searchBarEditText.text.toString()
    }
}