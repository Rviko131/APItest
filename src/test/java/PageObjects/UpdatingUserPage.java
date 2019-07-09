package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class UpdatingUserPage {

    @FindBy(id = "users-id")
    private WebElement userIdInput;

    @FindBy(id = "users-name")
    private WebElement userNameInput;

    @FindBy(id = "users-username")
    private WebElement userNickNameInput;

    @FindBy(id = "users-email")
    private WebElement userEmailInput;

    @FindBy(id = "users-address")
    private WebElement userAddressInput;

    @FindBy(id = "users-phone")
    private WebElement usersPhoneInput;

    @FindBy(xpath = "//*[@id=\"w0\"]/div[7]/button")
    private WebElement saveChangesBtm;



    public void setUserIdInput (String userId){
        userIdInput.clear();
        userIdInput.sendKeys(userId);
    }
    public void setUserNameInput (String name){
        userNameInput.clear();
        userNameInput.sendKeys(name);
    }
    public void setUserNickNameInput (String nickName){
        userNickNameInput.clear();
        userNickNameInput.sendKeys(nickName);
    }
    public void setUserEmailInput (String email){
        userEmailInput.clear();
        userEmailInput.sendKeys(email);
    }
    public void setUserAddressInput (String address){
        userAddressInput.clear();
        userAddressInput.sendKeys(address);
    }
    public void setUsersPhoneInput(String phone){
        usersPhoneInput.clear();
        usersPhoneInput.sendKeys(phone);
    }
    public void saveChanges(){
        saveChangesBtm.click();
    }

    public UpdatingUserPage (WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
