package net.unadeca.ana.examencal.subclases;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import net.unadeca.ana.examencal.R;

import org.sufficientlysecure.htmltextview.HtmlTextView;

/**
 * Created by ANA on 08/04/2018.
 */

public class ExamencalViewHolder extends RecyclerView.ViewHolder {
    public HtmlTextView html;
    public ImageView borrar;
    public ExamencalViewHolder(View itemView) {
        super(itemView);
        html = itemView.findViewById(R.id.html_text);
        borrar = itemView.findViewById(R.id.delete);

    }
}

