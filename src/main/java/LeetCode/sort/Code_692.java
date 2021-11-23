package LeetCode.sort;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-05-25 12:48
 **/

import org.junit.Test;

import java.util.*;

/**
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 * <p>
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 * <p>
 * 示例 1：
 * <p>
 * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 * 注意，按字母顺序 "i" 在 "love" 之前。
 * <p>
 * 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
 * 输入的单词均由小写字母组成。
 */
public class Code_692 {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        PriorityQueue<String> queue = new PriorityQueue<>((o1, o2) -> {
            int falg = map.get(o2) - map.get(o1);
            return falg == 0 ? o1.compareTo(o2) : falg;
        });
        map.keySet().forEach(key -> queue.add(key));
        ArrayList<String> res = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            res.add(queue.poll());
        }
        return res;
    }

    @Test
    public void test() {

    }
}
