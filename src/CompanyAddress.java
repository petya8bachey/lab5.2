import java.util.ArrayList;

public class CompanyAddress {
    String country;
    String city;
    String street;
    Integer house;
    CompanyAddress left = null;
    CompanyAddress right = null;

    public long stringToInt(String str) {
        long resolute = 0L;
        if (str == null) {
            return 0L;
        }
        for (int i = 0; i < str.length(); i++) {
            resolute += (long) str.charAt(i);
        }
        return resolute;
    }

    public int getValue() {
        return house;
    }

    public long classToInt() {
        return (stringToInt(country) * 3) + (stringToInt(city) * 5) + (stringToInt(street) * 7) + house * 13L;
    }

    public void collision(CompanyAddress companyAddress) {
        int value = companyAddress.getValue();
        CompanyAddress currentAddress = this;
        CompanyAddress parentAddress;
        while (true) {
            parentAddress = currentAddress;
            if (value == currentAddress.getValue()) {
                return;
            } else if (value < currentAddress.getValue()) {
                currentAddress = currentAddress.left;
                if (currentAddress == null) {
                    parentAddress.left = companyAddress;
                    return;
                }
            } else {
                currentAddress = currentAddress.right;
                if (currentAddress == null) {
                    parentAddress.right = companyAddress;
                    return;
                }
            }
        }

    }

    public ArrayList<CompanyAddress> toArray() {
        ArrayList<CompanyAddress> result = new ArrayList<>();
        if (left != null) {
            result.addAll(left.toArray());
        }
        if (right != null) {
            result.addAll(right.toArray());
        }
        if (result.isEmpty()) {
            result.add(this);
        }
        return result;
    }

    @Override
    public String toString() {
        String result = country  + " " + city + " " + street + " " + house + " ";
        if (left != null) {
            result += left.toString();
        }
        if (right != null) {
            result += right.toString();
        }
        return result;
    }
}