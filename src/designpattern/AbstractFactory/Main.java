package designpattern.AbstractFactory;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello from AbstractFactory!");

        String os = System.getProperty("os.name").toLowerCase();
        createFactory factory = os.contains("win") ? new WindownFactory() : new MacFactory();

        Button button = factory.createButton();
        button.paint();
        button.onClick();

        CheckBox checkBox = factory.createCheckBox();
        checkBox.paint();
        checkBox.onSelect();
    }
}

interface Button {
    void paint();

    void onClick();
}

interface CheckBox {
    void paint();

    void onSelect();
}

interface createFactory {
    Button createButton();

    CheckBox createCheckBox();
}

class WindowsButtton implements Button {

    @Override
    public void paint() {
        System.out.println("Windows Button");
    }

    @Override
    public void onClick() {
        System.out.println("Windows onclick!");
    }
}

class WindowsCheckBox implements CheckBox {

    @Override
    public void paint() {
        System.out.println("Windows Checkbox");
    }

    @Override
    public void onSelect() {
        System.out.println("Windows onSelect!");
    }
}

class MacButtton implements Button {

    @Override
    public void paint() {
        System.out.println("Mac Button");
    }

    @Override
    public void onClick() {
        System.out.println("Mac onclick!");
    }
}

class MacCheckBox implements CheckBox {

    @Override
    public void paint() {
        System.out.println("Mac Checkbox");
    }

    @Override
    public void onSelect() {
        System.out.println("Mac onSelect!");
    }
}

class WindownFactory implements createFactory {
    @Override
    public Button createButton() {
        return new WindowsButtton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WindowsCheckBox();
    }
}

class MacFactory implements createFactory {
    @Override
    public Button createButton() {
        return new MacButtton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacCheckBox();
    }
}
