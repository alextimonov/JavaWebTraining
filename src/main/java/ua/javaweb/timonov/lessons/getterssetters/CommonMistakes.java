package ua.javaweb.timonov.lessons.getterssetters;

class Box {

    /*========= MISTAKE #1: Have setter and getter, but the variable is declared in less restricted scope ===========*/

    public String firstName;

    public void setFirstName(String fname) {
        this.firstName = fname;
    }

    public String getFirstName() {
        return this.firstName;
    }

//    Workaround for this case is using more restricted access modifier such as protected and private.


    /*========= MISTAKE #2: Assign object reference directly in setter ============*/

    private int[] scores;

    public int[] getScores() {
        return this.scores;
    }

    public void setScores(int[] scr) {
        this.scores = scr;
    }

    public void displayScores() {
        for (int i = 0; i < scores.length; i++) {
            System.out.print(scores[i] + " ");
        }
        System.out.println();
    }

}

//    And following is code that demonstrates the problem:

public class CommonMistakes {
    public static void main(String[] args) {
        CommonMistakes commonMistakes = new CommonMistakes();
        commonMistakes.runShowSetter();
//        commonMistakes.runShowGetter();
    }

    private void runShowSetter() {
        Box box = new Box();
        int[] myScores = {5, 5, 4, 3, 2, 4};
        box.setScores(myScores);
        box.displayScores();

        myScores[1] = 1;
        box.displayScores();
    }

//    That means the data can be modified outside scope of the setter method which breaks encapsulation purpose of the setter.

//    The member variable scores is assigned to the method’s parameter variable directly.
//    That means both the variables are referring the same object in memory – the myScores array object.
//    So changes made to either scores variable or myScores variable are actually made on the same object.

    /*public void setScores(int[] scr) {
        this.scores = new int[scr.length];
        System.arraycopy(scr, 0, this.scores, 0, scr.length);
    }*/

//   So, the rule of thumb is, if you pass an object reference into a setter method, then don’t copy that reference
//   into the internal variable directly. Instead, you should find some ways to copy values of the passed object
//   into the internal object


    /*========= MISTAKE #3: Return object reference directly in getter ============*/

    private void runShowGetter() {
        Box box = new Box();
        int[] myScores = {5, 5, 4, 3, 2, 4};
        box.setScores(myScores);
        box.displayScores();

        int[] copyScores = box.getScores();
        copyScores[1] = 1;
        box.displayScores();
    }

//    The getter method returns reference of the internal variable scores directly,
//    so the outside code can obtain this reference and makes change to the internal object.

//    Workaround for this case is that, instead of returning the reference directly in the getter,
//    we should return a copy of the object

    /*public int[] getScores() {
        int[] copy = new int[this.scores.length];
        System.arraycopy(this.scores, 0, copy, 0, copy.length);
        return copy;
    }*/

//    So the rule of thumb is: do not return reference of the original object in getter method.
//    Instead, it should return a copy of the original object.

}

