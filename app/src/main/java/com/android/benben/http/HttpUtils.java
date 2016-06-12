package com.android.benben.http;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by benben on 2016/6/12.
 * http相关辅助类
 */
public class HttpUtils {

    private static final int TIMEOUT_IN_MILLIONS = 5000;



    public interface CallBack{
        void onRequestComplete(String result);
    }

    /**
     * 异步的get请求
     */
    public static void doGetAsyn(final String urlstr, final CallBack callBack) {
        new Thread(){
            public void run() {
                String result = doGet(urlstr);
                if (callBack != null) {
                    callBack.onRequestComplete(result);
                }
            }
        }.start();
    }

    private static String doGet(String urlstr) {
        URL url = null;
        HttpURLConnection conn = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;

        try {
            url = new URL(urlstr);
            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(TIMEOUT_IN_MILLIONS);
            conn.setConnectTimeout(TIMEOUT_IN_MILLIONS);
            conn.setRequestMethod("GET");
            conn.setRequestProperty("accept","*/*");
            conn.setRequestProperty("connectin", "keep-Alive");
            if (conn.getResponseCode() == 200) {
                is = conn.getInputStream();
                baos = new ByteArrayOutputStream();
                int len = -1;
                byte[] buf = new byte[128];
                while ((len = is.read(buf)) != -1) {
                    baos.write(buf, 0, len);
                }
                baos.flush();
                return baos.toString();
            }else {
                throw new RuntimeException("responseCode is not 200...");
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }finally {

                try {
                    if (is != null) {
                        is.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            conn.disconnect();
            }

        return null;
    }

    /**异步Post请求*/
    public static void doPostAsyn(final  String urlstr, final  String params,
                                  final CallBack callBack)throws Exception {
        new Thread(){
            public void run() {
                String result = doPost(urlstr, params);
                if (callBack != null) {
                    callBack.onRequestComplete(result);
                }
            }
        }.start();
    }


    /**
     * 想指定URL发送POST方法的请求
     * @param url  发送请求的  url
     * @param params 请求参数 请求参数应该是name=value1&value2 的形式
     * @return 所代表远程资源的相应结果
     * @throws Exception
     */
    private static String doPost(String url, String params) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            /*打开和yrl 之间的链接*/
            HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
            /*设置通用的请求属性*/
            conn.setRequestProperty("accept", "*/*");//接受
            conn.setRequestProperty("connection", "keep-Alive");//链接
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");//内容类型
            conn.setRequestProperty("charset", "urf_8");//字符集
            conn.setUseCaches(false);
            /*发送POST请求必须设置如下两行*/
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setReadTimeout(TIMEOUT_IN_MILLIONS);
            conn.setConnectTimeout(TIMEOUT_IN_MILLIONS);

            if (params != null && !params.trim().equals("")) {
                /*获取URLConnection对象对应的输出流*/
                out = new PrintWriter(conn.getOutputStream());
                /*发送请求参数*/
                out.print(params);
                /*flush输出流的缓冲*/
                out.flush();
            }

            /*定义BufferedReader输入流未读取URL的相应*/
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
             /*使用Finally块 来关闭输入输出流*/

                try {
                    if (out != null) {
                        out.close();
                    }
                    if (in != null) {
                        in.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        return result;
    }
}
