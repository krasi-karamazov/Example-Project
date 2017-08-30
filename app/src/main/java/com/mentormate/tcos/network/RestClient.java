package com.mentormate.tcos.network;

import android.content.Context;
import android.support.annotation.Nullable;

import com.mentormate.tcos.network.interceptors.HostSelectionInterceptor;
import com.mentormate.tcos.utils.BuildConstants;

import java.security.cert.CertificateException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {
    /**
     * This is our main backend/server HOST.
     * From this HOST we will obtain the
     */

    private static final String TAG = "RestClient";
    public static final String REST_API_URL = "some_url";
    private static RestClient sInstance;
    private static HostSelectionInterceptor sHostSelectionInerceptor;
    private static Retrofit s_retrofit;

    static {

        // enable logging
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = getUnsafeOkHttpClient();

        s_retrofit = new Retrofit.Builder().baseUrl(REST_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    private RestClient(Context mContext) {
        // BusProvider.getInstance().register(this);
    }

    public static synchronized RestClient getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new RestClient(context);
        }
        return sInstance;
    }

    private static OkHttpClient getUnsafeOkHttpClient() {
        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
                @Override
                public void checkClientTrusted(java.security.cert.X509Certificate[] chain,
                                               String authType) throws CertificateException {
                }

                @Override
                public void checkServerTrusted(java.security.cert.X509Certificate[] chain,
                                               String authType) throws CertificateException {
                }

                @Override
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return new java.security.cert.X509Certificate[]{};
                }
            }};

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(sslSocketFactory);
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            // enable logging
            if (BuildConstants.SHOW_LOGCAT_MESSAGES) {
                builder.addInterceptor(interceptor);
            }

            //for dynamic hosts
            sHostSelectionInerceptor = new HostSelectionInterceptor();
            sHostSelectionInerceptor.setHost(REST_API_URL);
            builder.addInterceptor(sHostSelectionInerceptor);
            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    // TODO: 4/18/2016
                    return true;
                }
            });

            OkHttpClient okHttpClient = builder.build();
            return okHttpClient;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static <T> T getService(Class<T> serviceClass) {
        return s_retrofit.create(serviceClass);
    }


    /**
     * Used in  {@link HostSelectionInterceptor} to change the request host
     *
     * @param host to be used in the calls. Set to null if the default base url is required.
     */
    public static void setHost(@Nullable final String host) {
        sHostSelectionInerceptor.setHost(host);
    }


}
