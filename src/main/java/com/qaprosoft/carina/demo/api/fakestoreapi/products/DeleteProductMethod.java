package com.qaprosoft.carina.demo.api.fakestoreapi.products;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.R;

@Endpoint(url = "${config.env.api_url_t}/products/${product_id}", methodType = HttpMethodType.DELETE)
@RequestTemplatePath(path = "api/products/fakestoreapi/product/_delete/rq.json")
@ResponseTemplatePath(path = "api/products/fakestoreapi/product/_delete/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class DeleteProductMethod extends AbstractApiMethodV2 {
    public DeleteProductMethod() {
        replaceUrlPlaceholder("product_id", R.TESTDATA.get("product_id"));
    }
}
