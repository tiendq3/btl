package sortingalgorithmvisualization;

import java.util.ArrayList;
import java.util.Arrays;
import javafx.scene.paint.Color;
import javafx.animation.ParallelTransition;
import javafx.animation.Transition;


public class InsertionSort extends AbstractSort{
   
    private ArrayList<Transition> transitions;
    
    public InsertionSort() {
        this.transitions = new ArrayList<>();
    }
    
    @Override
    public ArrayList <Transition> startSort(Node[] nodes) {
    	 transitions.add(colorNode(nodes, SORTED_COLOR, 0));
        for (int i = 1; i < nodes.length; i++) {
            int j = i - 1, idx = i;
            Node number = nodes[i];			// lưu node[i] vào number
            ParallelTransition p = new ParallelTransition();        
            transitions.add(colorNode(nodes, SELECT_COLOR, i));          
            while (j >= 0 && nodes[j].getValue() > number.getValue()) { 		// các Node sau i và trước Node đầu tiên nhỏ hơn i dịch chuyển 1 đoạn X,
                p.getChildren().add(nodes[j].moveX(X));            
                nodes[j+1] = nodes[j];
                transitions.add(colorNode(nodes, SORTED_COLOR, j));              // mảng đã sắp xếp sẽ có màu cam
                j--;	
            }
            nodes[j+1] = number;
            
            p.getChildren().add(number.moveX(X * (j+1-i)));
            p.getChildren().add(colorNode(nodes, SORTED_COLOR, j+1));
            transitions.add(p);
          
        }
        transitions.add(colorNode(Arrays.asList(nodes), FINAL_COLOR));
        
        return transitions;
    }
}
