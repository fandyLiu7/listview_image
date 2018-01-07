package com.fandy.learn.listview_image;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.ListView;

/**
 * listview加载图片的解决方案:
 * 使用setTag解决
 * 使用volly的NetWorkImageView
 */
public class MainActivity extends AppCompatActivity {

    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.list);
        myAdapter = new MyAdapter(this, Image.imageUrls);
        listView.setAdapter(myAdapter);
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState == SCROLL_STATE_IDLE) {
                    myAdapter.changeState();
                } else {
                    myAdapter.stopLoad();
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });

    }
}
