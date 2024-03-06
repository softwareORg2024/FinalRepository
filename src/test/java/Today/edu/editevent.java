package Today.edu;
import io.cucumber.java.en.*;

import java.sql.Time;

import static org.junit.Assert.assertTrue;

public class editevent {

    public MyAppT obj;


    public editevent(MyAppT iobj) {
        super();
        this.obj = iobj;


    }


    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        boolean b = obj.isUserFlag();
    }


    @Given("there exists an event created by the user {string}")
    public void there_exists_an_event_created_by_the_user(String string) {
        obj.searchInEventUser(string);
    }

    @When("the user select an event {int} to edit it")
    public void the_user_select_an_event_to_edit_it(Integer int1) {
        obj.serchforevent(int1);
    }


    @Then("the event details are displayed")
    public void the_event_details_are_displayed() {
        assertTrue(obj.isEventfoundflag());
    }

    @Given("the user is on the event details page")
    public void the_user_is_on_the_event_details_page() {
        boolean o = obj.isEventfoundflag();
    }


    @When("the user select {int} to edit")
    public void the_user_select_to_edit(Integer int1) {
        obj.editEventForUserMenu(int1);
    }

    @Then("a list of events created by the user is displayed")
    public void aListOfEventsCreatedByTheUserIsDisplayed() {
        assertTrue(obj.isViewEventsByUserFlag());
    }

    @When("user {string} modifies the event name of event {string} to {string}")
    public void user_modifies_the_event_name_of_event_to(String string, String string2, String string3) {
        obj.editEventNameByUser(string, string2, string3);
    }


    @When("user {string} modifies the event location of event {string} to {int}")
    public void user_modifies_the_event_location_of_event_to(String string, String string2, Integer int1) {
        obj.editLocation(string, string2, int1);
    }

    @When("user {string} modifies the event date of event {string} to date {int}-{int}-{int}")
    public void user_modifies_the_event_date_of_event_to_date(String string, String string2, Integer int1, Integer int2, Integer int3) {
        obj.editEventDateByUser(string, string2, int1, int2, int3);
    }

    @Then("the event date are updated successfully")
    public void the_event_date_are_updated_successfully() {
        assertTrue(obj.isEditEventDateByUserFlag());
    }

    @When("user {string} modifies the event  time of event {string} to  time {int}:{int}:{int}")
    public void user_modifies_the_event_time_of_event_to_time(String string, String string2, Integer int1, Integer int2, Integer int3) {
        obj.editEventTimeByUser(string, string2, int1, int2, int3);
    }

    @Then("the event and time are updated successfully")
    public void the_event_and_time_are_updated_successfully() {
        assertTrue(obj.isEditEventTimeByUserFlag());
    }

    @When("user {string} modifies the number of attendees in event {string} to {int}")
    public void user_modifies_the_number_of_attendees_in_event_omar_s_birthday_to(String string, String string2, Integer int1) {
        obj.editEventNumOfPeapleByUser(string, string2, int1);
    }


    @When("user {string} modifies the event theme in event {string} to {string}")
    public void user_modifies_the_event_theme_in_event_to(String string, String string2, String string3) {
        obj.editEventThemeByUser(string, string2, string3);

    }

    @When("user {string} modifies the event {string}")
    public void user_modifies_the_event(String string, String string2) {
        obj.editToAddAdditionalServiceByUser(string, string2);


    }

    @Then("the services appear")
    public void the_services_appear() {
        assertTrue(obj.isEditToAddAdditionalServiceByUserFlag());
    }

    @When("user {string} delete from event {string} the service with id {int}")
    public void user_delete_from_event_the_service_with_id(String string, String string2, Integer int1) {
        obj.editDeleteServiceFromEventByUser(string, string2, int1);
    }

    @When("user {string} select to remove from event {string} the package")
    public void user_select_to_remove_from_event_the_package(String string, String string2) {
        obj.editDeletePackageFromEventByUser(string, string2);
    }

    @When("user {string} to add")
    public void user_to_add(String string) {
        obj.ViewEventsByUser(string);
    }

    @When("user {string} to delete event {string}")
    public void user_to_delete_event(String string, String string2) {
        obj.DeleteEventByUser(string, string2);

    }


    @Then("the selected event is deleted from the user's events list")
    public void theSelectedEventIsDeletedFromTheUserSEventsList() {
        assertTrue(obj.isDeleteEventByUserFlag());

    }

    @Then("the selected service is removed from the event")
    public void theSelectedServiceIsRemovedFromTheEvent() {
        assertTrue(obj.isEditDeleteServiceFromEventByUserFlag());

    }

    @Then("the event theme is updated successfully")
    public void theEventThemeIsUpdatedSuccessfully() {
        assertTrue(obj.isEditEventThemeByUserFlag());

    }

    @Then("the number of attendees for the event is updated successfully")
    public void theNumberOfAttendeesForTheEventIsUpdatedSuccessfully() {
        assertTrue(obj.isEditEventNumOfPeapleByUserFlag());

    }

    @Then("the event location is updated successfully")
    public void theEventLocationIsUpdatedSuccessfully() {
        assertTrue(obj.isEditLocationFlag());
    }

    @Then("the event name is updated successfully")
    public void theEventNameIsUpdatedSuccessfully() {
        assertTrue(obj.isEditEventNameByUserFlag());
    }

    @Then("the selected package  is removed from the event")
    public void theSelectedPackageIsRemovedFromTheEvent() {
        assertTrue(obj.isEditDeletePackageFromEventByUserFlag());
    }


    @When("user {string} select to edit from event {string} to add {int} Package")
    public void user_select_to_edit_from_event_to_add_package(String string, String string2, Integer int1) {
        obj.editPackage(string,string2,int1);
    }



    @Then("the selected package  is edited from the event")
    public void the_selected_package_is_edited_from_the_event() {
assertTrue(obj.isEditPackageFlag());
    }
}