package max.jy.hzl.newgeeknews.mokuai.gold;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import max.jy.hzl.newgeeknews.R;

public class GoldAdapter extends RecyclerView.Adapter<GoldAdapter.ViewHolder> {
    private Context context;
    private ArrayList<GoldBean.ResultsBean> list;

    public GoldAdapter(Context context, ArrayList<GoldBean.ResultsBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(context,R.layout.gold_child_item,null));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GoldBean.ResultsBean resultsBean = list.get(position);
        holder.tv.setText(resultsBean.getDesc());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv;
        public ViewHolder(View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.tv);
        }
    }
}
