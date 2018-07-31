/*
 * Copyright (c) 2018 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *  *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.raywenderlich.android.yana

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.samset.kotlinnavigationdrawer.R
import com.samset.kotlinnavigationdrawer.listeners.OnItemClickListeners


class NavListAdapter(private val noteList: Array<String>) : RecyclerView.Adapter<NavListAdapter.NoteViewHolder>() {
   lateinit var listener: OnItemClickListeners
  private val listicons = intArrayOf(R.drawable.ic_dashboard_black_24dp, R.drawable.ic_home_black_24dp, R.drawable.ic_home_black_24dp, R.drawable.ic_home_black_24dp, R.drawable.ic_home_black_24dp, R.drawable.ic_home_black_24dp)

  public fun setListeners(mylistener: OnItemClickListeners){
    this.listener=mylistener
  }

  //this method is returning the view for each item in the list
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
    val v = LayoutInflater.from(parent.context).inflate(R.layout.navigation_item, parent, false)
    return NoteViewHolder(v)
  }

  //this method is binding the data on the list
  override fun onBindViewHolder(holder: NavListAdapter.NoteViewHolder, position: Int) {
    holder.bind(noteList[position],listicons[position])
  }
  // or
  //override fun onBindViewHolder(holder: NoteViewHolder, position: Int) = holder.bind(noteList[position],listicons[position])

  override fun getItemCount() = noteList.size

  class NoteViewHolder(itemView: View) :

          RecyclerView.ViewHolder(itemView) {

    private val navTitle: AppCompatTextView = itemView.findViewById(R.id.tvitemname)
    private val navImageIcon: AppCompatImageView = itemView.findViewById(R.id.iv_icons)
    private val llFrame: LinearLayout = itemView.findViewById(R.id.llmainframe)

    fun bind(note: String,icon: Int) {
      navTitle.text = note
      navImageIcon.setImageResource(icon)
      //noteCardView.setCardBackgroundColor(ContextCompat.getColor(noteCardView.context, note.getPriorityColor()))
    }
  }
}