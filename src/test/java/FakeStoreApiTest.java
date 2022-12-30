import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.demo.api.fakestoreapi.DeleteProductMethod;
import com.qaprosoft.carina.demo.api.fakestoreapi.GetAllProductMethod;
import com.qaprosoft.carina.demo.api.fakestoreapi.PostProductMethod;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class FakeStoreApiTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    public void getAllProductsTest() {
        GetAllProductMethod getAllMethod = new GetAllProductMethod();
        getAllMethod.callAPIExpectSuccess();
        getAllMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getAllMethod.validateResponseAgainstSchema("api/products/fakestoreapi/_get/rs.schema");
    }

    @Test
    public void deleteProductById() {
        DeleteProductMethod deleteMethod = new DeleteProductMethod();
        deleteMethod.callAPIExpectSuccess();
        deleteMethod.validateResponse();
    }

    @Test
    public void post() {
        PostProductMethod postMethod = new PostProductMethod();
        postMethod.setProperties("api/products/product.properties");
        postMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        postMethod.callAPI();
        postMethod.validateResponse();
    }

}