import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.demo.api.firstUrl.IDeleteMethod;
import com.qaprosoft.carina.demo.api.firstUrl.IGetUserMethod;
import com.qaprosoft.carina.demo.api.firstUrl.IPostUserMethod;
import com.qaprosoft.carina.demo.api.secondUrl.SDeleteMethod;
import com.qaprosoft.carina.demo.api.secondUrl.SGetUserMethod;
import com.qaprosoft.carina.demo.api.secondUrl.SPostUserMethod;
import com.qaprosoft.carina.demo.api.thirdUrl.TDeleteMethod;
import com.qaprosoft.carina.demo.api.thirdUrl.TGetUserMethod;
import com.qaprosoft.carina.demo.api.thirdUrl.TPostUserMethod;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;


public class APISampleTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    // GET_ALL , First Test Case (Works)
    @Test
    public void firstTest() {
        IGetUserMethod iGetUserMethod = new IGetUserMethod();
        iGetUserMethod.callAPIExpectSuccess();
        iGetUserMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        iGetUserMethod.validateResponseAgainstSchema("api/users/first/_get/rs.schema");
    }

    // GET_ALL ,Second Test Case (Works)
    @Test
    public void secondTest() {
        SGetUserMethod sGetUserMethod = new SGetUserMethod();
        sGetUserMethod.callAPIExpectSuccess();
        sGetUserMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        sGetUserMethod.validateResponseAgainstSchema("api/users/second/_get/rs.schema");
    }

    // GET_ALL, Third Test Case (Works)
    @Test
    public void thirdTest() {
        TGetUserMethod tGetUserMethod = new TGetUserMethod();
        tGetUserMethod.callAPIExpectSuccess();
        tGetUserMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        tGetUserMethod.validateResponseAgainstSchema("api/users/third/_get/rs.schema");
    }

    // DELETE for First Test Case (Works)
    @Test
    @TestPriority(Priority.P1)
    public void fourthTest() {
        IDeleteMethod iDeleteMethod = new IDeleteMethod();
        iDeleteMethod.callAPIExpectSuccess();
        iDeleteMethod.validateResponse();
    }


    // DELETE for Second Test Case (Works)
    @Test
    public void fifthTest() {
        SDeleteMethod sDeleteMethod = new SDeleteMethod();
        sDeleteMethod.callAPIExpectSuccess();
        sDeleteMethod.validateResponse();
    }

    // DELETE for Third Test Case (Works)
    @Test
    public void sixthTest() {
        TDeleteMethod tDeleteMethod = new TDeleteMethod();
        tDeleteMethod.callAPIExpectSuccess();
        tDeleteMethod.validateResponse();
    }


    // POST for First Test Case (Works)
    @Test
    public void seventhTest() {
        IPostUserMethod iPostUserMethod = new IPostUserMethod();
        iPostUserMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        iPostUserMethod.callAPI();
        iPostUserMethod.validateResponse();
    }

    // POST for Second Test Case (Works)
    @Test
    public void eightTest() {
        SPostUserMethod sPostUserMethod = new SPostUserMethod();
        sPostUserMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        sPostUserMethod.callAPI();
        sPostUserMethod.validateResponse();
    }


    // POST for Third Test Case (Works)
    @Test
    public void ninthTest() {
        TPostUserMethod tPostUserMethod = new TPostUserMethod();
        tPostUserMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        tPostUserMethod.callAPI();
        tPostUserMethod.validateResponse();
    }

}
