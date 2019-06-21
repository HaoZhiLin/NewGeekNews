package max.jy.hzl.newgeeknews.mokuai.v2ex.activity;


import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chumu.dt.v24.permissions.ChuMuRandomColor;

import java.util.ArrayList;
import java.util.List;

import max.jy.hzl.newgeeknews.R;
import max.jy.hzl.newgeeknews.mokuai.v2ex.widget.FlowLayout;

/**
 * Created by $lzj on 2019/6/18.
 */
public class RlvNodeNaviAdapter extends RecyclerView.Adapter<RlvNodeNaviAdapter.ViewHolder> {

    private Context context;
    private ArrayList<NodeNaviBean.DataBean> list;

    public ArrayList<NodeNaviBean.DataBean> getList() {
        return list;
    }

    public RlvNodeNaviAdapter(Context context, ArrayList<NodeNaviBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RlvNodeNaviAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int
            viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.v2ex_item, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RlvNodeNaviAdapter.ViewHolder holder, final int position) {
        NodeNaviBean.DataBean dataBean = list.get(position);

        List<NodeNaviBean.DataBean.ArticlesBean> articles = dataBean.getArticles();

        if (articles!=null&&articles.size()>0){

            for (int i = 0; i < articles.size(); i++) {
                TextView txt = (TextView) View.inflate(context,R.layout.item_v2ex_label, null);
                txt.setText(articles.get(i).getTitle());
                txt.setTextColor(Color.parseColor(ChuMuRandomColor.onRandomColor()));

                holder.fl.addView(txt);
                final int finalI = i;
                txt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(onClick!=null){

                            onClick.click(v,position, finalI);
                        }
                    }
                });
            }
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private FlowLayout fl;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            fl = itemView.findViewById(R.id.fl);
        }
    }
    private onClick onClick;

    public void setOnClick(RlvNodeNaviAdapter.onClick onClick) {
        this.onClick = onClick;
    }

    public interface onClick{
        void click(View v,int groupPosition,int chilePosition);
    }
}

