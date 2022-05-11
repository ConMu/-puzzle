package pro09;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Code04_UnionFind {

//	public static class Element<V> {
//		public V value;
//
//		public Element(V value) {
//			this.value = value;
//		}
//
//	}
	//包装类
	public static class Element<V>{
		public V value;
		public Element(V value){
			this.value = value;
		}
}

	public static class UnionFindSet<V> {
//		//key 每个元素 value 该元素的父
//		public HashMap<V, Element<V>> elementMap;
//		//key 某个元素的代表元素， value 每个元素的父
//		public HashMap<Element<V>, Element<V>> fatherMap;
//		//key 某个元素，value 代表元素有几个
//		public HashMap<Element<V>, Integer> rankMap;
		public HashMap<V, Element<V>> elementMap;
		public HashMap<Element<V>, Element<V>> fatherMap;
		public HashMap<Element<V>,Integer> rankMap;
////初始化
//		public UnionFindSet(List<V> list) {
////			elementMap = new HashMap<>();
////			fatherMap = new HashMap<>();
////			rankMap = new HashMap<>();
////			for (V value : list) {
////				Element<V> element = new Element<V>(value);
////				elementMap.put(value, element);
////				fatherMap.put(element, element);
////				rankMap.put(element, 1);
////			}
////		}
		public UnionFindSet(List<V> list) {
			elementMap = new HashMap<>();
			fatherMap = new HashMap<>();
			rankMap = new HashMap<>();
			for (V value:list){
				Element<V> element = new Element<V>(value);
				elementMap.put(value,element);
				fatherMap.put(element,element);
				rankMap.put(element,1);
			}
		}

		private Element<V> findHead(Element<V> element) {
			Stack<Element<V>> path = new Stack<>();
			while (element != fatherMap.get(element)) {
				path.push(element);
				element = fatherMap.get(element);
			}
			while (!path.isEmpty()) {
				fatherMap.put(path.pop(), element);
			}
			return element;
		}

//		public boolean isSameSet(V a, V b) {
//			if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
//				return findHead(elementMap.get(a)) == findHead(elementMap.get(b));
//			}
//			return false;
//		}
		public boolean isSameSet(V a, V b) {
			if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
				return findHead(elementMap.get(a)) == findHead(elementMap.get(b));
			}
			return false;
		}


		public void union(V a, V b) {
			if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
				Element<V> aF = findHead(elementMap.get(a));
				Element<V> bF = findHead(elementMap.get(b));
				if (aF != bF) {
					Element<V> big = rankMap.get(aF) >= rankMap.get(bF) ? aF : bF;
					Element<V> small = big == aF ? bF : aF;
					fatherMap.put(small, big);
					rankMap.put(big, rankMap.get(aF) + rankMap.get(bF));
					rankMap.remove(small);
				}
			}
		}

	}

}
