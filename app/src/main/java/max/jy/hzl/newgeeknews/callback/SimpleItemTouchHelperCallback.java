package max.jy.hzl.newgeeknews.callback;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

public class SimpleItemTouchHelperCallback extends ItemTouchHelper.Callback {
    private TouchCallback touchCallback;

    public SimpleItemTouchHelperCallback(TouchCallback touchCallback) {
        this.touchCallback = touchCallback;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int dragFlag = ItemTouchHelper.UP | ItemTouchHelper.DOWN;

        int swipeFlag = ItemTouchHelper.LEFT;

        return makeMovementFlags(dragFlag,swipeFlag);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        int fromP = viewHolder.getAdapterPosition();
        int toP=target.getAdapterPosition();

        touchCallback.onItemMove(fromP,toP);

        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        int position = viewHolder.getAdapterPosition();
        touchCallback.onItemDelete(position);
    }
}
