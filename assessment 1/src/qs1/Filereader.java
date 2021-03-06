package qs1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;



public class Filereader {

public static void main(String args[]) {
ArrayList <Merchandise> merchandise=new ArrayList<>();
try(BufferedReader read=new BufferedReader(new FileReader("C:/Users/ve00ym351/Documents/lab assessment/assessment 1/src/qs1/input.dat"))) {
String str=null;
while((str=read.readLine())!=null){
String[] element=str.split(" ");
merchandise.add(new Merchandise(element[0],Integer.parseInt(element[1]),Double.parseDouble(element[2])));
}
} catch (IOException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
for(Merchandise m : merchandise) {
m.print();
}
Collections.sort(merchandise,new SortingAsPerName());
System.out.println("Sorted as Per Name");
for(Merchandise m : merchandise) {
m.print();
}
Collections.sort(merchandise,new SortingAsPerPrice());
System.out.println("Sorted as Per Price");
for(Merchandise m : merchandise) {
m.print();
}
}
}