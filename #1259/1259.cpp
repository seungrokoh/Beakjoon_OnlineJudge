#include <cstdio>
#include <cstring>
using namespace std;
bool isPalindrome(char *s) {
    int len = strlen(s);

    for (int idx = 0 ; idx < len / 2; ++idx) {
        if (s[idx] != s[len - idx - 1]) {
            return false;
        }
    }
    return true;
}
int main()
{
    bool result = false;
    char in[100000] = {0, };

    scanf("%s", &in);
    while (strcmp(in, "0")) {
        printf("%s\n", isPalindrome(in) ? "yes" : "no");
        scanf("%s", &in);
    }

    return 0;
}
