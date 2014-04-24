package org.showcase.app;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.showcase.app.api.ApiClient;
import org.showcase.app.model.BaseRequest;
import org.showcase.app.model.Viewpoint;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
        */
        BaseRequest _request = new BaseRequest();

        _request.setQuery("test");

        ApiClient.getService().queryViewpointsByKeywords(_request, new Callback<List<Viewpoint>>() {
            @Override
            public void success(List<Viewpoint> viewpoints, Response response) {
                System.out.println(">>>>>>>>>>>>>>");
                System.out.println(viewpoints);
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                System.out.println("________");
            }
        });



        ListView _listView = (ListView) findViewById(R.id.viewpointListView);

        List _dataList = new ArrayList<String>();
        _dataList.add("test1");
        _dataList.add("test2");

        ArrayAdapter _adapter = new ArrayAdapter(this, R.layout.viewpoint_list_item, R.id.label, _dataList);

        _listView.setAdapter(_adapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            ListView _listView = (ListView)inflater.inflate(R.id.viewpointListView, container, false);


            return rootView;
        }
    }

}
