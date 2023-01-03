package com.qaprosoft.carina.demo.api.fakestoreapi.users;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;


@Endpoint(url = "${config.env.api_url_t}/users/7", methodType = HttpMethodType.PUT)
@RequestTemplatePath(path = "api/products/fakestoreapi/user/_post/rq.json")
@ResponseTemplatePath(path = "api/products/fakestoreapi/user/_post/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class UpdateUserMethod extends AbstractApiMethodV2 {
}
