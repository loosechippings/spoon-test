import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.factory.TypeFactory;
import spoon.reflect.reference.CtTypeParameterReference;
import spoon.reflect.reference.CtTypeReference;

import java.util.List;

public class SpoonTest extends AbstractProcessor<CtClass<TestTarget>> {

    public boolean isToBeProcessed(CtClass<TestTarget> targetClass) {
        TypeFactory f=getFactory().Interface();
        CtTypeReference i=f.get(InterfaceOne.class).getReference();
        return targetClass.isSubtypeOf(i);
    }

    public void process(CtClass<TestTarget> testTarget) {
        TypeFactory f=getFactory().Type();
        CtTypeParameterReference parameter = f.createTypeParameterReference("java.lang.Integer");
        CtMethod execute=testTarget.getMethod("execute", parameter);
        List<CtStatement> statements=execute.getBody().getStatements();
        for (CtStatement statement:statements) {
            System.out.println("-->"+statement.toString());
        }
    }
}
