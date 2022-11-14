package com.burra.practice.softwareAg;

public class Test {
    public static void main(String[] args){
      Person p1 = new Person("name1", 1);
      Person p11 = new Person("name1", 1);
      Person p2 = new Person("name2", 2);

      System.out.println(p1.equals(p11));
      System.out.println(p1.equals(p2));

      Employee e1 = new Employee("name1", 1, "se");
      Employee e11 = new Employee("name1", 1, "se");
      Employee e2 = new Employee("employee2", 2, "se2");

      System.out.println(e1.equals(e11));
      System.out.println(e1.equals(e2));

      System.out.println(e1.equals(p1));
      System.out.println(p1.equals(e1));

      Statistic sc = SingletonStatisticImpl.getInstance();
      int[] arr = new int[] {70, 80, 90, 10, 20, 30, 40, 50, 60};
      for(int i : arr) {
        sc.event(i);
        System.out.println(sc.maximum() + " " + sc.minimum() + " " + sc.mean() + " " + sc.variance());
      }

    }
}
