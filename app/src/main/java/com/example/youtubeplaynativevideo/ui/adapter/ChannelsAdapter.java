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
import com.example.youtubeplaynativevideo.pojo.ChannelData;
import com.example.youtubeplaynativevideo.pojo.Item;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChannelsAdapter extends RecyclerView.Adapter<ChannelsAdapter.ChannelViewHolder> {

    private List<ChannelData> channelDataList;
    private ItemClickListener itemClickListener;
    public ChannelsAdapter(List<ChannelData> data) {
        this.channelDataList = data;
    }

    @NonNull
    @Override
    public ChannelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ChannelViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.channels_rv_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ChannelViewHolder holder, int position) {
        holder.bind(channelDataList.get(position));
    }

    @Override
    public int getItemCount() {
        return channelDataList.size();
    }

    public void setOnItemClick(ItemClickListener click) {
        itemClickListener = click;
    }
    public class ChannelViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView channelName;
        private CircleImageView channelIcon;
        public ChannelViewHolder(@NonNull View itemView) {
            super(itemView);
            channelIcon = itemView.findViewById(R.id.channelIcon);
            channelName = itemView.findViewById(R.id.channelName);

            itemView.setOnClickListener(this);
        }

        void bind(ChannelData data){
            channelName.setText(data.getChannelName());
            Picasso.get().load(data.getChannelIcon()).into(channelIcon);

        }

        @Override
        public void onClick(View v) {
            itemClickListener.onChannelClick(itemView,getAdapterPosition());
        }
    }


}
