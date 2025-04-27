import apiTesting.Address;
import apiTesting.Company;
import apiTesting.Geo;
import apiTesting.User;
import io.restassured.response.ValidatableResponse;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CRUDTest {

    String endpoint = "https://jsonplaceholder.typicode.com/users";

    int recordsSize = 10;
    int userById = 1;
    String usernameById = "Bret";

    Geo geo = new Geo("37.52477206095617", "126.96427059051587");
    Address address = new Address(
            "Teheran-ro 108-gil",
            "42",
            "Gangnam-gu, Seoul",
            "04389",
            geo
    );
    Company company = new Company(
            "HYBE",
            "Shaping the future of entertainment, one dream at a time",
            "WE BELIEVE IN MUSIC"
    );
    User user = new User(
            "Min Yoongi",
            "Suga",
            "suga@bts.kor",
            address,
            "+82)02-568-1277",
            "hybeim.com",
            company
    );


    @Test
    @Description("Get all users (GET)")
    public void getUsers() {
        ValidatableResponse response = given().when().get(endpoint).then().log().status().log().body();
        response.assertThat()
                .statusCode(200)
                .body("records.size()", equalTo(recordsSize));
    }

    @Test
    @Description("Get user by id (GET)")
    public void getUserById() {
        ValidatableResponse response = given().when()
                .get(endpoint + "/" + userById).then().log().status().log().body();
        response.assertThat()
                .statusCode(200)
                .body("id", equalTo(userById))
                .body("username", equalTo(usernameById));
    }

    @Test
    @Description("Add user (POST)")
    public void addUser() {
        ValidatableResponse response = given()
                .header("Content-Type", equalTo("application/json"))
                .body(user)
                .when().post(endpoint).then().log().status().log().body();
        response.assertThat()
                .statusCode(201)
                .body("name", equalTo("Min Yoongi"))
                .body("username", equalTo("Suga"))
                .body("email", equalTo("suga@bts.kor"));
    }

    @Test
    @Description("Update user (PUT)")
    public void updateUser() {

        int id = 11;
        String updateBody = "{\n" +
                "\"name\": \"Jeon Jungkook\",\n" +
                "\"username\": \"JK\",\n" +
                "\"email\": \"jk@bts.com\"\n" +
                "}";

        ValidatableResponse response = given().
                header("Content-Type", "application/json").
                body(updateBody).
                when().
                put(endpoint + "/" + id).
                then().log().status().log().body();

        response.assertThat()
                .statusCode(200)
                .body("id", equalTo(11))
                .body("username", equalTo("JK"));
    }

    @Test
    @Description("Delete user (DELETE)")
    public void deleteUser() {

        int id = 11;
        ValidatableResponse response = given().when()
                .delete(endpoint + "/" + id).
                then().log().status().log().body();

        response.assertThat().
                statusCode(200).
                body("id", equalTo(id));
    }
}
