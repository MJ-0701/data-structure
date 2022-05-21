package ex05;

public class MyHashTable {

    /*
    * 키(Key)에 데이터(Value)를 매핑할 수 있는 데이터 구조
    해쉬 함수를 통해, 배열에 키에 대한 데이터를 저장할 수 있는 주소(인덱스 번호)를 계산
    Key를 통해 바로 데이터가 저장되어 있는 주소를 알 수 있으므로, 저장 및 탐색 속도가 획기적으로 빨라짐
    미리 해쉬 함수가 생성할 수 있는 주소(인덱스 번호)에 대한 공간을 배열로 할당한 후, 키에 따른 데이터 저장 및 탐색 지원
    */

    /*
    * 해쉬 함수(Hash Function): 임의의 데이터를 고정된 길이의 값으로 리턴해주는 함수
    해쉬 (Hash), 해쉬 값(Hash Value), 또는 해쉬 주소(Hash Address): 해싱 함수를 통해 리턴된 고정된 길이의 값
    해쉬 테이블(Hash Table): 키 값의 연산에 의해 직접 접근이 가능한 데이터 구조
    슬롯(Slot): 해쉬 테이블에서 한 개의 데이터를 저장할 수 있는 공간
    */

    public Slot[] hashTable;

    public MyHashTable(Integer size){
        this.hashTable = new Slot[size];
    }

    /*
    * 객체 배열 선언시, 각 배열의 아이템은 각 객체를 참조할 수 있는 주소를 담을 수 있는 공간만 할당
    각 아이템 생성시, 별도로 각 객체를 생성해줘야 함
    즉, 객체 배열 선언시, 각 생성할 객체를 가리킬 주소만 저장할 공간을 배열로 만드는 것임
*/
    public class Slot{
        String value;
        Slot(String value){
            this.value = value;
        }
    }

    // Key 가 문자열일 때, 문자열의 앞 글자를 숫자로 변환해서, Division 기법을 사용하여, Key에 대한 주소(인덱스 번호) 계산
    // Division 기법: 가장 간단한 해쉬 함수 중 하나로, 나누기를 통해, 나머지 값을 사용하는 기법

    public int hashFunctionExample(String key){
//        String name = "jack";
//        System.out.println(name.charAt(0)); // j
//        System.out.println((int)(name.charAt(0))); // 106
//        System.out.println((int)(name.charAt(0)%20)); // 6 -> 106/20 의 나머지를 return

        return (int)(key.charAt(0)) % this.hashTable.length; // this.hashTable.length : 해쉬테이블 전체의 크기

    }

    // 해쉬 테이블 클래스에 데이터 저장 메서드 추가
    public boolean saveData(String key, String value){
        Integer address = this.hashFunctionExample(key); // 데이터를 저장할 수 있는 주소값.
        if(this.hashTable[address] != null){
            this.hashTable[address].value = value;
        }else{
            this.hashTable[address] = new Slot(value);
        }
        return true;
    }

    // 데이터를 가져오는 메서드
    public String getData(String key){
        Integer address = this.hashFunctionExample(key);
        if(this.hashTable[address] != null){
            return this.hashTable[address].value;
        }else {
            return null;
        }
    }


    







}
