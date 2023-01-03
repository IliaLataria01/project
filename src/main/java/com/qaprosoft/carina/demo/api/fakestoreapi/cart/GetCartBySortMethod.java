package com.qaprosoft.carina.demo.api.fakestoreapi.cart;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.demo.api.fakestoreapi.enums.Sort;


@Endpoint(url = "${config.env.api_url_t}/carts?sort=${sort}", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/products/fakestoreapi/cart/_get/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetCartBySortMethod extends AbstractApiMethodV2 {
    public void sort(Sort sort) {
        replaceUrlPlaceholder("sort", sort.getSort());
    }
}
