package Today.edu;

import Today.edu.MyAppT;
import io.cucumber.java.en.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class loginstep {
    public MyAppT obj;
    public boolean forget = false;


    public loginstep(MyAppT iobj) {
        super();
        this.obj = iobj;
       Person u1= new Person ("haya","123","7\3\2004","0599222333");
        obj.addUser(u1);
        Person u2= new Person("Asma@gmail.com","1234","7\3\2004","0594507933");
        obj.addUser(u2);


    }


    @Given("I am not in system")
    public void i_am_not_in_system() {
        obj.iAmNotInSystem(obj);
    }

    @When("set username {string} and pass {string}")
    public void set_username_and_pass(String string, String string2) {
        obj.setUsernameAndPassAndPassFromSystem(string,string2);
    }

    @Then("login succeed")
    public void login_succeed() {
        assertTrue("Login should succeed", obj.getValidation());
    }

    @When("set invalid username {string} and pass {string}")
    public void setInvalidUsernameAndPass(String user_name, String pass) {
        obj.setInvalidUsernameAndPass(user_name,pass);
    }
    @Then("login failed")
    public void loginFailed() {
        assertFalse("Login should fail", obj.getValidation());
    }

    @When("set valid username {string} and invalid pass {string}")
    public void setValidUsernameAndInvalidPass(String user_name, String pass) {
        obj.setValidUsernameAndInvalidPass(user_name,pass);
    }

    @When("set empty username {string} and pass {string}")
    public void setEmptyUsernameAndPass(String user_name, String pass) {

        obj.setEmptyUsernameAndPass(user_name,pass);
    }

    @When("set valid username {string} and empty pass {string}")
    public void setValidUsernameAndEmptyPass(String user_name, String pass) {

        obj.setValidUsernameAndEmptyPass(user_name,pass);

    }

    @When("set valid username {string} and  pass {string}")
    public void setValidUsernameAndPass(String user_name, String pass) {
        obj.validUserPass(user_name,pass);
        forget=obj.getForget();
    }

    @Then("take new pass {string}")
    public void takeNewPass(String newPass) {
        obj.takePass(newPass);
        assertTrue("New password should be updated", obj.getPasswordUpdated());
    }

    @And("i don't have an account")
    public void iDonTHaveAnAccount() {
        obj.setLogged(false);
    }


    @Then("create succeed")
    public void createSucceed() {

        assertTrue("User creation should succeed", obj.getUserCreated());
    }

    @When("set new username {string} and pass {string} and bd={string} and phone numbr={string} and email={string}")
    public void set_new_username_and_pass_and_bd_and_phone_numbr_and_email(String string, String string2, String string3, String string4, String string5) {
        obj.createAccountForUser(string, string2,string3,string4,string5);

    }

    @When("set new username {string} and pass {string} and bd={string} and sType={string} and phone numbr={string} and email= {string}")
    public void set_new_username_and_pass_and_bd_and_s_type_and_phone_numbr_and_email(String string, String string2, String string3, String string4, String string5, String string6) {
       obj.createAccountForSp(string, string2,string3,string5,string4,string6);

    }

}
