package ia.tree;

import java.util.LinkedList;

public class Test {

	public static void main(String[] args) {
		
		LinkedList<String> list = new LinkedList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		
		NTree test = new NTree("0");
		test.addChilds(list);
		
		LinkedList<NTree> tamp = test.getChilds();
		for(NTree t : tamp) {
			t.addChilds(list);
			LinkedList<NTree> tamp2 = t.getChilds();
			for(NTree t2 : tamp2)
				t2.addChilds(list);
		}

		
		test.out(0);

	}

}