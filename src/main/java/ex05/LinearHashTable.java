package ex05;

import java.util.Objects;

public class LinearHashTable {

    /*
    Linear Probing 기법
    폐쇄 해슁 또는 Close Hashing 기법 중 하나: 해쉬 테이블 저장공간 안에서 충돌 문제를 해결하는 기법
    충돌이 일어나면, 해당 hash address의 다음 address부터 맨 처음 나오는 빈공간에 저장하는 기법
    저장공간 활용도를 높이기 위한 기법
    */

    private Slot[] hashTable;

    public LinearHashTable(Integer size){
        this.hashTable = new Slot[size];
    }


    public class Slot{
        private String key;
        private String value;
        Slot(String key, String value){
            this.key = key;
            this.value = value;
        }
    }

    public int hashFunc(String key){
        return (int) (key.charAt(0)) % this.hashTable.length;
    }

    public boolean saveData(String key, String value){
        Integer address = this.hashFunc(key);
        if(this.hashTable[address] != null){
            if(this.hashTable[address].key == key){
                this.hashTable[address].value = value; // 업데이트
                return true;
            }else{
                Integer currAddress = address + 1;
                while(this.hashTable[currAddress] != null){
                    if(this.hashTable[currAddress].key == key){
                        this.hashTable[currAddress].value = value; // 업데이트
                        return true;
                    }else{
                        currAddress++;
                        if(currAddress >= this.hashTable.length){ // 해당 주소가 배열의 맨 끝이라면
                            return false;
                        }
                    }

                }
                this.hashTable[currAddress] = new Slot(key, value); // while 구문을 통과한다는 것은 해당 데이터가 해당 주소에 없다는 뜻이므로 새로 만들어준다.
            }
        }else{
            this.hashTable[address] = new Slot(key, value);
        }
        return true;
    }

    public String getData(String key){
        Integer address = this.hashFunc(key);
        if(this.hashTable[address] != null){
            if(Objects.equals(this.hashTable[address].key, key)){
                return this.hashTable[address].value;
            }else{
                Integer currAddress = address;
                while(this.hashTable[currAddress] != null){
                    if(Objects.equals(this.hashTable[currAddress].key, key)){
                        return this.hashTable[currAddress].value;
                    }else{
                        currAddress++;
                        if(currAddress >= this.hashTable.length){
                            return null;
                        }
                    }
                }
                return null;
            }

        }else{
            return null;
        }

    }
}
