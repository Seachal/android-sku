package com.wuhenzhizao.utils;

import android.content.Context;
import android.content.res.AssetManager;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

/**
 * *
 * *
 * Project_Name:Yuanzi
 *
 * @author zhangxc
 * @date 2019-11-02 10:51
 * *
 */
public class LocalJsonResolutionUtils {


    /**
     * 得到json文件中的内容
     * @param context
     * @param fileName
     * @return
     */
    public static String getJson(Context context, String fileName){
        StringBuilder stringBuilder = new StringBuilder();
        //获得assets资源管理器
        AssetManager assetManager = context.getAssets();
        //使用IO流读取json文件内容
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                    assetManager.open(fileName),"utf-8"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }


//     /**
//     * 将字符串转换为 对象
//     * @param json
//     * @param type
//     * @return
//     * @deprecated
//     */

//    public  static <T> T JsonToObject(String json, Class<T> type) {
//        Gson gson =new Gson();
//        return gson.fromJson(json, type);
//    }
//
//    /**
//     *
//     * 将字符串转换为 对象
//     * @param json
//     * @param type
//     * @return
//     */
//    public  static <T> T JsonToObject(String json, Class<T> type) {
//
//        Gson gson =new Gson();
//        Type srItemsStandardType = new TypeToken<T>() {}.getType();
////        BaseBean<Product> foodCategoryBean = LocalJsonResolutionUtils.JsonToObject(foodJson, BaseBean.class);
//
//
//        return gson.fromJson(json, srItemsStandardType);
//    }




    /**
     * 将字符串转换为 对象
     * @param json
     * @param type
     * @return
     */
    public  static <T> T JsonToObject(String json, Type type) {
        Gson gson =new Gson();
        return gson.fromJson(json, type);
    }

}
