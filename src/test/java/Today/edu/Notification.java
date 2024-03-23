package Today.edu;

import io.cucumber.java.en.*;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;



public class Notification {
    public boolean place = false;
    public boolean update = false;
    public boolean ready = false;

    public MyAppT obj;
    private String userRole;
    public Notification (MyAppT iobj) {
        super();
        this.obj = iobj;
    }

    @Given("I'm the user")
    public void i_m_the_user() {
      boolean b=obj.isUserFlag();
    }

    @When("the user {string} select service {int}")
    public void the_user_select_service(String string, Integer int1) {
       update=true;

    }

    @Then("Send email to {string} with message {string}")
    public void send_email_to_with_message(String string, String string2) {
        obj.sendEmailTo(string,string2);
    }


    @When("the user create event")
    public void the_user_create_event() {
   ready=true;
    }

}
