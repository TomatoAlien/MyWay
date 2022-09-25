package cl.tomato.myway;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import org.jetbrains.annotations.NotNull;

public class SpaceItems extends DrawerItem<SpaceItems.ViewHolder> {

    private int spaceDp;
    public SpaceItems(int spaceDp){
        this.spaceDp = spaceDp;
    }

    @Override
    public ViewHolder createViewHolder(ViewGroup parent) {
        Context c = parent.getContext();
        View view = new View(c);
        int height = (int)(c.getResources().getDisplayMetrics().density*spaceDp);
        view.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                height
        ));
        return new ViewHolder(view);
    }

    @Override
    public void bindViewHolder(ViewHolder holder) {

    }

    @Override
    public boolean isSelectable() {
        return false;
    }

    public class ViewHolder extends DrawerAdapter.ViewHolder{
        public ViewHolder(@NotNull View itemView){
            super(itemView);
        }
    }
}