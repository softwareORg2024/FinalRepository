package ttoday.edu;

import io.cucumber.java.en.*;

import static org.junit.Assert.assertTrue;

public class roles {
    public MyAppT obj;
    private String userRole;
    public roles(MyAppT iobj) {
        super();
        this.obj = iobj;
    }





    @Given("I am in system")
    public void i_am_in_system() {
        obj.setLogged(true);
    }


@When("the admin enter")
public void the_admin_enter() {
    obj.openRoleMenu();
}


    @Then("you can see admin menu")
    public void you_can_see_admin_menu() {
      assertTrue( obj.isAdminFlag());

    }


    @When("the user enter")
    public void the_user_enter() {
        obj.openRoleMenu();
    }
    @Then("You can see service provider menu")
    public void you_can_see_service_provider_menu() {
        assertTrue( obj.isServiceProviderFlag());
    }
    @When("the service provider enter")
    public void the_service_provider_enter() {
        obj.openRoleMenu();
    }

    @Then("You can see user menu")
    public void you_can_see_user_menu() {
        assertTrue( obj.isUserFlag());
    }























}
