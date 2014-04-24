package org.showcase.app.api;

import org.showcase.app.model.BaseRequest;
import org.showcase.app.model.Viewpoint;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.http.Body;
import retrofit.http.POST;

/**
 * Created by hugh on 4/24/14.
 */
public class ApiClient {

    private static CrossRoadService S_CRService;

    public static CrossRoadService getService(){
        if(null == S_CRService){
            RestAdapter _adapter = new RestAdapter.Builder().setEndpoint("http://www.cross-v.me/crservices").setLogLevel(RestAdapter.LogLevel.FULL).
                    setLog(new RestAdapter.Log() {
                        @Override
                        public void log(String msg) {
                            System.out.println("___________"+msg);
                        }
                    }).build();
            S_CRService = _adapter.create(CrossRoadService.class);
        }
        return S_CRService;
    }

    public interface CrossRoadService{
        @POST("/queryvp")
        void queryViewpointsByKeywords(@Body BaseRequest request, Callback<List<Viewpoint>> callback);
    }

}
