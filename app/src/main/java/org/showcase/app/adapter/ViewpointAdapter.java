package org.showcase.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.showcase.app.R;
import org.showcase.app.model.Viewpoint;

import java.util.List;

/**
 * Created by yushio1984 on 4/29/14.
 */
public class ViewpointAdapter extends ArrayAdapter<Viewpoint> {
    LayoutInflater _inflater;
    public ViewpointAdapter(Context context, int position, List<Viewpoint> viewpoints) {
        super(context, position, viewpoints);
        _inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View _view = convertView;
        Holder _holder;
        if(null ==  _view){
            _view = _inflater.inflate(R.layout.viewpoint_item, parent, false);

            _holder = new Holder();
            _holder.title = (TextView)_view.findViewById(R.id.title);
            _holder.sub_title = (TextView)_view.findViewById(R.id.sub_title);

            _view.setTag(_holder);
        }else{
            _holder = (Holder)_view.getTag();
        }

        Viewpoint _viewpoint = getItem(position);
        _holder.title.setText(_viewpoint.getViewpoint());
        _holder.sub_title.setText(_viewpoint.getCity());

        return _view;
    }

    private static final class Holder{
        public TextView title;
        public TextView sub_title;

    }
}
