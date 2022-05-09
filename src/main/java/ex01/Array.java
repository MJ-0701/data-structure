package ex01;

import java.util.ArrayList;
import java.util.List;

public class Array {

    String dataset[] = {
                "Braund, Mr. Owen Harris",
                "Cumings, Mrs. John Bradley (Florence Briggs Thayer)",
                "Heikkinen, Miss. Laina",
                "Futrelle, Mrs. Jacques Heath (Lily May Peel)",
                "Allen, Mr. William Henry",
                "Moran, Mr. James",
                "McCarthy, Mr. Timothy J",
                "Palsson, Master. Gosta Leonard",
                "Johnson, Mrs. Oscar W (Elisabeth Vilhelmina Berg)",
                "Nasser, Mrs. Nicholas (Adele Achem)",
                "Sandstrom, Miss. Marguerite Rut",
                "Bonnell, Miss. Elizabeth",
                "Saundercock, Mr. William Henry",
                "Andersson, Mr. Anders Johan",
                "Vestrom, Miss. Hulda Amanda Adolfina",
                "Hewlett, Mrs. (Mary D Kingcome)",
                "Rice, Master. Eugene",
                "Williams, Mr. Charles Eugene",
                "Vander Planke, Mrs. Julius (Emelia Maria Vandemoortele)",
                "Masselmani, Mrs. Fatima",
                "Fynney, Mr. Joseph J",
                "Beesley, Mr. Lawrence",
                "McGowan, Miss. Anna",
                "Sloper, Mr. William Thompson",
                "Palsson, Miss. Torborg Danira",
                "Asplund, Mrs. Carl Oscar (Selma Augusta Emilia Johansson)",
                "Emir, Mr. Farred Chehab",
                "Fortune, Mr. Charles Alexander",
                "Dwyer, Miss. Ellen",
                "Todoroff, Mr. Lalio"
             };


     public void arrayList(){
         List<Integer> list1 = new  ArrayList<Integer>();
         list1.add(1); // 배열에 아이템 추가
         list1.add(2);
         System.out.println(list1.get(0)); // 배열의 특정 아이템을 읽을시 -> 1
         list1.set(0,5); // 특정 인덱스에 해당하는 값을 변경시 set(변경할 인덱스 번호, 변경할 값)
         System.out.println(list1.get(0)); // -> 5
         list1.remove(0); // 해당 인덱스의 데이터 삭제
         System.out.println(list1.get(0)); // -> 앞의 0번인덱스엿던 5가 지워졋으므로 2
         System.out.println(list1.size()); // 배열의 길이 확인 -> 1
     }

     public void arrayMcount(){
         int count = 0;
         for(String e : dataset){
             if(e.indexOf("M") >0){ // 문자열.indexOf() -> 문자 key 가 해당 문자열 안에 있으면 해당 문자의 위치 (index) 값을 리턴하고, 없으면 -1 을 리턴함.
                count ++;
             }
         }
         System.out.println(count);
     }




}
