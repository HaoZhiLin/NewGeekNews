package max.jy.hzl.newgeeknews.mokuai.wechat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import max.jy.hzl.newgeeknews.R;
import max.jy.hzl.newgeeknews.mokuai.zhihu.fragment.hot.HotBean;

public class WechatRlvAdapter extends RecyclerView.Adapter<WechatRlvAdapter.ViewHolder> {
    private Context context;

    public WechatRlvAdapter(Context context) {
        this.context = context;
    }

    private ArrayList<NewslistBean>  list= new ArrayList<>();

    public void setList(ArrayList<NewslistBean> list) {
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
        NewslistBean newslistBean = list.get(position);
        holder.tv.setText(newslistBean.getTitle());

        Glide.with(context).load(newslistBean.getPicUrl()).into(holder.iv);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClick.click(view,position);
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

    public void setOnClick(WechatRlvAdapter.onClick onClick) {
        this.onClick = onClick;
    }

    public interface onClick{
        void click(View v,int position);
    }
}
