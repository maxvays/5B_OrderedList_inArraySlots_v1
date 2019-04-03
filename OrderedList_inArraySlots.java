public class OrderedList_inArraySlots{

  private List_inArraySlots orderedList;

  public OrderedList_inArraySlots(){
    orderedList = new List_inArraySlots();
  }

  public int size(){
    return orderedList.size();
  }

  public String toString(){
    return orderedList.toString();
  }

  public void add(int value){
    if(size() == 0) orderedList.addAsHead(value);
    else{
      orderedList.add(getAddIndex(orderedList, value), value);
    }
  }

  private static int getAddIndex(List_inArraySlots list, int value){
    if(list.size() == 1){
      if(value > list.get(0)) return 1;
      else return 0;
    }
    else{
      List_inArraySlots halvedList = new List_inArraySlots();
      int size = list.size();
      if(value > list.get(size/2)){
        for(int i = size/2; i < size; i++){
          halvedList.add(i - size/2, list.get(i));
        }
        return size/2 + getAddIndex(halvedList, value);
      }
      else{
        for(int i = 0; i < size/2; i++){
          halvedList.add(i, list.get(i));
        }
        return getAddIndex(halvedList, value);
      }
    }
  }

  public int get(int index){
    return orderedList.get(index);
  }

  public int remove(int index){
    return orderedList.remove(index);
  }

}
