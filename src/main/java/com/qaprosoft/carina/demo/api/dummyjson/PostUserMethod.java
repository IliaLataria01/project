package com.qaprosoft.carina.demo.api.dummyjson;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
@Endpoint(url = "${config.env.api_url_s}/products/add", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/users/dummyrest/_post/rq.json")
@ResponseTemplatePath(path = "api/users/dummyrest/_post/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)
public class PostUserMethod extends AbstractApiMethodV2 { }
