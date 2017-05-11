package ua.javaweb.timonov.lessons.getterssetters;

public class NamingConvention {

//    The naming scheme of setter and getter should follow Java bean naming convention as follows:
//    getXXX() and setXXX()

//    If the variable is of type boolean, then the getter’s name can be either isXXX() or getXXX(),
//    but the former naming is preferred. For example:

    private boolean single;

    public boolean isSingle() {
        return this.single;
    }

}
