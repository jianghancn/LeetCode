package com.company;

import java.util.*;

class Program {
    public static List<List<Integer>> powerset(List<Integer> array) {
        // Write your code here.
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> emptyList = new ArrayList<>();
        res.add(emptyList);
        helper(array, 0, res);
        return res;
    }
    static void helper(List<Integer> array,  int newIdx, List<List<Integer>> res){
        if(newIdx >= array.size() ) return;

        res.addAll(res);

        for(int i = res.size()/2; i<res.size(); i++ ) {
            res.get(i).add(array.get(newIdx));
        }
        helper(array, newIdx+1, res);
    }
// 	static void helper(List<Integer> array,  int newIdx, List<List<Integer>> res){
// 		if(newIdx >= array.size() ) return;

// 		List<List<Integer>> additional = new ArrayList<>();

// 		additional.addAll(res);
// 		for(List<Integer> x : additional) {
// 			x.add(array.get(newIdx));
// 		}
// 		res.addAll(additional);
// 		helper(array, newIdx+1, res);
// 	}
}

