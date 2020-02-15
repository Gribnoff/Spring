package l1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("therapist")
@Primary
public class Therapist implements IDoctor {
    private static String specialization = "therapist";
    private IPatientCard patientCard;

    @Override
    public String getSpecialization() {
        return specialization;
    }

    @Autowired
    public void setPatientCard(IPatientCard patientCard) {
        this.patientCard = patientCard;
    }

    @Override
    public void takePatient(IPatient patient) {
        if (patientCard != null)
            System.out.println("Therapist takes patient");
    }
}
