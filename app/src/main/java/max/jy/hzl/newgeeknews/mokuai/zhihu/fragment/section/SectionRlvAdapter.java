package max.jy.hzl.newgeeknews.mokuai.zhihu.fragment.section;

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

public class SectionRlvAdapter extends RecyclerView.Adapter<SectionRlvAdapter.ViewHolder> {
    private Context context;

    public SectionRlvAdapter(Context context) {
        this.context = context;
    }

    private ArrayList<SectionBean.DataBean>  list= new ArrayList<>();

    public void setList(ArrayList<SectionBean.DataBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(context,R.layout.section_item,null));
    }

    @SuppressLint("CheckResult")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SectionBean.DataBean dataBean = list.get(position);
        RequestOptions options = RequestOptions.circleCropTransform();
        Glide.with(context).load(dataBean.getThumbnail()).apply(options).into(holder.iv);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv;

        public ViewHolder(View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.iv);

        }
    }
}
