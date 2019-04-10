# __:bulb: [BOJ #1978번] (소수 찾기) 문제 풀이__

### :link: [[소스 코드]](https://github.com/seungrokoh/Beakjoon_OnlineJudge/blob/master/%231978/1978.java)
***

`소수`를 찾기 위해 먼저 `에라토스테네스의 체`를 이용해 소수를 판별 해 놓은 뒤 입력된 `숫자`들이 소수인지만 판별하면 되는 쉬운 문제입니다.

`소수`란 약수가 `1과 자신`밖에 없는 수를 말합니다. 즉 `합성 수`가 아니라는 뜻입니다. 이러한 성질을 이용해서 `소수를 찾는 가장 기본적인 방법`은 `2 ~ (num - 1)`의 수로 `num`이 나누어 지는지 확인하는 방법이 있습니다.

##### :seedling: 소수 판별 함수
```java
private boolean isPrime(int num) {
    for (int i = 2; i < num; i++) {
        if (num % i == 0) return false;
    }
    return true;
}
```

`하지만` 이러한 방법은 입력받는 수의 개수가 많아지거나 입력받은 수가 너무 크다면 오랜 시간이 걸리는 방법중 하나이기도 하죠. 여기서 실행 시간을 조금 단축시킬 수 있는 방법이 있다면 2 ~ (num - 1) 까지가 아닌 `2 ~ sqrt(num)`까지만 확인하면 됩니다.
##### :seedling: 소수 판별 함수(성능 개선)
```java
private boolean isPrime(int num) {
    for (int i = 2; i < Math.sqrt(num); i++) {
        if (num % i == 0) return false;
    }
    return true;
}
```

여기서 `n까지 모든 소수를 구하는 방법`이 하나 있는데 바로 `에라토스테네스의 체`라는 개념이다. 이는 매우 간단한? 아이디어이다. `모든 자연수는 소수의 곱으로 표현이 된다.` 따라서 어떤 수가 소수이려면 `나보다 작은 수의 배수가 되면 안된다`는 뜻이다. 따라서 가장 작은 소수인 2부터 시작해 배수를 걸러내고, 계속해서 확인해 올라간다면 소수를 걸러낼 수 있습니다.

##### :seedling: 에라토스테네스의 체

```java
private static void checkPrime(){
    primeNum[1] = true;
    for (int i = 2; i < Math.sqrt(1001); i++) {
        if (!primeNum[i]) {
            for (int j = i + i; j < 1001; j += i) {
                primeNum[j] = true;
            }
        }
    }
}
```
