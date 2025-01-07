#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
 
int arr[4][4], ans = 8;
int rc[10], nth[10], rotCnt[10];
 
void input() {
    for (int i = 0; i < 4; ++i)
        for (int j = 0; j < 4; ++j) 
            scanf("%d", arr[i] + j);
}
 
void rotateCol(int j) {
    int t = arr[3][j];
    for (int i = 3; i > 0; --i)
        arr[i][j] = arr[i - 1][j];
    arr[0][j] = t;
}
 
void rotateRow(int i) {
    int t = arr[i][3];
    for (int j = 3; j > 0; --j)
        arr[i][j] = arr[i][j - 1];
    arr[i][0] = t;
}
 
int rubic(int lev, int r, int c) {
    int diff = 0, i, j;
    for (i = 0; i < 16; ++i)
        diff += arr[i / 4][i % 4] != i + 1;
 
    if (ans <= lev + (diff + 3) / 4)
        return 0;
 
    if (diff == 0) {
        ans = lev;
        return 1;
    }
 
    int rv = 0;
    // Rotate Row
    for (i = r; i < 4; ++i) {
        for (j = 1; j <= 3; ++j) { // 회전 3가지
            rotateRow(i);
            if (rubic(lev + 1, i + 1, 0)) {
                rc[lev] = 1, nth[lev] = i + 1, rotCnt[lev] = j;
                rv = 1;
            }
        }
        // 한번 더 돌려서 총 4번 돌린 상태로 만들어 기존 상태로 복원
        rotateRow(i);
    }
 
 
    // Rotate Col
    for (i = c; i < 4; ++i) {
        for (j = 1; j <= 3; ++j) {
            rotateCol(i);
            if (rubic(lev + 1, 0, i + 1)) {
                rc[lev] = 2, nth[lev] = i + 1, rotCnt[lev] = j;
                rv = 1;
            }
        }
        rotateCol(i);
    }
    return rv;
}
 
void output() {
    printf("%d\n", ans);
    for (int i = 0; i < ans; ++i)
        printf("%d %d %d\n", rc[i], nth[i], rotCnt[i]);
}
 
int main() {
    // freopen("input.txt", "r", stdin);
    input();
 
    rubic(0, 0, 0);
 
    output();
}