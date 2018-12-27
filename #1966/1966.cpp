#include <iostream>
#include <queue>
using namespace std;

int main() {
    int n, m, t;
    int input, count;

    cin >> t;
    for (int test = 0; test < t; test++) {
        //테스트 케이스 만큼
        cin >> n >> m;
        count = 0;
        queue<pair<int, int>> qu;
        priority_queue<int> pqu;

        //data input
        for (int i = 0; i < n; i++) {
            scanf("%d", &input);
            qu.push({i, input});
            pqu.push(input);
        }

        while(true) {
            int index = qu.front().first;
            int value = qu.front().second;
            qu.pop();

            if (pqu.top() == value) {
                pqu.pop();
                count++;
                if (index == m) {
                    break;
                }
            } else {
                qu.push({index, value});
            }
        }

        cout << count << "\n";
    }

    return 0;
}
