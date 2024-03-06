package Today.edu;

import io.cucumber.java.en.*;

import static org.junit.Assert.assertTrue;

public class Serviceproviderfeature {


    public MyAppT obj;


    public Serviceproviderfeature(MyAppT iobj) {
        super();
        this.obj = iobj;


    }








        @Given("the service provider is logged in")
    public void the_service_provider_is_logged_in() {
            boolean b = obj.isServiceProviderFlag();

        }

    @When("the service provider selects {int}")
    public void the_service_provider_selects(Integer int1) {
        obj.selectServiceProviderMenu(int1);
    }


    @When("fills in the details including description {string}, price {int}, and ID {int} and service provider {string}")
    public void fills_in_the_details_including_description_price_and_id_and_service_provider(String string, Integer int1, Integer int2, String string2) {
        obj.addServiceToSp(string,int1,int2,string2);
    }

    @Then("the new service is added successfully")
    public void the_new_service_is_added_successfully() {
      assertTrue(obj.isServiceaddedsucc());
    }



    @When("edits the details of the service including description {string}, price {int}, and ID {int} and service provider {string}")
    public void edits_the_details_of_the_service_including_description_price_and_id_and_service_provider(String string, Integer int1, Integer int2, String string2) {
        obj.editServiceForSp(string,int1,int2,string2);
    }
    @Then("the service is modified successfully")
    public void the_service_is_modified_successfully() {
       assertTrue(obj.isEditServiceForSpFlag());
    }


    @When("the service with id {int} to delete it and service provider {string}")
    public void the_service_with_id_to_delete_it_and_service_provider(Integer int1, String string) {
      obj.deleteServiceForSp(int1,string);
    }

    @Then("the selected service is deleted successfully")
    public void the_selected_service_is_deleted_successfully() {
      assertTrue(obj.isDeleteServiceForSpFlag());
    }
    @When("his name is {string} to see users and services")
    public void his_name_is_to_see_users_and_services(String string) {
      obj.showUsersAndEventsForSp(string);
    }

    @Then("the list of users who chose the service provider's services is displayed")
    public void the_list_of_users_who_chose_the_service_provider_s_services_is_displayed() {
      assertTrue(obj.isShowUsersAndEventsForSpFlag());
    }
    @When("his name is {string}")
    public void his_name_is(String string) {
        obj.showservicesForSp(string);
    }

    @Then("the list of services")
    public void the_list_of_services() {
       assertTrue(obj.isShowservicesForSpFlag());
    }















}
