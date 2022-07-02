package sortingalgorithmvisualization;


import javafx.scene.control.Label;
import javafx.animation.TranslateTransition;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;



public class Node extends Rectangle {
    private int val;
   
    public Node(int n) {
        val = n;
    } 
    
    public int getValue() {
        return val;
    }
    
    public TranslateTransition moveX(int x) {
        TranslateTransition translation = new TranslateTransition();
        translation.setNode(this);
        translation.setDuration(Duration.millis(HomepageController.SPEED));// tốc độ chuyển giữa 2 cột
        translation.setByX(x);
        return translation;
    }
}
