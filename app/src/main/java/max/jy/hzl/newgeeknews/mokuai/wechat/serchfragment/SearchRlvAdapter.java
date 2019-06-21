package max.jy.hzl.newgeeknews.mokuai.wechat.serchfragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import max.jy.hzl.newgeeknews.R;
import max.jy.hzl.newgeeknews.mokuai.wechat.NewslistBean;

public class SearchRlvAdapter extends RecyclerView.Adapter<SearchRlvAdapter.ViewHolder> {
    private Context context;

    public SearchRlvAdapter(Context context) {
        this.context = context;
    }

    private ArrayList<SearchBean.NewslistBean>  list= new ArrayList<>();

    public void setList(ArrayList<SearchBean.NewslistBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(context,R.layout.dailly_rlv_item3,null));
    }

    @SuppressLint("CheckResult")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final SearchBean.NewslistBean newslistBean = list.get(position);

        holder.tv.setText(newslistBean.getDescription());
        Glide.with(context).load(newslistBean.getPicUrl()).into(holder.iv);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClick.click(view,newslistBean.getUrl());
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView tv;
        public ViewHolder(View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.iv_rlv_item3);
            tv=itemView.findViewById(R.id.tv_rlv_item3);
        }
    }
    private onClick onClick;

    public void setOnClick(SearchRlvAdapter.onClick onClick) {
        this.onClick = onClick;
    }

    public interface onClick{
        void click(View v, String url);
    }
}
