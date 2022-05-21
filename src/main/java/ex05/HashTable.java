package ex05;

public class HashTable {

    // Chaining 기법 : 충돌이 일어나면 링크드 리스트를 이용하여 데이터를 추가로 뒤로 연결시키는 기법.
    private Slot[] hashTable;

    public HashTable(Integer size){
        this.hashTable  = new Slot[size];
    }

    public class Slot{ // 데이터를 저장해두는 슬롯을 생성
        String value;
        Slot(String value){
            this.value = value;
        }
    }

    // 슬롯의 주솟값 계산.
    public int hashFunc(String key){ // 문자열로 된 키값을 받아서 주소값을 계산하는 해쉬 함수를 만듬.
        return (int)(key.charAt(0)) % this.hashTable.length; // 키의 앞글자의 아스키 코드값을 구해서 배열(슬롯)의 길이로 나눈 후 나머지 값을 리턴하여 주솟 값을 찾는다.

    }

    // 데이터 저장 메소드
    public boolean saveDate(String key, String value){
        Integer address = this.hashFunc(key); // 주소를 구하고
        if(this.hashTable[address] != null){ // 기존에 존재하는 데이터면
            this.hashTable[address].value = value; // 업데이트
        }else{
            this.hashTable[address] = new Slot(value); // 존재하지 않으면 추가
        }
        return true;
    }

    // 데이터 가져오는 메소드
    public String getData(String key){ // 데이터를 가져오기 위해서는 키가 필요하므로 키를 파라미터로 받는다.
        Integer address = this.hashFunc(key);
        if(this.hashTable[address] != null){
            return hashTable[address].value; // 키가 존재하면 밸류값 리턴
        }else {
            return null; // 키가 존재하지 않으므로 값이 없다.
        }
    }

    // 하지만 현재 주솟값을 구할때 문자열의 앞글자를 가져와서 주소값을 구하므로 앞글자가 같은 경우 키가 달라도 같은 주소로 리턴이 된다
    // -> Chaining 기법 과 Linear 기법으로 해당 단점을 보완 할 수 있다.
}
