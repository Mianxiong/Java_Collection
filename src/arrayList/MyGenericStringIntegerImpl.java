package arrayList;

public class MyGenericStringIntegerImpl implements  MyGenericI<String, Integer>{
    @Override
    public Integer getElement(String param) {
        return Integer.parseInt(param);
    }

    public <T> void setConfiguration(String configName, T config) {

    }

    public <T> T getConfig(String name) {
        return null;
    }

    public <B,A> B doSometing(A something) {
        System.out.println("Do something");
        return null;
    }

    public static void main(String[] args) {
        MyGenericI<String,Integer> myGenericI = new MyGenericStringIntegerImpl();
        MyGenericStringIntegerImpl myGenericStringInteger = new MyGenericStringIntegerImpl();
        Integer result = myGenericStringInteger.doSometing("Homework");
        Boolean booleanResult = myGenericStringInteger.doSometing(new Long(100));

    }
}
