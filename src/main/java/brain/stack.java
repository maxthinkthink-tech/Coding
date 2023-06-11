package brain;

import java.util.LinkedList;
import java.util.List;

public class stack {
    private Integer minElement = null;
    private List<Integer> elementList = new LinkedList<>(); 

    public boolean push(Integer element) {
        if (minElement == null) {
            minElement = element;
        } else {
            if (element < minElement) {
                minElement = element;
            }
        }
        return elementList.add(element);
    }
    
    public Integer pop(Integer element) {
        return elementList.remove(0);
    }
    
    public Integer getMinElement() {
        return minElement;
    }
}
