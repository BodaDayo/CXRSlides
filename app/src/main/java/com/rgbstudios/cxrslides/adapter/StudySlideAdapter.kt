package com.rgbstudios.cxrslides.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rgbstudios.cxrslides.R
import com.rgbstudios.cxrslides.StudyActivity
import com.rgbstudios.cxrslides.model.Slide

class StudySlideAdapter(
    private val context: Context?,
    private val dataset: List<Slide>
) : RecyclerView.Adapter<StudySlideAdapter.SlideViewHolder>() {

    /**
     * Initialize view elements
     */
    class SlideViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Declare and initialize all of the list item UI components
        val slideView: ImageView = view.findViewById(R.id.slide_image)
        val nameView: TextView = view.findViewById(R.id.slide_name)
        val explanationView: TextView = view.findViewById(R.id.slide_explanation)
        val buttonView: Button = view.findViewById(R.id.reveal_name_button)
        val readMoreView: TextView = view.findViewById(R.id.read_more)
        val expandIconView: ImageView = view.findViewById(R.id.expand_icon)
    }

    /**
     * Create new views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SlideViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.study_list_item, parent, false)

        return SlideViewHolder(layout)
    }

    /**
     * Return the size of your dataset (invoked by the layout manager)
     */
    override fun getItemCount(): Int = dataset.size

    /**
     * Replace the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: SlideViewHolder, position: Int) {

        holder.apply{
            buttonView.visibility = View.GONE
            readMoreView.visibility = View.INVISIBLE

            val item = dataset[position]
            slideView.setImageResource(item.imageResourceId)

            val resources = context?.resources

            val slideName = resources!!.getString(item.name)
            nameView.text = slideName
            val explanation = resources.getString(item.explanation)

            expandIconView.setOnClickListener {
                expandIconView.visibility = View.GONE
                displayExplanation(holder, explanation, slideName)
            }
        }

    }

    private fun displayExplanation(
        holder: SlideViewHolder,
        explanation: String,
        slideName: String
    ) {
        holder.explanationView.text = explanation
        holder.readMoreView.visibility = View.VISIBLE
        holder.readMoreView.setOnClickListener {
            val queryUrl: Uri =
                Uri.parse("${StudyActivity.SEARCH_PREFIX}${slideName}${StudyActivity.SUFFIX}")
            val intent = Intent(Intent.ACTION_VIEW, queryUrl)
            context?.startActivity(intent)
        }
    }
}