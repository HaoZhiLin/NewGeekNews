package max.jy.hzl.newgeeknews.mokuai.zhihu.fragment.hot;

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

public class HotRlvAdapter extends RecyclerView.Adapter<HotRlvAdapter.ViewHolder> {
    private Context context;

    public HotRlvAdapter(Context context) {
        this.context = context;
    }

    private ArrayList<HotBean.RecentBean>  list= new ArrayList<>();

    public void setList(ArrayList<HotBean.RecentBean> list) {
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
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HotBean.RecentBean recentBean = list.get(position);
        holder.tv.setText(recentBean.getTitle());
        RoundedCorners roundedCorners = new RoundedCorners(15);
        RequestOptions requestOptions = RequestOptions.bitmapTransform(roundedCorners);

        Glide.with(context).load(recentBean.getThumbnail()).apply(requestOptions).into(holder.iv);
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
}
