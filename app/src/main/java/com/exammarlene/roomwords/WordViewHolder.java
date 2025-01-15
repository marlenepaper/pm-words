package com.exammarlene.roomwords;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

class WordViewHolder extends RecyclerView.ViewHolder {
    private final TextView wordItemView;
    private final ImageButton deleteButton;

    private WordViewHolder(View itemView) {
        super(itemView);
        wordItemView = itemView.findViewById(R.id.textView);
        deleteButton = itemView.findViewById(R.id.deleteButton);
    }

    public void bind(String text, WordViewModel viewModel, int position, WordListAdapter adapter) {
        wordItemView.setText(text);

        deleteButton.setOnClickListener(v -> {
            if (viewModel != null) {
                viewModel.delete(new Word(text));
                adapter.notifyItemRemoved(position);
            } else {
                Log.e("WordViewHolder", "ViewModel is null");
            }
        });
    }

    static WordViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new WordViewHolder(view);
    }
}
