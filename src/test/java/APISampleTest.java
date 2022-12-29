import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.demo.api.fakestoreapi.DeleteMethod;
import com.qaprosoft.carina.demo.api.fakestoreapi.GetUserMethod;
import com.qaprosoft.carina.demo.api.fakestoreapi.PostUserMethod;

import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;


public class APISampleTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());



    // GET_ALL, Third Test Case (Works)
    @Test
    public void getAll() {
        GetUserMethod tGetUserMethod = new GetUserMethod();
        tGetUserMethod.callAPIExpectSuccess();
        tGetUserMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        tGetUserMethod.validateResponseAgainstSchema("api/users/fakestoreapi/_get/rs.schema");
    }

    // DELETE for Third Test Case (Works)
    @Test
    public void deleteById() {
        DeleteMethod tDeleteMethod = new DeleteMethod();
        tDeleteMethod.callAPIExpectSuccess();
        tDeleteMethod.validateResponse();
    }

    // POST for Third Test Case (Works)
    @Test
    public void post() {
        PostUserMethod tPostUserMethod = new PostUserMethod();
        tPostUserMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        tPostUserMethod.callAPI();
        tPostUserMethod.validateResponse();
    }


    public void random(){}

}
