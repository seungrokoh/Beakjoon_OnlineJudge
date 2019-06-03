# :page_facing_up: 기타줄 [백준 1049번]

:link: [[전체 소스 코드]](https://github.com/seungrokoh/Beakjoon_OnlineJudge/blob/master/%231049/1049.java)
:link: [[문제 풀러 가기]](https://www.acmicpc.net/problem/1049)
***
문제는 **단순 수학 문제로 해결하였습니다.** 문제의 조건을 살펴보면 다음과 같습니다.

1. 모든 브랜드에서 **세트 또는 낱개로 구매할 수 있다.**
2. 모든 브랜드에서 패키지 안에 들어있는 줄의 개수는 **6개로 동일**하다.
3. 세트 또는 낱개의 가격은 **0원 이상**이다.
4. 필요한 기타줄을 가장 싼 가격으로 구매해야 한다.

가장 싼 가격으로 필요한 기타줄을 구매하기 위해 필요한 것은 결국 **가장 낮은 구매 가격 입니다.** 즉, 모든 브랜드 중 **가장 낮은 세트 구매 가격**과 **가장 낮은 낱개 구매 가격**을 적절하게 섞어서 구매를 하면 가장 싼 가격으로 구매할 수 있습니다. 따라서 모든 브랜드의 가격 정보를 알 필요 없이 **가장 싼 세트 가격과 가장 싼 낱개 가격만 알고 있으면 됩니다.** 이제 문제를 해결할 때 고려해야 할 사항이 무엇인지 생각해보겠습니다.

세트 안에는 6개의 기타줄이 들어있습니다. 만약 **낱개 6개를 구매하는 것**보다 **1개의 세트를 구매하는게 더 싸다면** 당연히 **1개의 세트를 구매**하는 것이 좋습니다. 그 반대라면 당연히 낱개로 구매하는게 더 좋습니다. 하지만 **여기서 고려해야 할 상황**은 만약 필요한 기타줄의 개수가 **세트로 구매했을 때의 개수로 나누어 떨어지지 않을 경우(6으로 나누었을 때 나머지가 있는 경우)는 다시 고려해야 합니다.** 예제를 보며 설명해보겠습니다.

### :bulb: 예제 1
    필요한 기타줄의 개수 : 15개
    가장 싼 세트의 가격 : 40
    가장 싼 낱개의 가격 : 20

    필요한 돈의 최솟값 : 120

예제 1을 살펴보면 **낱개 6개를 사는 것보다 세트 1개를 사는게 더 저렴합니다.** 따라서 **세트 2개를 구매하고 3개의 기타줄이 남았습니다.** 이제 남은 3개의 기타줄을 사야하는데 **세트 안에 들어 있는 기타 개수보다 적게 남았습니다.** 하지만 **기타줄을 낱개로 3개 사는 가격 보다 세트 1개를 사는게 더 싸게 구매할 수 있습니다.** 따라서 3개도 **세트 1개를 구매해 충당할 수 있습니다.** 결과적으로, 세트 3개를 구매해 가장 싼 가격에 기타줄을 구매할 수 있습니다.

### :bulb: 예제 2
    필요한 기타줄의 개수 : 15개
    가장 싼 세트의 가격 : 40
    가장 싼 낱개의 가격 : 10

    필요한 돈의 최솟값 : 110

예제 2를 살펴보면 예제 1과 동일하게 낱개보다 세트를 사는게 더 저렴합니다. 따라서 **예제 1과 동일하게 세트 2개를 구매하고 3개의 기타줄이 남았습니다.** 이제 남은 3개의 기타줄을 사야하는데 예제 1과는 다르게 **세트보다 낱개로 구매하는게 더 싸게 구매할 수 있습니다.** 따라서 **남은 3개는 낱개로 구매합니다.** 결과적으로, 세트 2개와 낱개 3개로 구매해 가장 싼 가격에 기타줄을 구매할 수 있습니다.

두 예제를 살펴보면 구매할 때 고려해야 할 사항은 다음과 같이 나타낼 수 있습니다.

    min(a, b) : 둘 중 작은 값을 나타내는 함수
    ==============================
    min(구매할 수 있는 최대 세트 개수 x 세트 가격, 세트로 구매할 수 있는 기타줄 개수 x 낱개 가격)
    +
    min(세트 가격, 남은 기타줄의 개수 x 낱개 가격)

첫 번째로 **세트로 구매할 수 있는 가격**과 **세트로 구매했을 때의 개수를 낱개로 구매했을 때의 가격**을 비교하여 더 싼 가격으로 구매하고, 첫 번째 이후 **남은 개수가 있을 경우 세트로 충당하는 것과 낱개로 구매하는 것 중 싼 가격을 선택**하면 됩니다.

글보단 코드를 보면 더 이해하기 쉽습니다.

### __:seedling: main 함수__
필요한 기타줄의 수와 기타줄 브랜드의 개수를 입력 받고 solve함수를 호출합니다.
```java
public static void main(String[] args) throws IOException {
    String[] input = br.readLine().split(" ");
    int needGuitarString = Integer.parseInt(input[0]);
    int guitarStringSet = Integer.parseInt(input[1]);

    int[] minPrices = getMinPriceOfSetAndPiece(guitarStringSet);

    System.out.println(solve(minPrices, needGuitarString));

}
```
### __:seedling: getMinPrices 함수__
모든 브랜드의 가격 정보를 입력받고 브랜드들 중에서 **가장 싼 세트 가격**과 **가장 싼 낱개 가격**을 리턴하는 함수입니다.
```java
private static int[] getMinPrices(int numberOfBrands) throws IOException {
    int minSetPrice = Integer.MAX_VALUE;
    int minPiecePrice = Integer.MAX_VALUE;

    for (int i = 0; i < numberOfBrands; i++) {
        String[] priceInfo = br.readLine().split(" ");
        int setPrice = Integer.parseInt(priceInfo[0]);
        int piecePrice = Integer.parseInt(priceInfo[1]);

        if (setPrice < minSetPrice) minSetPrice = setPrice;
        if (piecePrice < minPiecePrice) minPiecePrice = piecePrice;
    }
    return new int[] {minSetPrice, minPiecePrice};
}
```
### __:seedling: solve 함수__
구매할 수 있는 가장 싼 가격을 계산하는 함수입니다.
```java
static final int NUMBER_IN_SET = 6;

private static int solve(int[] minPrices, int needGuitarString) {
    int minSetPrice = minPrices[0];
    int minPiecePrice = minPrices[1];

    if (minSetPrice == 0 || minPiecePrice == 0) return 0;

    return min((needGuitarString / NUMBER_IN_SET) * minSetPrice, (needGuitarString - (needGuitarString % NUMBER_IN_SET)) * minPiecePrice)
    + min(minSetPrice, (needGuitarString % NUMBER_IN_SET) * minPiecePrice);
}
```
### __:seedling: min 함수__
```java
private static int min(int a, int b) {
    return a < b ? a : b;
}
```
***
# __:bulb: Github에 더 많은 문제 풀이가 있습니다.__
[Programmers 문제 풀이 ](https://github.com/seungrokoh/TIL/Algorithm)

[BaekJoon Online Judge 문제 풀이](https://github.com/seungrokoh/Beakjoon_OnlineJudge)
