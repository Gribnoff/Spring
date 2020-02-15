package l1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
class Patient implements IPatient {
    @Value("John Doe")
    private String name;
    private IDoctor doctorToGo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Autowired
//    @Qualifier("surgeon")
    public void setComplaint(IDoctor doctor) {
        this.doctorToGo = doctor;
    }

    @Override
    public void goToHospital(IRegistry registry) {
        System.out.println("Patient goes to hospital");
        System.out.printf("Patient goes to %s who is in office №%d\n", doctorToGo.getClass().getSimpleName(), registry.showOffice(doctorToGo));
        doctorToGo.takePatient(this);
    }
}
