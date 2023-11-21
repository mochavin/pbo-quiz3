package predictivegui;

class Main {
    public static void main(String[] args) {
        View view = new View();
        Model model = new Model();
        Controller.instance = new Controller(view, model);
    }
}