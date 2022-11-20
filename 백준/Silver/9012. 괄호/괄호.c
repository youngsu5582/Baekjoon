#include <stdio.h>
#pragma warning(disable:4996)
#include <stdlib.h>
#include <string.h>

int main() {
	int T;
	scanf("%d", &T);
	//getchar();
	char data[50];
	int VPS[10000];
	int num = 0;
	for (int i = 0; i < T; i++) {
		int count = 0;
		scanf("%s", data);
		for (int i = strlen(data) - 1; i >= 0; i--) {
			if (data[i] == ')')count++;
			else count--;
			if (count < 0)break;
		}
		if (count == 0)VPS[num++] = 1;
		else VPS[num++] = 0;
	}
	for (int i = 0; i < num; i++) {
		if (VPS[i] == 1)printf("YES\n");
		else printf("NO\n");
	}
}