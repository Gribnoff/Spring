package l1;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class PrototypeTest {
    private static final String NAME = "John Doe";
    private static final String NAME_OTHER = "Jane Doe";

    @Test
    public void prototypeScopeTest() {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Patient patientPrototypeA = (Patient) context.getBean(IPatient.class);
        Patient patientPrototypeB = (Patient) context.getBean(IPatient.class);

        patientPrototypeA.setName(NAME);
        patientPrototypeB.setName(NAME_OTHER);

        Assert.assertEquals(NAME, patientPrototypeA.getName());
        Assert.assertEquals(NAME_OTHER, patientPrototypeB.getName());

        context.close();
    }
}
