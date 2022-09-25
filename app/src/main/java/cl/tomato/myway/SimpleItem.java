package cl.tomato.myway;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;

public class SimpleItem extends DrawerItem<SimpleItem.ViewHolder>{

    private int selectedItemIconTint;
    private int SelectedItemTextTint;

    private int normalItemIconTint;
    private int normalItemTextTint;

    private Drawable icon;
    private String titulo;

    public SimpleItem(Drawable icon, String titulo){
        this.icon = icon;
        this.titulo = titulo;
    }

    @Override
    public ViewHolder createViewHolder(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_opcion, parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void bindViewHolder(ViewHolder holder) {
        holder.titulo.setText(titulo);
        holder.icon.setImageDrawable(icon);

        holder.titulo.setText(isChecked ? SelectedItemTextTint : normalItemTextTint);
        holder.icon.setColorFilter(isChecked ? selectedItemIconTint : normalItemIconTint);
    }
    public SimpleItem withSelectedIconTint(int SelectedItemIconTint){
        this.selectedItemIconTint = selectedItemIconTint;
        return this;
    }
    public SimpleItem withSelectedTextTint(int selectedItemTextTint){
        this.SelectedItemTextTint = selectedItemTextTint;
        return this;
    }
    public SimpleItem withIconTint(int normalItemIconTint){
        this.normalItemIconTint = normalItemIconTint;
        return this;
    }
    public SimpleItem withTextTint(int normalItemIconTint){
        this.normalItemTextTint = normalItemTextTint;
        return this;
    }

    static class ViewHolder extends DrawerAdapter.ViewHolder{

        public ImageView icon;
        public TextView titulo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.icon);
            titulo = itemView.findViewById(R.id.titulo);
        }
    }
}
