package max.jy.hzl.newgeeknews.mokuai.zhihu.fragment.daillynews;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import max.jy.hzl.newgeeknews.R;

public class DaillyNewsRlvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int TWO = 2;
    private int NewPosition = 0;


    public DaillyNewsRlvAdapter(Context context) {
        this.context = context;
    }

    private List<DaillyNewsBean.TopStoriesBean> top_stories=new ArrayList<>();
    private List<DaillyNewsBean.StoriesBean> stories=new ArrayList<>();
    private String date;

    public void setTop_stories(List<DaillyNewsBean.TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
        notifyDataSetChanged();
    }

    public void setStories(List<DaillyNewsBean.StoriesBean> stories) {
        this.stories = stories;
        notifyDataSetChanged();
    }

    public void setDate(String date) {
        this.date = date;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            return new viewHolder1(View.inflate(context, R.layout.dailly_rlv_item, null));
        } else if (viewType == 1) {
            return new viewHolder2(View.inflate(context, R.layout.dailly_rlv_item2, null));
        } else {
            return new viewHolder3(View.inflate(context, R.layout.dailly_rlv_item3, null));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        if (viewType == 0) {
            viewHolder1 holder1 = (viewHolder1) holder;
            holder1.ban.setImages(top_stories).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    DaillyNewsBean.TopStoriesBean top = (DaillyNewsBean.TopStoriesBean) path;
                    Glide.with(context).load(top.getImage()).into(imageView);
                }
            }).start();
        } else if (viewType==1) {
                viewHolder2 holder2= (viewHolder2) holder;
                holder2.tv.setText(date);

        } else {

            int newPostion = position - 1;
            if (top_stories.size() > 0) {
                newPostion -= 1;
            }


            viewHolder3 holder3= (viewHolder3) holder;
            holder3.tv.setText(stories.get(newPostion).getTitle());
            Glide.with(context).load(stories.get(newPostion).getImages().get(ZERO)).into(holder3.iv);

        }

    }

    @Override
    public int getItemCount() {
        if (top_stories.size() > 0) {
            return stories.size() + 2;
        } else {
            return stories.size() + 1;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(top_stories.size()>ZERO){

            if(position==ZERO){
                return ZERO;
            }else if(position==ONE){
                return ONE;
            }else {
                return TWO;
            }

        }else {
            if(position==ZERO){
                return ONE;
            }else {
                return TWO;
            }


        }

    }


    public class viewHolder1 extends RecyclerView.ViewHolder {
        private Banner ban;

        public viewHolder1(View itemView) {
            super(itemView);
            ban = itemView.findViewById(R.id.ban);
        }
    }

    public class viewHolder2 extends RecyclerView.ViewHolder {
        private TextView tv;

        public viewHolder2(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv_rlv_item2);
        }
    }

    public class viewHolder3 extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView tv;

        public viewHolder3(View itemView) {
            super(itemView);

            iv = itemView.findViewById(R.id.iv_rlv_item3);
            tv = itemView.findViewById(R.id.tv_rlv_item3);
        }
    }
}
