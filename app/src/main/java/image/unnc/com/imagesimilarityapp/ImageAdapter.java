
package image.unnc.com.imagesimilarityapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import image.unnc.com.imagesimilarityapp.model.image;

/**
 * Created by hudie on 2017/4/13.
 */

public class ImageAdapter extends BaseAdapter {
    private List<image> list;
    private LayoutInflater inflater;
    Context context;

    public ImageAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
        inflater = LayoutInflater.from(context);
    }



    public void setData(List<image> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return list.get(position).getId();
    }
/////////////////

    public String getItemName(int position) {
        return list.get(position).getName();
    }
    public String getItemAuthor(int position) {
        return list.get(position).getAuthor();
    }
    public String getItemIntro(int position) {
        return list.get(position).getInstro();
    }
    public String getItemImage(int position) {
        return list.get(position).getImage();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ImageGridViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ImageGridViewHolder();
            convertView = inflater.inflate(R.layout.image_item, null);
            viewHolder.v_image = (ImageView) convertView.findViewById(R.id.image);
            viewHolder.v_similarity = (TextView) convertView.findViewById(R.id.similarity);
            convertView.setTag(viewHolder);
        }

        viewHolder = (ImageGridViewHolder) convertView.getTag();
        image bean = list.get(position);

        // 设置图片


        // 设置其他
//        viewHolder.v_image.setImageBitmap(Bytes2Bimap(bean.getSimilarity()));

        Glide.with(viewHolder.v_image.getContext()).load(bean.getImage()).into(viewHolder.v_image);


        viewHolder.v_similarity.setText(bean.getSimilarity()+"%");
        return convertView;
    }


     public Bitmap Bytes2Bimap(byte[] b) {
        if (b.length != 0) {
            return BitmapFactory.decodeByteArray(b, 0, b.length);
        } else {
             return null;
        }

     }





}



class ImageGridViewHolder {
    public ImageView v_image;
    public TextView v_similarity;
}