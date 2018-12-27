#include <iostream>
#include <queue>
using namespace std;

int main() {
    int n, m;
    cin >> n >> m;

    queue<int> qu;

    for (int i = 1; i <= n; i++) {
        qu.push(i);
    }

    cout << "<";
    int number;
    while (qu.size() > 1) {
        for (int i = 0; i < m-1; i++) {
            number = qu.front();
            qu.pop();
            qu.push(number);
        }
        cout << qu.front() << ", ";
        qu.pop();
    }

    cout << qu.front() << ">";

    return 0;
}
