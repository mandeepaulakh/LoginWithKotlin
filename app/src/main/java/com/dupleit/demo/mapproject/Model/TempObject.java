package com.dupleit.demo.mapproject.Model;

import retrofit2.Response;

/**
 * Created by rajesh on 4/11/17.
 */

public class TempObject {
    Response<UserUImodel> response;

    public TempObject(Response<UserUImodel> response) {
        this.response = response;
    }

    public Response<UserUImodel> getResponse() {
        return response;
    }

}
