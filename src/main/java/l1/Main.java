package l1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        IPatient patient = context.getBean(IPatient.class);
        IRegistry registry = context.getBean(IRegistry.class);
        patient.goToHospital(registry);
    }
}
