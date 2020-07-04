public class Planet extends HeavenlyBody {

    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyTypes.PLANET);
    }

    @Override
    public boolean addSatellite(HeavenlyBody moon) {
        if(moon.getKey().getBodyType() == BodyTypes.PLANET)
        {
            super.addSatellite(moon);
            return true;
        }
        else
        {
            return false;
        }
    }
}
