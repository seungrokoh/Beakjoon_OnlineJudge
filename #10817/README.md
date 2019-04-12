# __:bulb: [BOJ #10817번] (카드 구매하기) 문제 풀이__

### :link: [[소스 코드]](https://github.com/seungrokoh/Beakjoon_OnlineJudge/blob/master/%2310817/10817.java)
***

너무나 쉬운문제 입니다. 주어진 수를 정렬한 뒤 가운데 숫자를 출력하면 됩니다.

```java
private static void solve(String[] input) {
    int[] nums = new int[input.length];
    for (int i = 0; i < input.length; i++) {
        nums[i] = Integer.parseInt(input[i]);
    }
    Arrays.sort(nums);
    System.out.println(nums[1]);
}
```

문제의 분류가 if문이기 때문에 if문으로 풀어보는 것도 좋은 방법인 것 같습니다.
