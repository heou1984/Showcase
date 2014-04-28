package org.showcase.app.model;

/**
 * Created by hugh on 4/24/14.
 */
public class BaseRequest<T> {

    private T query;

    public T getQuery(){
        return this.query;
    }

    public void setQuery(T query){
        this.query = query;
    }

}
