package com.sinothk.widget.dragDeleteView.demo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.sinothk.widget.dragDeleteView.DragDeleteView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private List<String> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 设置连接线的颜色
        DragDeleteView dragDeleteView = (DragDeleteView) findViewById(R.id.text);
        dragDeleteView.setOnDragListener(new DragDeleteView.OnDragListener() {
            @Override
            public void OnDragCompleted() {
                Toast.makeText(MainActivity.this, "OnDragCompleted", Toast.LENGTH_SHORT).show();
            }
        });


        datas = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            datas.add("item" + i);
        }

        ((ListView) findViewById(R.id.list)).setAdapter(new MyAdapter(this));
    }

    class MyAdapter extends BaseAdapter {

        LayoutInflater inflater;

        public MyAdapter(Context context) {
            inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public Object getItem(int position) {
            return datas.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();

                convertView = inflater.inflate(R.layout.list_item, null);
                holder.textView = (TextView) convertView.findViewById(R.id.title);

                holder.dragDeleteView = (DragDeleteView) convertView.findViewById(R.id.ddtv);

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.textView.setText(datas.get(position));

            if (position == datas.size() - 1) {
                holder.dragDeleteView.setVisibility(View.GONE);
            } else {
                holder.dragDeleteView.setText(String.valueOf(position));
                holder.dragDeleteView.setVisibility(View.VISIBLE);
            }


            holder.dragDeleteView.setOnDragListener(new DragDeleteView.OnDragListener() {
                @Override
                public void OnDragCompleted() {
                    Toast.makeText(MainActivity.this, "position = " + position, Toast.LENGTH_SHORT).show();
                }
            });

            return convertView;
        }

        class ViewHolder {
            TextView textView;
            DragDeleteView dragDeleteView;
        }

    }

}
