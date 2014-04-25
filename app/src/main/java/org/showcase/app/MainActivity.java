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
import android.widget.Button;
import android.widget.EditText;
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

        final EditText _searchInput = (EditText)findViewById(R.id.search_value);
        Button _button = (Button)findViewById(R.id.search_button);

        _button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _searchValue = _searchInput.getText().toString();
                if(null != _searchValue){
                    BaseRequest _request = new BaseRequest();
                    _request.setQuery(_searchValue);
                    doSearch(_request);
                }
            }
        });

    }

    private final void doSearch(BaseRequest request){
        final ActionBarActivity _currentActivity = this;

        ApiClient.getService().queryViewpointsByKeywords(request, new Callback<List<Viewpoint>>() {
            @Override
            public void success(List<Viewpoint> viewpoints, Response response) {
                ListView _listView = (ListView) findViewById(R.id.viewpointListView);

                List _dataList = new ArrayList<String>();
                for (Viewpoint item : viewpoints){
                    _dataList.add(item.toString());
                }


                ArrayAdapter _adapter = new ArrayAdapter(_currentActivity, R.layout.viewpoint_list_item, R.id.label, _dataList);

                _listView.setAdapter(_adapter);
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                System.out.println("________");
            }
        });
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
