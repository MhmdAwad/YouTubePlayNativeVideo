package com.example.youtubeplaynativevideo.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.youtubeplaynativevideo.R;
import com.example.youtubeplaynativevideo.pojo.Item;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ChannelVideosAdapter extends RecyclerView.Adapter<ChannelVideosAdapter.ChannelViewHolder> {

    private List<Item> itemList = new ArrayList<>();
    private ItemClickListener itemClickListener;



    public ChannelVideosAdapter() {
    }

    @NonNull
    @Override
    public ChannelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ChannelViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.videos_rv_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ChannelViewHolder holder, int position) {
        holder.bind(itemList.get(position));
    }

    @Override
    public int getItemCount() {
        if (itemList.isEmpty()) {
            return 0;
        } else
            return itemList.size();
    }

    public void addItems(List<Item> items){
        this.itemList.clear();
        this.itemList.addAll(items);
        notifyDataSetChanged();
    }
    public class ChannelViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView channelName;
        private ImageView channelIcon;

        public ChannelViewHolder(@NonNull View itemView) {
            super(itemView);
            channelIcon = itemView.findViewById(R.id.videoIcon);
            channelName = itemView.findViewById(R.id.videoName);

            itemView.setOnClickListener(this);
        }

        void bind(Item item) {
            channelName.setText(item.getSnippet().getTitle());
            Picasso.get().load(item.getSnippet().getThumbnails().getDefault().getUrl()).into(channelIcon);
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onChannelClick(itemView, getAdapterPosition());
        }
    }

    public void onVideoClick(ItemClickListener clickListener) {
        itemClickListener = clickListener;
    }
}
