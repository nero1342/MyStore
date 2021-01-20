package com.apcs.nero.mystore.ui.item;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.apcs.nero.mystore.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {
    private Context context;
    private Activity activity;
    private List<Item> listItem;

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public ImageView thumbnail;
        public TextView itemTitle, itemId, itemDescription;
        public RelativeLayout itemLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            thumbnail = (ImageView) itemView.findViewById(R.id.itemThumbnail);
            itemTitle = (TextView) itemView.findViewById(R.id.itemTitle);
            itemId = (TextView) itemView.findViewById(R.id.itemID);
            itemDescription = (TextView) itemView.findViewById(R.id.itemDescription);
            itemLayout = (RelativeLayout) itemView.findViewById(R.id.itemLayout);

        }
    }

    public ItemAdapter(Context context, Activity activity, List<Item> listItem) {
        this.context = context;
        this.activity = activity;
        this.listItem = listItem;
    }

    @NonNull
    @Override
    public ItemAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.MyViewHolder holder, int position) {
        final Item item = listItem.get(position);
        holder.itemId.setText("Item ID: " + item.getId());
        holder.itemTitle.setText(item.getTitle());
        holder.itemDescription.setText(item.getDescription());

        // Load image from picasso
        Picasso.with(context)
                .load(item.getThumbnailURL())
                .resize(480, 720)
                .centerCrop()
                .into(holder.thumbnail);

        holder.itemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "This feature will coming soon...", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }


}
