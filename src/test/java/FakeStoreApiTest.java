import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.demo.api.fakestoreapi.cart.GetCartByLimitMethod;
import com.qaprosoft.carina.demo.api.fakestoreapi.cart.GetCartBySortMethod;
import com.qaprosoft.carina.demo.api.fakestoreapi.cart.GetUserCartMethod;
import com.qaprosoft.carina.demo.api.fakestoreapi.users.PostLoginMethod;
import com.qaprosoft.carina.demo.api.fakestoreapi.products.DeleteProductMethod;
import com.qaprosoft.carina.demo.api.fakestoreapi.products.GetAllProductMethod;
import com.qaprosoft.carina.demo.api.fakestoreapi.products.PostProductMethod;
import com.qaprosoft.carina.demo.api.fakestoreapi.users.UpdateUserMethod;
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
        getAllMethod.validateResponseAgainstSchema("api/products/fakestoreapi/product/_get/rs.schema");
    }

    @Test
    public void deleteProductByIdTest() {
        DeleteProductMethod deleteMethod = new DeleteProductMethod();
        deleteMethod.callAPIExpectSuccess();
        deleteMethod.validateResponse();
    }

    @Test
    public void postProductTest() {
        PostProductMethod postMethod = new PostProductMethod();
        postMethod.setProperties("api/products/product.properties");
        postMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        postMethod.callAPI();
        postMethod.validateResponse();
    }


    // New Test 1 (works)
    @Test
    public void getAllCartsByDescendingTest() {
        GetCartBySortMethod cartBySortMethod = new GetCartBySortMethod();
        cartBySortMethod.callAPIExpectSuccess();
        cartBySortMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        cartBySortMethod.validateResponseAgainstSchema("api/products/fakestoreapi/cart/_get/rs.schema");
    }

    // New Test 2 (works)
    @Test
    public void getUserCartByIdAscendingTest() {
        GetUserCartMethod getUserCartMethod = new GetUserCartMethod();
        getUserCartMethod.callAPIExpectSuccess();
        getUserCartMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
    }


    // New Test 3 (works)
    @Test
    public void getCartByLimitSortTest() {
        GetCartByLimitMethod getCartByLimit = new GetCartByLimitMethod();
        getCartByLimit.provideLimit(3);
        getCartByLimit.callAPIExpectSuccess();
    }

    // Newt Test 4 (works)
    @Test
    public void useLoginTest() {
        PostLoginMethod postLoginMethod = new PostLoginMethod();
        postLoginMethod.setProperties("api/products/user.properties");
        postLoginMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        postLoginMethod.callAPI();
        postLoginMethod.validateResponse();
    }

    // New Test 5 (works)
    @Test
    public void updateUserTest() {
        UpdateUserMethod updateUserMethod = new UpdateUserMethod();
        updateUserMethod.setProperties("api/products/user.properties");
        updateUserMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        updateUserMethod.callAPI();
        updateUserMethod.validateResponse();
    }
}