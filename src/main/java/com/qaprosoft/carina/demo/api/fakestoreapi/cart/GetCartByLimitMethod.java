package com.qaprosoft.carina.demo.api.fakestoreapi.cart;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.R;


@Endpoint(url = "${config.env.api_url_t}/carts?limit=${limit}&sort=desc", methodType = HttpMethodType.GET)
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetCartByLimitMethod extends AbstractApiMethodV2 {
    public GetCartByLimitMethod() {
        replaceUrlPlaceholder("limit", R.TESTDATA.get("limit"));
        replaceUrlPlaceholder("desc", R.TESTDATA.get("desc"));
    }
}
