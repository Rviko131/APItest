package StepsDef;

import PageObjects.UpdatingUserPage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class MyStepdefs {
    WebDriver driver;
    UpdatingUserPage updatingUserPage;
    Post myCreatedUser;



    @Before
    public void setUp () {
        System.setProperty("webdriver.chrome.driver", "c:\\Vika testing\\SELENIUM!\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        updatingUserPage = new UpdatingUserPage(driver);


    }

    @Given("^creating a user$")
    public void creatingAUser()  throws UnirestException{
            Post user1 = new Post(66, "Jeff", "Jeff333", "Jeff45@gmail.com", "1452 Sacramento","3177565566");
            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = gsonBuilder.create();
            String user1gson = gson.toJson(user1);
            HttpResponse<JsonNode> responce = Unirest
                    .post("https://seleniumclass.000webhostapp.com/api/v1/users")
                    .header("Content-Type", "application/json")
                    .body(user1gson)
                    .asJson();

        }


    @Given("^user navigates to created user$")
    public void userNavigatesToCreatedUser() throws UnirestException {
        HttpResponse<JsonNode> response
                = Unirest.get("https://seleniumclass.000webhostapp.com/api/v1/users/66").asJson();

        Gson gson = new Gson();
        myCreatedUser = gson.fromJson(response.getBody().toString(), Post.class);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://seleniumclass.000webhostapp.com/web/index.php?r=users%2Fupdate&id="+myCreatedUser.getId());
    }


    @When("^user fills id input$")
    public void userFillsIdInput() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        updatingUserPage.setUserIdInput("55");
    }


    @And("^fill up name input$")
    public void fillUpNameInput() {
        updatingUserPage.setUserNameInput("Vika");

    }

    @And("^fill up user name input$")
    public void fillUpUserNameInput() {
        updatingUserPage.setUserNickNameInput("Rviko1211");

    }

    @And("^fill up email input$")
    public void fillUpEmailInput() {
        updatingUserPage.setUserEmailInput("Rviko1312@gmail.com");

    }

    @And("^fill up address input$")
    public void fillUpAddressInput() {
        updatingUserPage.setUserAddressInput("1232 w California");

    }

    @And("^fill up phone input$")
    public void fillUpPhoneInput() {
        updatingUserPage.setUsersPhoneInput("2113456777");

    }

    @And("^save changes$")
    public void saveChanges() {
        updatingUserPage.saveChanges();
    }


    @Then("^the user is updated$")
    public void theUserIsUpdated() throws UnirestException {
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        HttpResponse<JsonNode> response
                = Unirest.get("https://seleniumclass.000webhostapp.com/api/v1/users/55").asJson();

        Gson gson = new Gson();
        Post myChangedUser = gson.fromJson(response.getBody().toString(), Post.class);
        String myCreatedUserString = myCreatedUser.name + myCreatedUser.username + myCreatedUser.address + myCreatedUser.email + myCreatedUser.phone;
        String myChangedUserString = myChangedUser.name + myChangedUser.username + myChangedUser.address + myChangedUser.email + myChangedUser.phone;
        Assert.assertNotEquals(myCreatedUserString, myChangedUserString);
    }

    @After
    public void closing(){
        driver.quit();
    }


}
