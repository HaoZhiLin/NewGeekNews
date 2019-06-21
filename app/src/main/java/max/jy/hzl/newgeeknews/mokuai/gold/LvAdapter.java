package max.jy.hzl.newgeeknews.mokuai.gold;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

import max.jy.hzl.newgeeknews.R;
import max.jy.hzl.newgeeknews.callback.TouchCallback;

public class LvAdapter extends RecyclerView.Adapter<LvAdapter.ViewdHolder> implements TouchCallback {
    private Context context;
    public ArrayList<TypeBean> list;

    public LvAdapter(Context context, ArrayList<TypeBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public LvAdapter.ViewdHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewdHolder(View.inflate(context,R.layout.lv_item,null));
    }

    @Override
    public void onBindViewHolder(@NonNull final LvAdapter.ViewdHolder holder, final int position) {
        final TypeBean typeBean = list.get(position);
        holder.tv.setText(typeBean.getName());
        holder.swi.setChecked(typeBean.isType());

        holder.swi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                list.get(position).setType(isChecked);
//                typeBean.setType(isChecked);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onItemMove(int fromP, int toP) {
        Collections.swap(list,fromP,toP);
        notifyItemMoved(fromP,toP);
    }

    @Override
    public void onItemDelete(int position) {
        list.remove(position);
        notifyItemRemoved(position);
    }

    public class ViewdHolder extends RecyclerView.ViewHolder {
        private TextView tv;
        private Switch swi;
        public ViewdHolder(View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.tv_lv);
            swi=itemView.findViewById(R.id.swi);
        }
    }
}
