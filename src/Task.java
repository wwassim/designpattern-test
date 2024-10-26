import java.util.List;

interface Task {
    void executeTask();
}

class AssemblyTask implements Task {
    @Override
    public void executeTask() {
        System.out.println("Executing assembly task");
    }
}

class PaintingTask implements Task {
    @Override
    public void executeTask() {
        System.out.println("Executing painting task");
    }
}

class WeldingTask implements Task {
    @Override
    public void executeTask() {
        System.out.println("Executing welding task");
    }
}
