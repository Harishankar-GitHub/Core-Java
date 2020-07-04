import java.util.HashSet;
import java.util.Set;

public class HeavenlyBody {
//    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;
//    private final BodyTypes bodyType;
    private final Key key;

    // We have commented the above 2 variables because, we are using it inside Key class.
    public enum BodyTypes
    {
        // Nested Enum class is Static by default.
        // So it is possible to refer to the enum values without
        // creating the instance of HeavenlyBody Class.

        STAR,
        PLANET,
        DWARF_PLANET,
        MOON,
        COMET,
        ASTEROID
    }

    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType) {
//        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
//        this.bodyType = bodyType;
        this.key = new Key(name, bodyType);
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addSatellite(HeavenlyBody moon) {
        return this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    public Key getKey() {
        return key;
    }

    @Override
    public final boolean equals(Object obj) {
        System.out.println("equals() called");
        if(this == obj) {
            return true;
        }
//        if(obj instanceof HeavenlyBody)
//        {
//            HeavenlyBody theObject = (HeavenlyBody) obj;
//            if(this.name.equals(theObject.getName()))
//            {
//                return this.getBodyType() == theObject.getBodyType();
//            }
//        }
//        return false;

        // We have commented the above part of code because we have implemented Key class below.

        if(obj instanceof HeavenlyBody)
        {
            HeavenlyBody theObject = (HeavenlyBody) obj;
            return this.key.equals(theObject.getKey());
        }
        return false;
    }

    @Override
    public final int hashCode() {
        System.out.println("hashcode called");
//        return this.name.hashCode() + 57 + this.bodyType.hashCode();
        // We have commented the above part of code because we have implemented Key class below.
        return this.key.hashCode();
    }

    public static Key makeKey(String name, BodyTypes bodyType)
    {
        return new Key(name, bodyType);
    }

    @Override
    public String toString() {
        return this.key.getName() + " : " + this.key.getBodyType() + " : " + this.getOrbitalPeriod();
    }

    public static final class Key
    {
        private String name;
        private BodyTypes bodyType;

        private Key(String name, BodyTypes bodyType)
        {
            this.name = name;
            this.bodyType = bodyType;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyType() {
            return bodyType;
        }

        @Override
        public int hashCode() {
            return this.getName().hashCode() + 57 + this.getBodyType().hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            Key key = (Key) obj;
            if(this.getName().equals(key.getName()))
            {
                return this.getBodyType() == key.getBodyType();
            }
            return false;
        }

        @Override
        public String toString() {
            return this.getName() + " : " + this.getBodyType();
        }
    }
}