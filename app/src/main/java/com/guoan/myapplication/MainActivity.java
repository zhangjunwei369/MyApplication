package com.guoan.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> list1 = new ArrayList<>();
    private ArrayList<String> list2 = new ArrayList<>();
    private ArrayList<String> localFileSizeDiffs = new ArrayList<String>();
    private ArrayList<String> remoteFileSizeDiffs = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*启动app：     “launcher://com.guoan.tv”
    启动商品分类 “class://com.guoan.tv”
    启动聚合分类 “goods://com.guoan.tv”*/

    public void open(View view) {
        startAppWithScheme(this, "launcher://com.guoan.tv", "");
    }

    public void open1(View view) {
        startAppWithScheme(this, "class://com.guoan.tv", "");
    }

    public void open2(View view) {
        startAppWithScheme(this, "goods://com.guoan.tv", "95da218b9259d5432ba70381982e1f8e");
    }

    /**
     * 通过scheme uri 启动指定app
     * 类似外部网页启动app
     *
     * @param context
     * @param url
     */

    public void startAppWithScheme(Context context, String url, String url1) {
        Uri uri = Uri.parse(url);
        Intent action = new Intent("android.intent.action.VIEW");
        if (!TextUtils.isEmpty(url1)) {
            action.putExtra("CATEGORY_ID", url1);
        }
        action.setData(uri);
        PackageManager manager = context.getPackageManager();
        List list = manager.queryIntentActivities(action, 64);
        if (!list.isEmpty()) {
            context.startActivity(action);
        } else {
//            ToastUtil.INSTANCE.showToast(context, "未安装该应用");
            Toast.makeText(context, "未安装该应用", Toast.LENGTH_SHORT).show();
        }

    }

    //        LinkedList<String> diffent = (LinkedList<String>) CollectionUtil.getDiffent(list1, list2);
//        StringBuffer stringBuffer = new StringBuffer();
//        for (int i = 0; i < diffent.size(); i++) {
//            stringBuffer.append(diffent.get(i));
//        }
//        Log.i("aaa",stringBuffer.toString()+" ");
//        StringBuffer stringBuffer = new StringBuffer();
//        Map<String, Integer> diffrent = getDiffrent(list1, list2);
////        for(Map.Entry<String,Integer> entry:diffrent.entrySet()){
////            stringBuffer.append(entry.getKey()+"__"+entry.getValue()+"\n");
////        }
//        for (Map.Entry<String, Integer> entry : diffrent.entrySet()) {
//            if (entry.getValue() == 1) {
//                localFileSizeDiffs.add(entry.getKey());
//            } else {
//                remoteFileSizeDiffs.add(entry.getKey());
//            }
//            Log.i("&&不同项", "key:" + entry.getKey() + "," + "value:" + entry.getValue()+"\n");
//        }
//        StringBuffer stringBuffer1 = new StringBuffer();
//        for (int i = 0; i < localFileSizeDiffs.size(); i++) {
//            stringBuffer1.append(localFileSizeDiffs.get(i));
//        }
//        Log.i("&&本地集合", stringBuffer1.toString()+"\n");
//
//        StringBuffer stringBuffer2 = new StringBuffer();
//        for (int i = 0; i < remoteFileSizeDiffs.size(); i++) {
//            stringBuffer2.append(remoteFileSizeDiffs.get(i));
//        }
//        Log.i("&&远程集合", stringBuffer2.toString()+"\n");
    public static Map<String, Integer> getDiffrent(List<String> localLists, List<String> remoteLists) {
        Map<String, Integer> map = new HashMap<String, Integer>(localLists.size() + remoteLists.size());
        Map<String, Integer> diff = new HashMap<String, Integer>(localLists.size() + remoteLists.size());
        for (String string : localLists) {
            map.put(string, 1);
        }
        for (String string : remoteLists) {
            if (map.get(string) != null) {
                map.put(string, 2);
                continue;
            }
            diff.put(string, 2);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                diff.put(entry.getKey(), 1);
            }
        }
        return diff;
    }
}
