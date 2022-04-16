package se.kth.iv1350.salesProcess.model;

/**
 * Representation of the address for the store.
 */
public class AddressDTO {
    private final String streetName;
    private final String streetNumber; // Changed to string from how it was represented in the diagram
    private final String postalCode; // Changed to string from how it was represented in the diagram
    private final String city;

    /**
     * Constructor for the instantiation of an address.
     *
     * @param streetName the name of the street
     * @param streetNumber the number of the street incl letters
     * @param postalCode String representation of the format for postal codes
     * @param city the name of the city/region
     */
    public AddressDTO(String streetName, String streetNumber, String postalCode, String city) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
        this.city = city;
    }

    /**
     * Get the name of the street
     * @return the value of the street name
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * Get the street number incl letters
     * @return value of streetNumber
     */
    public String getStreetNumber() {
        return streetNumber;
    }

    /**
     * Get the postal code for the region
     * @return value of the postal code
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Get the city / region name
     * @return value of city/region
     */
    public String getCity() {
        return city;
    }
}
