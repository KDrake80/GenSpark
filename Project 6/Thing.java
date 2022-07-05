/*
Kevin Drake
Class to Define the Thing Object, Parent class to Land, and Humanoid.
*/
public abstract class Thing {
    // Sets a Value for the UTF reference
    private String value = "V";

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
