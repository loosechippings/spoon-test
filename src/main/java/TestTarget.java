import java.io.Serializable;

public class TestTarget implements InterfaceTwo {
    public void execute(Integer count) {
        int total=0;
        for (int n=0;n<count;n++) {
            total+=count;
        }
        System.out.println(total);
    }

    public static void main(String[] args) {
        TestTarget testTarget=new TestTarget();
        testTarget.execute(10);
    }
}
