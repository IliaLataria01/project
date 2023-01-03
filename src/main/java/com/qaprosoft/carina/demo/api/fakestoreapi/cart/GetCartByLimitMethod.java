package com.qaprosoft.carina.demo.api.fakestoreapi.cart;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.demo.api.fakestoreapi.enums.Sort;


@Endpoint(url = "${config.env.api_url_t}/carts?limit=${limit}&sort=${sort}", methodType = HttpMethodType.GET)
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetCartByLimitMethod extends AbstractApiMethodV2 {
    public GetCartByLimitMethod(Sort sort) {
        replaceUrlPlaceholder("sort", sort.getSort());
    }

    public void setLimit(int limit) {
        replaceUrlPlaceholder("limit", String.valueOf(limit));
    }
}
