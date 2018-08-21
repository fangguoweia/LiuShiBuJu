package com.bwei.LiuShiBuJu;

import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.BaseMenuPresenter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String[] name={"手机","电脑","玩具","手机","电脑","苹果手机", "笔记本电脑", "电饭煲 ", "腊肉",
            "特产", "剃须刀", "宝宝", "康佳", "特产", "剃须刀", "充电宝", "康佳"};

    private ImageView mSearchBack;
    private ImageView mRelationSearch;
    private View mSearchLine;

    //请输入关键词搜索
    private EditText mSearchInputSearch;

    //搜索
    private TextView mResultSearch;
    private CustomView mSearchFlowlayout;

    //清空记录
    private Button mSearchClear;
    private ListView mSearchList;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件
        initView();
        //显示数据
        initData();

    }


    private void initData() {
        for (int i = 0; i <name.length ; i++) {
            textView = new TextView(this);
            textView.setText(name[i]);
            //设置背景
            textView.setBackgroundDrawable(getResources().getDrawable(R.drawable.addatten_edit));
            //设置内边距
            textView.setPadding(5,5,5,5);
            //字体大小
            textView.setTextSize(20);
            //设置颜色
            textView.setTextColor(Color.RED);
            //添加数据
            mSearchFlowlayout.addView(textView);
        }
        //点击搜索添加
        mResultSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = mSearchInputSearch.getText().toString();
                textView = new TextView(MainActivity.this);
                textView.setBackgroundDrawable(getResources().getDrawable(R.drawable.addatten_edit));
                textView.setPadding(5,5,5,5);
                textView.setTextColor(Color.RED);
                textView.setTextSize(20);
                textView.setText(s);
                mSearchFlowlayout.addView(textView);
            }
        });
    }
    private void initView() {
        mSearchBack = (ImageView) findViewById(R.id.search_back);
        mRelationSearch = (ImageView) findViewById(R.id.relation_search);
        mSearchLine = (View) findViewById(R.id.search_line);
        mSearchInputSearch = (EditText) findViewById(R.id.search_input_search);
        mResultSearch = (TextView) findViewById(R.id.result_search);
        mSearchFlowlayout = (CustomView) findViewById(R.id.search_flowlayout);
        mSearchClear = (Button) findViewById(R.id.search_clear);
        mSearchClear.setOnClickListener(this);
    }

    int setChildContenView(){
        return R.layout.activity_main;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            default:
                break;
            case R.id.search_clear:
                mSearchFlowlayout.removeAllViews();
                break;
        }
    }
}
