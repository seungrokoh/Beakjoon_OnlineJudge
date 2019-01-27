#include <iostream>
#include <algorithm>
#include <cstring>

using namespace std;

char alpha[26];
char str[21];

bool checkMo(char c){
    if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
        return true;
    return false;
}
bool solve(){

    //case 1
    bool flag = false;
    for (int i = 0; i < strlen(str); i++) {
        if(checkMo(str[i])) flag = true;
    }
    if(!flag) return false;
    
    //case 2
    int jaeum = 0, moeum = 0;
    for (int i = 0; i < strlen(str); i++) {
        if(checkMo(str[i]))
            jaeum = 0, moeum++;
        else
            jaeum++, moeum = 0;
        if (jaeum == 3 || moeum == 3)
            return false;
    }

    //case 3
    for (int i = 1; i < strlen(str); i++) {
        if (str[i] == str[i - 1] && str[i] != 'e' && str[i] != 'o') {
            return false;
        }
    }

    return true;
}
int main(){
    while(true){
        cin >> str;
        if (!strcmp(str, "end")) {
            break;
        }
        if (solve()) {
            cout << "<" << str << "> is acceptable.\n";
        } else {
            cout << "<" << str << "> is not acceptable.\n";
        }
    }
}
