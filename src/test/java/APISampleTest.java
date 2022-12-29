import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.demo.api.dummyrest.IDeleteMethod;
import com.qaprosoft.carina.demo.api.dummyrest.IGetUserMethod;
import com.qaprosoft.carina.demo.api.dummyrest.IPostUserMethod;
import com.qaprosoft.carina.demo.api.dummjson.SDeleteMethod;
import com.qaprosoft.carina.demo.api.dummjson.SGetUserMethod;
import com.qaprosoft.carina.demo.api.dummjson.SPostUserMethod;
import com.qaprosoft.carina.demo.api.fakestoreapi.TDeleteMethod;
import com.qaprosoft.carina.demo.api.fakestoreapi.TGetUserMethod;
import com.qaprosoft.carina.demo.api.fakestoreapi.TPostUserMethod;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
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
        TGetUserMethod tGetUserMethod = new TGetUserMethod();
        tGetUserMethod.callAPIExpectSuccess();
        tGetUserMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        tGetUserMethod.validateResponseAgainstSchema("api/users/third/_get/rs.schema");
    }

    // DELETE for Third Test Case (Works)
    @Test
    public void deleteById() {
        TDeleteMethod tDeleteMethod = new TDeleteMethod();
        tDeleteMethod.callAPIExpectSuccess();
        tDeleteMethod.validateResponse();
    }

    // POST for Third Test Case (Works)
    @Test
    public void post() {
        TPostUserMethod tPostUserMethod = new TPostUserMethod();
        tPostUserMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        tPostUserMethod.callAPI();
        tPostUserMethod.validateResponse();
    }

}
