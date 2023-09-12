package chatbot;

import chatbot.exception.InvalidTaskNumberException;
import chatbot.task.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    /** TaskList for the Chatbot. */
    private List<Task> taskList;

    /**
     * Constructor for the TaskList.
     */
    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    /**
     * Adds given task to the taskList.
     *
     * @param newTask The task to be added.
     */
    public void add(Task newTask) {
        this.taskList.add(newTask);
    }

    /**
     * Returns the current size of the taskList.
     */
    public int size() {
        return this.taskList.size();
    }

    /**
     * Returns the String representation of the task with the given index.
     *
     * @param i The index of the task.
     * @returns The String representation of the task.
     */
    public String taskRep(int i) {
        return taskList.get(i).toString();
    }

    /**
     * Marks the task with the given index as done.
     *
     * @param i The index of the task.
     */
    public void markTaskTrue(int i) {
        taskList.get(i).markStatus(true);
    }

    /**
     * Marks the task with the given index as undone.
     *
     * @param i The index of the task.
     */
    public void markTaskFalse(int i) {
        taskList.get(i).markStatus(false);
    }

    /**
     * Removes the task with the given index.
     *
     * @param i The index of the task.
     * @throws InvalidTaskNumberException If there is no task with the given index in the taskList.
     */
    public void delete(int i) throws InvalidTaskNumberException {
        try {
            this.taskList.remove(i);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidTaskNumberException(i + 1);
        }
    }

    /**
     * Returns a new TaskList containing all the tasks in this taskList with the matching keyword.
     *
     * @param keyword The keyword to match with.
     * @returns A TaskList with the matching tasks.
     */
    public TaskList find(String keyword) {
        TaskList res = new TaskList();
        for (Task task : this.taskList) {
            if (task.toString().toLowerCase().contains(keyword.toLowerCase())) {
                res.add(task);
            }
        }
        return res;
    }
}
