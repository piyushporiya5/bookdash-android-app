package org.bookdash.android.presentation.bookinfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import org.bookdash.android.R;
import org.bookdash.android.config.GlideApp;
import org.bookdash.android.domain.model.firebase.FireContributor;

import java.util.List;

public class ContributorAdapter extends RecyclerView.Adapter<ContributorViewHolder> {
    private final Context context;
    private List<FireContributor> items;

    public ContributorAdapter(List<FireContributor> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public ContributorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_contributor, parent, false);
        return new ContributorViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ContributorViewHolder holder, int position) {
        FireContributor item = items.get(position);

        holder.textViewContributor.setText(item.getName());
        holder.textViewRole.setText(item.getActualRolesFormatted());
        GlideApp.with(context).load(item.getFirebaseAvatar())
                .placeholder(R.drawable.placeholder_avatar).error(R.drawable.placeholder_avatar)
                .into(holder.imageViewContributorAvatar);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}