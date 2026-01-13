import java.util.HashMap;
import java.util.Map;

public class DialingCodes {

    private Map<Integer, String> dialingCode = new HashMap<>();

    public Map<Integer, String> getCodes() {
        return dialingCode;
    }

    public void setDialingCode(Integer code, String country) {
        getCodes().put(code, country);
    }

    public String getCountry(Integer code) {
        return getCodes().get(code);
    }

    public void addNewDialingCode(Integer code, String country) {
        if(!getCodes().containsKey(code) && !getCodes().containsValue(country)) {
            setDialingCode(code, country);
        }
    }

    public Integer findDialingCode(String country) {
        for(Integer code : getCodes().keySet()) {
            if(getCodes().get(code) == country) {
                return code;
            }
        }
        return null;
    }

    public void updateCountryDialingCode(Integer code, String country) {
        getCodes().remove(findDialingCode(country));
        setDialingCode(code, country);
    }
}
