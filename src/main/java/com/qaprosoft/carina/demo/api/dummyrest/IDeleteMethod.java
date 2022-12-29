package com.qaprosoft.carina.demo.api.dummyrest;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;


@Endpoint(url = "${config.evn.api_url_f}/delete/${config.env.id}", methodType = HttpMethodType.DELETE)
@RequestTemplatePath(path = "api/users/first/_delete/rq.json")
@ResponseTemplatePath(path = "api/users/first/_delete/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class IDeleteMethod extends AbstractApiMethodV2 {
}
