import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Robot robot = new Robot();

     
        Task assemblyTask = new AssemblyTask();
        Task paintingTask = new PaintingTask();
        Task weldingTask = new WeldingTask();

        Task sequentialTask = new SequentialTaskDecorator(Arrays.asList(assemblyTask, paintingTask, weldingTask));

        robot.setTask(sequentialTask);
        robot.start();        
        robot.executeTask();   

        robot.pause();         
        robot.resume();        
        robot.stop();          
    }
}
