package ua.javaweb.timonov.lessons.getterssetters;

import java.util.Date;

public class ImplForMiscObjects {

    /* ============= PRIMITIVE TYPES =============== */
//    For primitive types, there is no special trick to correctly implement the getter and setter
//    Java copies value of one primitive to another instead of copying object reference.
//    So the mistakes #2 and #3 can be avoided.

    private float amount;

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getAmount() {
        return this.amount;
    }

    /* ============= STRING OBJECTS ================*/

//   String is an object type, but it is immutable which means once a String object is created, its String literal cannot be changed.
//   In other words, every change on that String object will result in a new String object created.
//   So, like primitive types, you can safely implement getter and setter for a String variable like this:

    private String address;

    public void setAddress(String addr) {
        this.address = addr;
    }

    public String getAddress() {
        return this.address;
    }

    /* ============= DATE OBJECTS ==================*/

//    The java.util.Date class implements clone() method from the Object class. The method clone() return a copy of the object,
//    so we can use that method for the getter and setter, like the following example:

    private Date birthDate;

    public void setBirthDate(Date date) {
        this.birthDate = (Date) date.clone();
    }

    public Date getBirthDate() {
        return (Date) this.birthDate.clone();
    }

//    The clone() method returns an Object, so we must cast it to Date type.


    /* =============== YOUR OWN TYPE ================== */

//  If you define a custom type of object, you should implement clone() method for your own type. For example

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    public Object clone() {
        Person aClone = new Person(this.name);
        return aClone;
    }
}

//    Class Person implements its clone() method to return a cloned version of itself.
//    Then the setter method should be implemented as follows:

    private Person friend;

    public void setFriend(Person person) {
        this.friend = (Person) person.clone();
    }

    public Person getFriend() {
        return (Person) this.friend.clone();
    }

//    So the rules for implementing getter and setter for a custom object type are:
//
//    Implement clone() method for the custom type.
//    Return a cloned object from the getter.
//    Assign a cloned object in the setter.

}
