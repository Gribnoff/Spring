package l1;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
class Registry implements IRegistry {
    private static HashMap<String, Integer> map = new HashMap<>();
    static {
        map.put("therapist", 304);
        map.put("surgeon", 512);
    }

    @Override
    public int showOffice(IDoctor doctor) {
        return map.get(doctor.getSpecialization());
    }
}
