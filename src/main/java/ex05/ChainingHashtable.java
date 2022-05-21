package ex05;

public class ChainingHashtable {

    // Chaining 기법 : 개방 해슁 또는 Open Hashing 기법 중 하나: 해쉬 테이블 저장공간 외의 공간을 활용하는 기법
    // 특정 슬롯에서 충돌이 일어나면, 링크드 리스트라는 자료 구조를 사용해서, 링크드 리스트로 데이터를 추가로 뒤에 연결시켜서 저장하는 기법

    private Slot[] hashTable;

    public ChainingHashtable(Integer size){
        this.hashTable = new Slot[size];
    }

    public class Slot{
        String key;
        String value;
        Slot next; // 링크드 리스트를 위한 포인터 값

        Slot(String key, String value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public int hashFunc(String key){
        return (int) (key.charAt(0)) & this.hashTable.length;
    }

    public boolean saveData(String key, String value){ // 링크드 리스트를 이용한 체이닝 기법.
        Integer address = this.hashFunc(key); // 해당 키에대한 주소
        if(this.hashTable[address] != null){ // 해당 슬롯이 이미 있다면,
            Slot findSlot = this.hashTable[address];
            Slot prevSlot = this.hashTable[address]; // 처음에는 둘다 맨 앞의 슬롯을 가지게 한다.(링크드 리스트의 헤드)
            while(findSlot != null){
                if(findSlot.key == key){ // findSlot의 키가 내가 찾는 키와 동일하면.
                    findSlot.value = value; // 이번에 새로 들어온 데이터로 업데이
                    return true;
                }else{ // 그렇지 않다면 순회.
                    prevSlot = findSlot;
                    findSlot = findSlot.next; // 링크드 리스트의 끝이라면 와일 구문이 종료된다.
                }
            }
            prevSlot.next = new Slot(key, value); //실질적인 findSlot의 정보는 위의 코드에 의해 prevSlot이 갖고 있다.
            // 와일구문이 끝난경우에는 내 key에 해당하는 슬롯이 없다는 뜻이므로 기존 링크드 리스트에 이어서 생성해준다.

        }else { // 해당 주소에 슬롯이 없다면 새로운 슬롯에 키와 데이터를 삽입해 준다.
            this.hashTable[address] = new Slot(key, value);
        }

        return true;
    }

    public String getData(String key){
        Integer address = hashFunc(key);

        if(this.hashTable[address] != null){
            Slot findSlot = this.hashTable[address];
            while(findSlot != null){
                if(findSlot.key == key){
                    return findSlot.value;
                }else {
                    findSlot = findSlot.next;
                }
            }
            return null;

        }else {
            return null;
        }

    }
}

