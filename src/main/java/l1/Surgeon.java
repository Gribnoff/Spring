package l1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("surgeon")
class Surgeon implements IDoctor {
    private static String specialization = "surgeon";
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
            System.out.println("Surgeon takes patient");
    }
}
