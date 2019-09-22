package pojo;

public class Customer {
    private Long userId;
    private String name;
    private Double latitude;
    private Double longitude;
    private Double distanceFromOffice;

    public Customer() {}

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getDistanceFromOffice() {
        return distanceFromOffice;
    }

    public void setDistanceFromOffice(Double distanceFromOffice) {
        this.distanceFromOffice = distanceFromOffice;
    }

    @Override
    public boolean equals(final Object obj) {
        if(this == obj) {
            return true;
        }
        if(this.getClass() != obj.getClass()) {
            return false;
        }
        final Customer customer = (Customer)obj;
        return this.userId == customer.userId &&
                this.name == customer.name &&
                this.longitude == customer.longitude &&
                this.latitude == customer.latitude &&
                this.distanceFromOffice == customer.distanceFromOffice;
    }

    @Override
    public int hashCode() {
        return userId.intValue() * Integer.valueOf(name) * latitude.intValue() * longitude.intValue() * distanceFromOffice.intValue();
    }

    @Override
    public String toString() {
        return "Customer: {" +
                "userId=" + userId +
                "name=" + name +
                "longitude=" + longitude +
                "latitude=" + latitude +
                "distanceFromOffice=" + distanceFromOffice +
                '}';
    }
}
