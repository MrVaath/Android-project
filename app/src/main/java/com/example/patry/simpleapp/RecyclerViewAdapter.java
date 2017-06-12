package com.example.patry.simpleapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolders> {

    private List<Task> task; // Tworzymy listę zadań
    protected Context context;

    public RecyclerViewAdapter(Context context, List<Task> task) {
        this.task = task;
        this.context = context;
    }

    // Tworzymy naszego viewHoldera, przypisując mu odpowiedni layout i uzupełniamy go zadaniami
    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerViewHolders viewHolder = null; // Tworzymy viewHoldera i przypisujemy nulla
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.to_do_list, parent, false); // Tworzymy layoutView, przypisując mu layout -> to_do_list
        viewHolder = new RecyclerViewHolders(layoutView, task); // Przypisujemy do naszego viewHoldera wcześniej utworzony layoutView oraz zadania (taski) pobrane z Firebase'a
        return viewHolder;
    }

    // Ustawienie pozycji, kolejności w naszym viewHolderze
    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {
        holder.categoryTitle.setText(task.get(position).getTask());
    }

    // Pobranie wielkości naszej listy zadań
    @Override
    public int getItemCount() {
        return this.task.size();
    }
}