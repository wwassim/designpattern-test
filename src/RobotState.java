abstract class RobotState {
    protected Robot robot;

    public RobotState(Robot robot) {
        this.robot = robot;
    }

    abstract void start();
    abstract void pause();
    abstract void resume();
    abstract void stop();
    abstract void executeTask();
}

class PausedState extends RobotState {
    public  PausedState(Robot robot) {
        super(robot);
    }

    @Override
    void start() {
        System.out.println("Robot cannot start while paused.");
    }

    @Override
    void pause() {
        System.out.println("Robot is already paused.");
    }

    @Override
    void resume() {
        System.out.println("Resuming robot.");
        robot.setState(new RunningState(robot));
    }

    @Override
    void stop() {
        System.out.println("Stopping robot from paused state.");
        robot.setState(new IdleState(robot));
    }

    @Override
    void executeTask() {
        System.out.println("Cannot execute task while paused.");
    }
}

class RunningState extends RobotState {
    public RunningState(Robot robot) {
        super(robot);
    }

    @Override
    void start() {
        System.out.println("Robot is already running.");
    }

    @Override
    void pause() {
        System.out.println("Pausing robot.");
        robot.setState(new PausedState(robot));
    }

    @Override
    void resume() {
        System.out.println("Robot is already running.");
    }

    @Override
    void stop() {
        System.out.println("Stopping robot.");
        robot.setState(new IdleState(robot));
    }

    @Override
    void executeTask() {
        if (robot.currentTask != null) {
            robot.currentTask.executeTask();
        } else {
            System.out.println("No task to execute.");
        }
    }
}

class IdleState extends RobotState {
    public IdleState(Robot robot) {
        super(robot);
    }

    @Override
    void start() {
        System.out.println("Starting robot.");
        robot.setState(new RunningState(robot));
    }

    @Override
    void pause() {
        System.out.println("Robot is idle. Cannot pause.");
    }

    @Override
    void resume() {
        System.out.println("Robot is idle. Cannot resume.");
    }

    @Override
    void stop() {
        System.out.println("Robot is already idle.");
    }

    @Override
    void executeTask() {
        System.out.println("Robot is idle. No task to execute.");
    }
}
