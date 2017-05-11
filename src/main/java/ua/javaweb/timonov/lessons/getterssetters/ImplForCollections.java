package ua.javaweb.timonov.lessons.getterssetters;

import java.util.ArrayList;
import java.util.List;

public class ImplForCollections {

//    As described in mistake #2 and mistake #3, it’s not good to have setter and getter methods like this:

    private List<String> listTitles;

    public void setListTitles(List<String> titles) {
        this.listTitles = titles;
    }

    public List<String> getListTitles() {
        return this.listTitles;
    }

//    Consider the following:

    public static void main(String[] args) {
        ImplForCollections app = new ImplForCollections();
        List<String> titles1 = new ArrayList<>();
        titles1.add("Name");
        titles1.add("Address");
        titles1.add("Email");
        titles1.add("Job");

        app.setListTitles(titles1);

        System.out.println("Titles 1 before change via ref: " + titles1);
        titles1.set(2, "Habilitation");
        System.out.println("Titles 1 after  change via ref: " + titles1);

        System.out.println();

        List<String> titles2 = app.getListTitles();
        System.out.println("Titles 2 before change via ref: " + titles2);
        titles2.set(0, "Full name");
        List<String> titles3 = app.getListTitles();
        System.out.println("Titles 2 after  change via ref: " + titles3);
    }

//    For a collection of Strings, one solution is to use the constructor that takes another collection as argument,
//    for example we can change code of the above getter and setter as follows

    public void setListStringTitles(List<String> titles) {
        this.listTitles = new ArrayList<>(titles);
    }

    public List<String> getListStringTitles() {
        return new ArrayList<>(this.listTitles);
    }

//    NOTE: The constructor approach above is only working with collections of Strings, but it will not work for collections objects.
//    Only references are copied, so that’s why two collections are distinct but they contain same objects.

//    Look at the collection API we found that ArrayList, HashMap, HashSet, … implement their own clone() methods,
//    these methods return shallow copies which do not copy elements from the source collection to the destination.

//    Thus we cannot use the clone()method of these collection classes.
//    The solution is to implement the clone()method for our own defined object – the Person class in the above example.
//    We implement the clone()method in the Person class as follows:

    class Person {
        private String name;

        public Person(String name) {
            this.name = name;
        }

        public Object clone() {
            Person aClone = new Person(this.name);
            return aClone;
        }
    }

    private List<Person> listPeople;

//    The setter & getter for listPeople are modified as follows:

    public void setListPeople(List<Person> listPeople) {
        this.listPeople = new ArrayList<>();
        for (Person aPerson : listPeople) {
            this.listPeople.add((Person) aPerson.clone());
        }
    }

    public List<Person> getListPeople() {
        List<Person> listReturn = new ArrayList<>();
        for (Person aPerson : this.listPeople) {
            listReturn.add((Person) aPerson.clone());
        }
        return listReturn;
    }
}

//    So key points for implementing getter and setter for collection type are:

//    For collection of String objects: does not need any special tweak since String objects are immutable.

//    For collection of custom types of object:
//    Implement clone() method for the custom type.
//    For the setter, add cloned items from source collection to the destination one.
//    For the getter, create a new collection which is being returned.
//    Add cloned items from the original collection to the new one.

