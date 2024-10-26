class SequentialTaskDecorator implements Task {
    private List<Task> tasks;

    public SequentialTaskDecorator(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public void executeTask() {
        for (Task task : tasks) {
            task.executeTask();
        }
    }
}
