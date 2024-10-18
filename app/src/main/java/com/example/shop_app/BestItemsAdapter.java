package com.example.shop_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shop_app.R;

import java.util.List;

// Adapter برای نمایش آیتم‌های بهترین‌ها
public class BestItemsAdapter extends RecyclerView.Adapter<BestItemsAdapter.BestItemViewHolder> {

    private final List<String> bestItems;

    public BestItemsAdapter(List<String> bestItems) {
        this.bestItems = bestItems;
    }

    @NonNull
    @Override
    public BestItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_best, parent, false);
        return new BestItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BestItemViewHolder holder, int position) {
        // تنظیم آیتم فیک (نام محصول)
        holder.productName.setText(bestItems.get(position));
        // می‌توانید تصویر محصول را نیز تنظیم کنید (در اینجا تصویر ثابت است)
        holder.productImage.setImageResource(R.drawable.ic_launcher_foreground); // تصویر فیک
    }

    @Override
    public int getItemCount() {
        return bestItems.size();
    }

    static class BestItemViewHolder extends RecyclerView.ViewHolder {
        ImageView productImage;
        TextView productName;

        public BestItemViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.productImage);
            productName = itemView.findViewById(R.id.productName);
        }
    }
}
