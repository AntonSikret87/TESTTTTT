package ua.stqu.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.stqu.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class CreateContactTests extends TestBase {

    @Test
    public void newContactCreating() {
        app.getContactHelper().goToAddNewPage();
        List<ContactData> before = app.getContactHelper().getContactList();
        ContactData contact = new ContactData("Anton", "Olegovich", "Karabeinikov", "Sikret87", "Accesssoftek");
        app.getContactHelper().fillContactsFields(contact);
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() +1);


        contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId());
        before.add(contact);
        Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(before));
    }
}
