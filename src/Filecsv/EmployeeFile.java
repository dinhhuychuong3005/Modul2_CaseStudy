package Filecsv;

import model.employee.Employee;
import model.employee.EmployeeFullTime;
import model.employee.EmployeePartTime;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeFile {
    public static void writeToFile(String path, List<Employee> list) throws IOException {
        FileWriter fw = new FileWriter(path);
        BufferedWriter bf = new BufferedWriter(fw);
        String str = "ID,Name,Gender,Age,Email,NumberPhone,basicSalary,Status,typeEmployee,actualSalary\n";
        for (Employee e : list) {
            if (e instanceof EmployeeFullTime) {
                EmployeeFullTime ef = (EmployeeFullTime) e;
                str += ef.getId() + "," + ef.getName() + "," + ef.getGender() + "," + ef.getAge() + "," + ef.getEmail() +
                        "," + ef.getNumberPhone() + "," + ef.getSalary() + "," + ef.getStatus() + "," + "FullTime" +
                        "," + ef.calculateSalary() + "\n";
            } else if (e instanceof EmployeePartTime) {
                EmployeePartTime ep = (EmployeePartTime) e;
                str += ep.getId() + "," + ep.getName() + "," + ep.getGender() + "," + ep.getAge() + "," + ep.getEmail() +
                        "," + ep.getNumberPhone() + "," + ep.getSalary() + "," + ep.getStatus() + "," + "PartTime" +
                        "," + ep.calculateSalary() + "\n";
            }
        }
        bf.write(str);
        bf.close();
        fw.close();
    }
    public static List<Employee> readFromFile(String path) throws IOException {
        List<Employee> employeeList = new ArrayList<>();
        FileReader fr = new FileReader(path);
        BufferedReader bf = new BufferedReader(fr);
        String line = bf.readLine();
        while ((line = bf.readLine()) != null){
            String[] value = line.split(",");
            if (value[8].equals("FullTime")){
                employeeList.add(new EmployeeFullTime(value[0],value[1],value[2],Integer.parseInt(value[3]),value[4],value[5],Long.parseLong(value[6]),value[7],value[8],Long.parseLong(value[9])));
            }else  if (value[8].equals("PartTime")){
                employeeList.add(new EmployeePartTime(value[0],value[1],value[2],Integer.parseInt(value[3]),value[4],value[5],Long.parseLong(value[6]),value[7],value[8],Long.parseLong(value[9])));
            }
        }
        return employeeList;
    }
}
