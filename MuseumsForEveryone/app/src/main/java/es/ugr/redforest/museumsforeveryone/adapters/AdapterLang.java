package es.ugr.redforest.museumsforeveryone.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import es.ugr.redforest.museumsforeveryone.models.ContentType;
import es.ugr.redforest.museumsforeveryone.models.Language;
import es.ugr.redforest.museumsforeveryone.R;
import es.ugr.redforest.museumsforeveryone.utils.QueryBBDD;

/**
 * Adapter used in RecyclerView to display a list of Languages
 *
 * @author Gregorio Carvajal Exposito
 * @version 1.0.0
 * @see Language
 * @see RecyclerView
 */
public class AdapterLang extends RecyclerView.Adapter<AdapterLang.LangViewHolder>
						 implements View.OnClickListener {

	private ArrayList<Language> langList;   // ArrayList containing the Languages to show
	private View.OnClickListener listener;
	private Context context;// Listener needed to handle onClick event

	/**
	 * ViewHolder needed to handle how to show elements
	 *
	 * @author Gregorio Carvajal Exposito
	 * @version 1.0.0
	 * @see "layout/lang_list_row.xml"
	 */
	public static class LangViewHolder extends RecyclerView.ViewHolder {
		private ImageView langImg;
		private TextView langTxt;

		/**
		 * Constructor method. Gets references to visible elements
		 *
		 * @param view Needed by the superclass constructor
		 */
		public  LangViewHolder(View view) {
			super(view);

			langImg = (ImageView) view.findViewById(R.id.lang_img);
			langTxt = (TextView) view.findViewById(R.id.lang_txt);
		}
	}

	/**
	 * Constructor method.
	 *
	 * @param langList List of languages to show
	 * @param context
	 */
	public AdapterLang(ArrayList<Language> langList, Context context) {
		this.langList = langList;
		this.context = context;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LangViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View itemView = LayoutInflater.from(parent.getContext())
						.inflate(R.layout.lang_list_row, parent, false);

		itemView.setOnClickListener(this);
		return new LangViewHolder(itemView);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onBindViewHolder(LangViewHolder holder, int position) {
		Language lang = langList.get(position);

		holder.langTxt.setText(lang.getLang());
		Picasso.with(context).load(QueryBBDD.server+lang.getImage()).into(holder.langImg);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getItemCount() {
		return langList.size();
	}

	public void setOnClickListener(View.OnClickListener listener) {
		this.listener = listener;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onClick(View view) {
		if(listener != null)
			listener.onClick(view);
	}
}
