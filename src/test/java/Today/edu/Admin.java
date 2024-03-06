package Today.edu;

import io.cucumber.java.en.*;

import static org.junit.Assert.*;

public class Admin {
    public MyAppT obj;


    public Admin(MyAppT iobj) {
        super();
        this.obj = iobj;


    }

    @Given("the admin is logged in")
    public void the_admin_is_logged_in() {
        boolean b = obj.isAdminFlag();
    }

    @When("the admin selects {int}")
    public void the_admin_selects(Integer int1) {
      obj.selectFromAdminMenu(int1);
    }
    @When("the user list created")
    public void the_user_list_created() {
      obj.showUserListForAdmin();
    }
    @When("the event list created")
    public void the_event_list_created() {
      obj.showEventForAdmin();
    }
    @When("the service provider list created")
    public void the_service_provider_list_created() {
       obj.showSPtForAdmin();
    }
    @Then("the list of all registered users in the application is displayed")
    public void the_list_of_all_registered_users_in_the_application_is_displayed() {
        assertTrue(obj.isShowUserListForAdminFlag());
    }

    @Then("the list of all service providers in the application is displayed")
    public void the_list_of_all_service_providers_in_the_application_is_displayed() {
     assertTrue(obj.isShowSPtForAdminFlag());
    }

    @Then("the list of all event in the application is displayed")
    public void the_list_of_all_event_in_the_application_is_displayed() {
      assertTrue(obj.isShowEventForAdminFlag());
    }



    @When("adds the description of an event {string} and the cost {double} and id {int}")
    public void adds_the_description_of_an_event_and_the_cost_and_id(String string, Double double1, Integer int1) {
        obj.createPackage(string,double1,int1);
    }


    @Then("the new ready-made package is created successfully")
    public void the_new_ready_made_package_is_created_successfully() {
       assertTrue(obj.isCreatePackageFlag());
    }

    @When("selects {int} To delete")
    public void selects_to_delete(Integer int1) {
        obj.deletePackage(int1);

    }

    @Then("the selected package is deleted successfully")
    public void the_selected_package_is_deleted_successfully() {
assertTrue(obj.isDeletePackageFlag());
    }
    @Given("there exist ready-made packages in the application")
    public void there_exist_ready_made_packages_in_the_application() {
     boolean b= obj.checkPackageList();
    }

    @When("the package list created")
    public void the_package_list_created() {
       obj.showPackageForAdmin();
    }

    @Then("the list of all package in the application is displayed")
    public void the_list_of_all_package_in_the_application_is_displayed() {
      assertTrue(obj.isShowPackageForAdminFlag());
    }
}
