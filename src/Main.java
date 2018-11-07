import java.util.ArrayList;
import squarifiedTreemap.squarifiedTreemap;
public class Main {
	public static void main(String[] args)
	{
		ArrayList<Double> nodeArea = new ArrayList<Double>();
		nodeArea.add(500.0);
		nodeArea.add(433.0);
		nodeArea.add(78.0);
		nodeArea.add(25.0);
		nodeArea.add(25.0);
		nodeArea.add(7.0);
		squarifiedTreemap tree = new squarifiedTreemap(nodeArea, 700, 433, true);
		tree.calcTreemap();
		System.out.println(tree.outputTreemap());
	}
}
