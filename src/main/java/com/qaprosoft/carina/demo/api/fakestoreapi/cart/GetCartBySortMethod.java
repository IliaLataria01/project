package com.qaprosoft.carina.demo.api.fakestoreapi.cart;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.R;


@Endpoint(url = "${config.env.api_url_t}/carts?sort=${desc}", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/products/fakestoreapi/cart/_get/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetCartBySortMethod extends AbstractApiMethodV2 {
    public GetCartBySortMethod() {
        replaceUrlPlaceholder("desc", R.TESTDATA.get("desc"));
    }
}
