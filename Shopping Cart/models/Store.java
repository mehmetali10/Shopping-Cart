package models;

public class Store {
    private Item[][] itemsArray ;

    public Store() {
        itemsArray = new Item[7][3];
    }

    public Item getItem(int row, int column) {
        return new Item(itemsArray[row][column]);
    }

    public void setItem(int row, int column, Item item) {
        itemsArray[row][column] = new Item(item);
    }

    public String toString() {
      String temp = "";  

      for(int i=0; i<itemsArray.length; i++) {
        switch (i) {
            case 0: temp += "\tDRINKS:        "; break;
            case 1: temp += "\tCEREAL:        "; break;
            case 2: temp += "\tDAIRY:         "; break; 
            case 3: temp += "\tDELI:          "; break; 
            case 4: temp += "\tGREENS:        "; break; 
            case 5: temp += "\tCLOTHING:      "; break; 
            case 6: temp += "\tELECTRONICS:   "; break; 
        }
          for(int j=0; j<itemsArray[i].length; j++) {
              temp += itemsArray[i][j].toString();
          }
          temp += "\n\n";
      }
      return temp;
    }

    
}
