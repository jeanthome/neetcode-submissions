class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        int[] res = new int[k];

        // monto mapa de frequencia
        for (int num: nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // cria lista de pares, com (freq, num)
        List<int[]> arr = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry: count.entrySet()) {
            arr.add(new int[] {entry.getValue(), entry.getKey()});
        }

        // orderna lista, com base na freq
        arr.sort((a, b) -> b[0] - a[0]);

        // monta a resposta com o primeiros k items da lista ordenada
        for (int i = 0; i < k; i++) {
            res[i] = arr.get(i)[1];
        }
        return res;
    }
}