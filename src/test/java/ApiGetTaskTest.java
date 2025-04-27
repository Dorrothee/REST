import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiGetTaskTest {

    String endpoint = "https://jsonplaceholder.typicode.com/users";
    int recordsSize = 10;

    @Test
    @Description("A test to verify an http status code")
    public void validateStatus() {
        given().when().get(endpoint).then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    @Description("A test to verify an http response header")
    public void validateHeader() {
        given().when().get(endpoint).then()
                .assertThat()
                .header("Content-Type", equalTo("application/json; charset=utf-8"));
    }

    @Test
    @Description("A test to verify an http response body")
    public void validateResponseBodySize() {
        given().when().get(endpoint).then()
                .assertThat()
                .body("records.size()", equalTo(recordsSize));
    }

}