package com.android.benben.http;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import timber.log.Timber;

/**
 * Created by benben on 2016/6/17.
 */
public class RetrofitBuilder {
    private String baseUrl;
    private Retrofit mRetrofit;

    private OkHttpClient client;


    /**
     * 构造函数私有化
     *
     * @author Jam
     * create at 2016/5/24 10:49
     */
    private RetrofitBuilder() {
    }


    //make this class thread safe singleton
    private static class SingletonHolder{
        private static final RetrofitBuilder INSTANCE = new RetrofitBuilder();
    }

    public static synchronized RetrofitBuilder get(){
        return SingletonHolder.INSTANCE;
    }

    public Retrofit retrofit(){
        Preconditions.checkNotNull(baseUrl,"Base URL required.");

        if (mRetrofit == null){
            Retrofit.Builder builder = new Retrofit.Builder();
            baseUrl = NetWork.HTTP_ROOT;
            client = new OkHttpClient();
            mRetrofit = builder.baseUrl(Constant.BASE_URL)
                    .addConverterFactory(JacksonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(client)
                    .build();
        }

        return mRetrofit;
    }


    /**
     * 创建给定的 Api Service
     */
    public <T> T create(Class<T> tClass){
        return get().retrofit().create(tClass);
    }


    public static class Builder{
        private String baseUrl;
        private String accept;
        private OkHttpClient mClient;

        public RetrofitBuilder build() {
            Preconditions.checkNotNull(baseUrl, "Base URL required.");
            ensureSaneDefaults();

            RetrofitBuilder retrofitBuilder = get();
            retrofitBuilder.baseUrl = baseUrl;
            retrofitBuilder.client = mClient;

            return retrofitBuilder;
        }

        private void ensureSaneDefaults() {
            if (mClient == null) {
                mClient = defaultClient();
            }
        }

        private OkHttpClient defaultClient() {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                @Override
                public void log(String message) {
                    Timber.d(message);
                }
            });
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(loggingInterceptor);
//            builder.addInterceptor(new DefaultHeaderInterceptor(AccountManager.getInstance(), accept));
            return builder.build();
        }

        public Builder client(OkHttpClient client) {
            mClient = client;
            return this;
        }

        public Builder baseUrl(String baseUrl) {
            Preconditions.checkNotNull(baseUrl, "baseUrl == null");
            this.baseUrl = baseUrl;
            return this;
        }

        public Builder accept(String accept) {
            Preconditions.checkNotNull(accept, "accept == null");
            this.accept = accept;
            return this;
        }
    }

}
