package com.example.maroon.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maroon.FakeModel.FruitData;
import com.example.maroon.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.maroon.G.Font_shabnam;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.Holder> implements Filterable {

    private Context context ;
    private List<FruitData> data ;
    private List<FruitData> dataFull ;

    public FruitAdapter(Context context, List<FruitData> data) {
        this.context = context;
        this.data = data;
        dataFull = new ArrayList<>(data);
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fruit , parent ,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FruitAdapter.Holder holder, int position) {
        holder.imgFruit.setImageResource(data.get(position).getImg());
        holder.txtItemName.setText(data.get(position).getFruitName());
        holder.txtItemPrice.setText(data.get(position).getFruitPrice());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<FruitData> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(dataFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (FruitData data : dataFull) {
                    if (data.getFruitName().toLowerCase().contains(filterPattern)) {
                        filteredList.add(data);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            data.clear();
            data.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    class Holder extends RecyclerView.ViewHolder{
        private ImageView imgFruit ;
        private TextView txtItemName ;
        private TextView txtItemPrice ;

        public Holder(@NonNull View itemView) {
            super(itemView);

            imgFruit = itemView.findViewById(R.id.imgFruit);
            txtItemName = itemView.findViewById(R.id.txtItemName);
            txtItemPrice = itemView.findViewById(R.id.txtItemPrice);

            txtItemName.setTypeface(Font_shabnam);
            txtItemPrice.setTypeface(Font_shabnam);
        }
    }
}
