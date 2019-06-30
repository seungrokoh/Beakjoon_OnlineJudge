# :page_facing_up: 수들의 합 2 [백준 2003번]

:link: [[전체 소스 코드]](https://github.com/seungrokoh/Beakjoon_OnlineJudge/blob/master/%232003/2003.java)
:link: [[문제 풀러 가기]](https://www.acmicpc.net/problem/2003)
***
# __문제 해설__

문제는 **구간합 배열(Prefix Sum)을 이용해** 해결하였습니다.  
문제에서 주어지는 **수열의 구간합을 미리 구한 뒤 구간합 중 target이 존재하는지 판단하는 순**으로 문제를 해결할 수 있습니다.

> 구간합 배열에 대한 정보를 얻고 싶으시다면 [라이(kks277)님 블로그 글](https://blog.naver.com/kks227/220787178657)을 참고하시기 바랍니다.

### __문제 조건__

1. 수열의 i번째 수부터 j번째 수까지의 합이 target이 되는 경우의 수를 구하여라

i번째 부터 j번째까지 순차적으로 구간합을 찾는 과정 중 만약 target보다 합이 높다면 더 이상 검색을 하지 않아도 됩니다. 왜냐하면 합은 뒤로 갈 수록 커지기 때문에 이미 target을 넘었다면 더 이상 검색할 필요가 없기 때문입니다.

글보단 코드를 보면 더 이해하기 쉽습니다.
***
### __:seedling: main 함수__

```java
public static void main(String[] args) throws IOException {
    String[] input = br.readLine().split(" ");
    int n = Integer.parseInt(input[0]);
    int m = Integer.parseInt(input[1]);

    String[] nums = br.readLine().split(" ");

    int[] prefixSum = makePrefixSum(nums, n);

    solve(prefixSum, m);
}
```

### __:seedling: solve 함수__
구간합 중 target의 갯수를 세는 함수입니다.
```java
private static void solve(int[] prefixSum, int target) {
    int cnt = 0;
    int len = prefixSum.length;

    for (int i = 0; i < len; i++) {
        for (int j = i + 1; j < len; j++) {
            int sum = prefixSum[j] - prefixSum[i];
            if (sum > target) break;
            if (sum == target) {
                cnt++;
                break;
            }
        }
    }
    System.out.println(cnt);
}
```

### __:seedling: makePrefixSum 함수__
구간합 배열을 만드는 함수입니다.
```java
private static int[] makePrefixSum(String[] nums, int n) {
    int[] prefixSum = new int[n + 1];
    for (int i = 0; i < n; i++) {
        prefixSum[i + 1] = prefixSum[i] + Integer.parseInt(nums[i]);
    }
    return prefixSum;
}
```

***
# __:bulb: Github에 더 많은 문제 풀이가 있습니다.__
[Programmers 문제 풀이 ](https://github.com/seungrokoh/TIL/Algorithm)

[BaekJoon Online Judge 문제 풀이](https://github.com/seungrokoh/Beakjoon_OnlineJudge)
