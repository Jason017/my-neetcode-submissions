class Solution {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str).append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }

    public List<String> decode(String str) {
        String[] list = str.split(" ");
        return new ArrayList<>(Arrays.asList(list));
    }
}
