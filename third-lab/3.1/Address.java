public class Address {
    private String city;
    private String streetAddress;
    private long zioCode;

    public Address(String city, String streetAddress, long zipCode) {
        this.city = city;
        this.streetAddress = streetAddress;
        this.zioCode = zipCode;
    }

    public String toString() {
        return this.streetAddress + ", " + this.city + ", " + this.zioCode;
    }
}