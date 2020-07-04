public class Labrador extends Dog {

    public Labrador(String name) {
        super(name);
    }

//    @Override
    // Commenting this because, equals() is marked as final in parent class.
    // It is marked as final because, if we want to consider parent class & child class
    // objects equal then we can implement equals() only in parent class (Refer Dog Class for implementation).
    // If we want to consider parent class object and child class object different then we can
    // implement equals() which is in HeavenlyBody Class.



//    public boolean equals(Object obj) {
//        if(this == obj) {
//            return true;
//        }
//
//        if(obj instanceof Labrador) {
//            String objName = ((Labrador) obj).getName();
//            return this.getName().equals(objName);
//        }
//
//        return false;
//    }
}
