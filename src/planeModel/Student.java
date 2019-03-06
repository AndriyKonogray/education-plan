package planeModel;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private int educatiion;
    private int teoreticalExpirience;
    private int practiceExpirience;
    private int discusionExpirience;
    private List<Organization> organizations = new ArrayList<>();

    public void addOrganization(Organization organization) {
        organizations.add(organization);
    }


    public int getTotalExpirience() {
        return 50;
    }
}
