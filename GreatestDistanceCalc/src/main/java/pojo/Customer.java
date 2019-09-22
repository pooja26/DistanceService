package pojo;

import javafx.util.Builder;

public class Customer {
    private final Long userId;
    private final String name;
    private final Double latitude;
    private final Double longitude;
    private final Double distanceFromOffice;

    private Customer(CustomerBuilder builder) {
        this.userId = builder.userId;
        this.name = builder.name;
        this.latitude = builder.latitude;
        this.longitude = builder.longitude;
        this.distanceFromOffice = builder.distanceFromOffice;
    }

    public Long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getDistanceFromOffice() {
        return distanceFromOffice;
    }

    public static final class CustomerBuilder {
        private Long userId;
        private String name;
        private Double latitude;
        private Double longitude;
        private Double distanceFromOffice;

        public CustomerBuilder userId(final Long userId) {
            this.userId = userId;
            return this;
        }

        public CustomerBuilder name(final String name) {
            this.name = name;
            return this;
        }

        public CustomerBuilder latitude(final Double latitude) {
            this.latitude = latitude;
            return this;
        }

        public CustomerBuilder longitude(final Double longitude) {
            this.longitude = longitude;
            return this;
        }

        public CustomerBuilder distanceFromOffice(final Double distanceFromOffice) {
            this.distanceFromOffice = distanceFromOffice;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
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
