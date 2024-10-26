class Robot {
    protected RobotState currentState;
    protected Task currentTask;

    public Robot() {
        this.currentState = new IdleState(this);
    }

    public void setState(RobotState state) {
        this.currentState = state;
    }

    public void setTask(Task task) {
        this.currentTask = task;
    }

    public void start() {
        currentState.start();
    }

    public void pause() {
        currentState.pause();
    }

    public void resume() {
        currentState.resume();
    }

    public void stop() {
        currentState.stop();
    }

    public void executeTask() {
        currentState.executeTask();
    }
}
