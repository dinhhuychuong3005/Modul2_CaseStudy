package service;

public interface Manage<T> {
    public void addEmployFullTime(T t);

    public void addEmployPartTime(T t);

    public void edit(T t);

    public void delete(T t);

    public void sort(T t);

    public void search(T t);
}
